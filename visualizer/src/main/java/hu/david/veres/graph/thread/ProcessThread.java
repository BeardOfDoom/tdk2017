package hu.david.veres.graph.thread;

import antlr.impl.IncorrectInputException;
import exceptions.*;
import generator.OperatorGenerator;
import generator.ProjectGenerator;
import generator.StateGenerator;
import hu.david.veres.graph.dto.ProcessDTO;
import hu.david.veres.graph.exception.result.ResultValidationException;
import hu.david.veres.graph.form.ProblemForm;
import hu.david.veres.graph.form.ProblemFormUtil;
import hu.david.veres.graph.generator.ResultGenerator;
import hu.david.veres.graph.model.Result;
import hu.david.veres.graph.service.ProcessService;
import hu.david.veres.graph.service.StorageService;
import hu.david.veres.graph.validator.ResultValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.SolutionMaker;
import misc.ClassManager;
import misc.InputReader;
import model.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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
@Getter
@Setter
@NoArgsConstructor
public class ProcessThread implements Runnable {

    private String processIdentifier;
    private String absoluteFileName;
    private String stateSpaceFileName;
    private ProblemForm problemForm;

    @Autowired
    private ProcessService processService;

    @Autowired
    private StorageService storageService;

    @Autowired
    private ResultGenerator resultGenerator;

    @Autowired
    private ResultValidator resultValidator;

    @Override
    public void run() {

        // Laci
        StateGenerator stateGenerator = new StateGenerator();
        OperatorGenerator operatorGenerator = new OperatorGenerator();
        InputReader inputReader = new InputReader();
        ProjectRepresentation projectRepresentation = null;
        try {
            projectRepresentation = inputReader.processInputFile(stateSpaceFileName);
        } catch (IOException e) {
            e.printStackTrace();
            // TODO
        } catch (IncorrectInputException e) {
            e.printStackTrace();
            // TODO
        }

        ProjectGenerator projectGenerator = new ProjectGenerator(stateGenerator, operatorGenerator);
        List<ClassRepresentation> classRepresentations = new ArrayList<>();
        try {
            classRepresentations = projectGenerator.generate(projectRepresentation, "generated", "com.prototype");
        } catch (IOException e) {
            e.printStackTrace();
            // TODO
        }

        ClassManager classManager = new ClassManager();
        classManager.addClasses(classRepresentations);

        // Ádám
        UserInput userInput = ProblemFormUtil.extractUserInput(problemForm);
        SolutionMaker solutionMaker = null;
        List<String> outputPaths = new ArrayList<>();
        try {
            solutionMaker = new SolutionMaker(classManager.getFilePaths(), userInput);
            outputPaths = solutionMaker.start();
        } catch (TemporaryFolderCreationException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (WrongFileExtensionException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (TemporaryFolderDeletionException e) {
            e.printStackTrace();
        } catch (CompilationException e) {
            e.printStackTrace();
        } catch (OperatorNotFoundException e) {
            e.printStackTrace();
        } catch (OperatorInitializationException e) {
            e.printStackTrace();
        } catch (StateInitializationException e) {
            e.printStackTrace();
        } catch (StateNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // CHECK THE REQUIRED FIELDS
        /*
        if (processIdentifier == null || absoluteFileName == null) {
            finishAndUpdateProcess(processIdentifier, true, "error.unexpected.error");
            return;
        }
        */

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
            storageService.deleteUploadedFile(processIdentifier);
            finishAndUpdateProcess(processIdentifier, true, null);
            e.printStackTrace();
            return;
        }

        // VALIDATE RESULT
        try {
            resultValidator.validate(result);
        } catch (ResultValidationException e) {
            storageService.deleteUploadedFile(processIdentifier);
            finishAndUpdateProcess(processIdentifier, true, null);
            e.printStackTrace();
            return;
        }

        // STORE FILES
        try {
            storageService.storeResultInJsonFile(result, processIdentifier);
        } catch (IOException e) {
            storageService.deleteUploadedFile(processIdentifier);
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
