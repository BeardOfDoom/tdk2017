package hu.david.veres.graph.thread;

import hu.david.veres.graph.dto.ProcessDTO;
import hu.david.veres.graph.form.ProblemForm;
import hu.david.veres.graph.generator.ResultGenerator;
import hu.david.veres.graph.model.Result;
import hu.david.veres.graph.service.ProcessService;
import hu.david.veres.graph.service.StorageService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.SolutionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
@Scope("prototype")
@Getter
@Setter
@NoArgsConstructor
public class ProcessThread implements Runnable {

    private String processIdentifier;
    private SolutionManager solutionManager;
    private String algorithmName;
    private String heuristicFunction;

    @Autowired
    private ProcessService processService;

    @Autowired
    private StorageService storageService;

    @Autowired
    private ResultGenerator resultGenerator;

    @Override
    public void run() {

        // GET OUTPUT FILE NAME
        // TODO: default empty file name or null?
        String absoluteFileName = "";
        switch (algorithmName) {
            case "BackTrackSimple":
                absoluteFileName = solutionManager.doBackTrackSimple(heuristicFunction);
                break;
            case "BackTrackCircle":
                absoluteFileName = solutionManager.doBackTrackCircle(heuristicFunction);
                break;
            case "BackTrackPathLengthLimitation":
                absoluteFileName = solutionManager.doBackTrackPathLengthLimitation(heuristicFunction);
                break;
            case "BackTrackOptimal":
                absoluteFileName = solutionManager.doBackTrackOptimal(heuristicFunction);
                break;
            case "BreadthFirst":
                absoluteFileName = solutionManager.doBreadthFirst(heuristicFunction);
                break;
            case "DepthFirst":
                absoluteFileName = solutionManager.doDepthFirst(heuristicFunction);
                break;
            case "Optimal":
                absoluteFileName = solutionManager.doOptimal(heuristicFunction);
                break;
            case "BestFirst":
                absoluteFileName = solutionManager.doBestFirst(heuristicFunction);
                break;
            case "A":
                absoluteFileName = solutionManager.doA(heuristicFunction);
                break;
        }

        // CHECK IF FILE EXISTS
        File file = new File(absoluteFileName);
        if (!file.exists()) {
            finishAndUpdateProcess(processIdentifier, true, "error.file.file.not.exists");
            return;
        }

        // GENERATE RESULT
        Result result = null;
        try {
            result = resultGenerator.generate(file);
        } catch (IOException e) {
            // storageService.deleteUploadedFile(processIdentifier);
            finishAndUpdateProcess(processIdentifier, true, null);
            e.printStackTrace();
            return;
        }

        // STORE FILES
        try {
            storageService.storeResultInJsonFile(result, processIdentifier);
        } catch (IOException e) {
            // storageService.deleteUploadedFile(processIdentifier);
            finishAndUpdateProcess(processIdentifier, true, null);
            e.printStackTrace();
            return;
        }

        // UPDATE DATABASE
        finishAndUpdateProcess(processIdentifier, false, null);

    }

    private void finishAndUpdateProcess(String processIdentifier, boolean error, String errorMessage) {

        ProcessDTO processDTO = processService.getProcessByIdentifier(processIdentifier);
        processDTO.setDone(true);
        processDTO.setError(error);
        processDTO.setErrorMessage(errorMessage);
        processService.save(processDTO);

    }

}
