package hu.david.veres.graph.thread;

import antlr.impl.IncorrectInputException;
import exceptions.*;
import generator.OperatorGenerator;
import generator.ProjectGenerator;
import generator.StateGenerator;
import hu.david.veres.graph.form.ProblemForm;
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
import java.io.FileWriter;
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

    private List<String> processIdentifiers;
    private ProblemForm problemForm;

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void run() {

        // Laci
        StateGenerator stateGenerator = new StateGenerator();
        OperatorGenerator operatorGenerator = new OperatorGenerator();
        InputReader inputReader = new InputReader();
        ProjectRepresentation projectRepresentation = null;

        File file = new File("sml_input.txt");
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(problemForm.getStateSpace());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            projectRepresentation = inputReader.processInputFile(file.getAbsolutePath());
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
            // TODO: name?
            classRepresentations = projectGenerator.generate(projectRepresentation, "generated", "com.prototype");
        } catch (IOException e) {
            e.printStackTrace();
            // TODO
        }

        ClassManager classManager = new ClassManager();
        classManager.addClasses(classRepresentations);

        // Ádám
        try {

            SolutionMaker solutionMaker = new SolutionMaker(classManager.getFilePaths());
            SolutionManager solutionManager = solutionMaker.start();

            // Dávid
            for(int i=0; i<processIdentifiers.size(); i++) {

                ProcessThread processThread = applicationContext.getBean(ProcessThread.class);
                processThread.setProcessIdentifier(processIdentifiers.get(i));
                processThread.setSolutionManager(solutionManager);
                processThread.setAlgorithmName(problemForm.getAlgorithms().get(i));
                processThread.setHeuristicFunction(problemForm.getHeuristic());
                threadPoolTaskExecutor.execute(processThread);

            }

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

    }

}
