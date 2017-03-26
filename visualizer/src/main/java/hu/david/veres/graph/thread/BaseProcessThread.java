package hu.david.veres.graph.thread;

import antlr.impl.IncorrectInputException;
import exceptions.*;
import generator.OperatorGenerator;
import generator.ProjectGenerator;
import generator.StateGenerator;
import hu.david.veres.graph.dto.ProcessDTO;
import hu.david.veres.graph.form.ProblemForm;
import hu.david.veres.graph.service.ProcessService;
import hu.david.veres.graph.service.StorageService;
import hu.david.veres.graph.util.ProcessUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.SolutionMaker;
import main.SolutionManager;
import misc.ClassManager;
import misc.InputReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import representation.ClassRepresentation;
import representation.ProjectRepresentation;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
@NoArgsConstructor
@Getter
@Setter
public class BaseProcessThread implements Runnable {

    private static final String ERROR_MESSAGE_IOEXCEPTION = "IOException";

    private List<String> processIdentifiers;
    private ProblemForm problemForm;

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private StorageService storageService;

    @Autowired
    private ProcessService processService;

    @Override
    public void run() {

        // Laci
        StateGenerator stateGenerator = new StateGenerator();
        OperatorGenerator operatorGenerator = new OperatorGenerator();
        InputReader inputReader = new InputReader();
        ProjectRepresentation projectRepresentation = null;

        File file = null;
        // TODO: temporary file name!!!
        String fileName = ProcessUtils.generateStateSpaceFileName();
        try {
            file = storageService.storeStateSpace(problemForm.getStateSpace(), fileName);
        } catch (IOException e) {
            // TODO
            failAllProcesses(processIdentifiers, ERROR_MESSAGE_IOEXCEPTION);
            e.printStackTrace();
            return;
        }

        try {
            projectRepresentation = inputReader.processInputFile(file.getAbsolutePath());
        } catch (IOException e) {
            failAllProcesses(processIdentifiers, ERROR_MESSAGE_IOEXCEPTION);
            e.printStackTrace();
            return;
            // TODO
        } catch (IncorrectInputException e) {
            failAllProcesses(processIdentifiers, e.getMsg());
            e.printStackTrace();
            return;
            // TODO
        }

        ProjectGenerator projectGenerator = new ProjectGenerator(stateGenerator, operatorGenerator);
        List<ClassRepresentation> classRepresentations = new ArrayList<>();
        try {
            // TODO: name?
            classRepresentations = projectGenerator.generate(projectRepresentation, "generated", "com.prototype");
        } catch (IOException e) {
            failAllProcesses(processIdentifiers, ERROR_MESSAGE_IOEXCEPTION);
            e.printStackTrace();
            return;
            // TODO
        }

        ClassManager classManager = new ClassManager();
        classManager.addClasses(classRepresentations);

        // Ádám
        try {

            SolutionMaker solutionMaker = new SolutionMaker(classManager.getFilePaths());
            SolutionManager solutionManager = solutionMaker.start();

            // Dávid
            for (int i = 0; i < processIdentifiers.size(); i++) {

                ProcessThread processThread = applicationContext.getBean(ProcessThread.class);
                processThread.setProcessIdentifier(processIdentifiers.get(i));
                processThread.setSolutionManager(solutionManager);
                processThread.setAlgorithmName(problemForm.getAlgorithms().get(i));
                processThread.setHeuristicFunction(problemForm.getHeuristic());
                threadPoolTaskExecutor.execute(processThread);

            }

        } catch (TemporaryFolderCreationException e) {
            failAllProcesses(processIdentifiers, e.getMessage());
            e.printStackTrace();
            return;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return;
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        } catch (WrongFileExtensionException e) {
            e.printStackTrace();
            return;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        } catch (TemporaryFolderDeletionException e) {
            e.printStackTrace();
            return;
        } catch (CompilationException e) {
            e.printStackTrace();
            return;
        } catch (OperatorNotFoundException e) {
            e.printStackTrace();
            return;
        } catch (OperatorInitializationException e) {
            e.printStackTrace();
            return;
        } catch (StateInitializationException e) {
            e.printStackTrace();
            return;
        } catch (StateNotFoundException e) {
            e.printStackTrace();
            return;
        } catch (IOException e) {
            failAllProcesses(processIdentifiers, ERROR_MESSAGE_IOEXCEPTION);
            e.printStackTrace();
            return;
        }
        // TODO: handle exceptions

    }

    // TODO: we have to fail all processes there
    private void failAllProcesses(List<String> processIdentifiers, String errorMessage) {

        for (String processIdentifier : processIdentifiers) {

            ProcessDTO processDTO = processService.getProcessByIdentifier(processIdentifier);
            processDTO.setDone(true);
            processDTO.setError(true);
            processDTO.setErrorMessage(errorMessage);
            processService.save(processDTO);

        }

    }

}
