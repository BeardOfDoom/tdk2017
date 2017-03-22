package main;

import exceptions.*;
import interfaces.OperatorInterface;
import interfaces.StateInterface;
import model.UserInput;
import nodes.*;
import org.apache.commons.io.FilenameUtils;
import solutionsearchers.*;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionMaker {
	
	private List<String> filePaths;
	private UserInput userInput;
	private File classDestinationFile;
	private URL classDestinationURL;
	private List<File> loadableClasses;
	private Class<?> stateClass;
	private List<Class<?>> operatorClasses;
	
	public SolutionMaker(List<String> filePaths, UserInput userInput) throws TemporaryFolderCreationException, MalformedURLException{
		this.filePaths = filePaths;
		this.userInput = userInput;
		classDestinationFile = new File("externalClasses/");
		makeTemporaryFolderForClasses();
		classDestinationURL = classDestinationFile.toURI().toURL();
		loadableClasses = new ArrayList<>();
		operatorClasses = new ArrayList<>();
	}
	
	public void start() throws WrongFileExtensionException, CompilationException, IOException, ClassNotFoundException, StateNotFoundException, OperatorNotFoundException, StateInitializationException, OperatorInitializationException, TemporaryFolderDeletionException{
		validateFilePaths();
		compileFiles();
		getLoadableClassesInFolder(classDestinationFile);
		loadClasses();
		initAndStartChosenSolutionSearchers();
		if(!deleteFolder(classDestinationFile)){
			throw new TemporaryFolderDeletionException("Could not delete this folder: " + classDestinationFile.getAbsolutePath());
		}
	}
	
	private void validateFilePaths() throws WrongFileExtensionException{
		for(String filePath : filePaths){
			if(!FilenameUtils.isExtension(filePath, "java")){
				throw new WrongFileExtensionException();
			}
		}
	}
	
	private void makeTemporaryFolderForClasses() throws TemporaryFolderCreationException{
		try{
			if(!classDestinationFile.exists()){
				classDestinationFile.mkdirs();
			}
		} catch (Exception e){
			throw new TemporaryFolderCreationException(e);
		}
	}
	
	private void compileFiles() throws CompilationException, IOException{
		List<String> processBuilderArgList = new ArrayList<>(Arrays.asList("javac", "-d", classDestinationURL.getPath(), "-nowarn"/*, getClass().getClassLoader().getResource("interfaces/StateInterface.java").getPath(), getClass().getClassLoader().getResource("interfaces/OperatorInterface.java").getPath()*/));
		processBuilderArgList.addAll(filePaths);
		
		ProcessBuilder processBuilder = new ProcessBuilder(processBuilderArgList);
		Process process = processBuilder.start();
		while(process.isAlive());
		BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			
		StringBuilder compilationError = new StringBuilder();
		String line = null;
		while((line = errorReader.readLine()) != null){
			compilationError.append(line);
		}
		
		if(!compilationError.toString().isEmpty()){
			throw new CompilationException(compilationError.toString());
		}
	}
	
	private void getLoadableClassesInFolder(File folder){
		if(folder.isDirectory()){
			for(File file : folder.listFiles()){
				getLoadableClassesInFolder(file);
			}
			for (File classFile : folder.listFiles(new FilenameFilter() {
				public boolean accept(File dir, String name) {
					return name.endsWith(".class");
				}
			})) {
				loadableClasses.add(classFile);
			}
		}
	}
	
	private void loadClasses() throws ClassNotFoundException, IOException, StateNotFoundException, OperatorNotFoundException{
		boolean isStateClassFound = false;
		boolean isOperatorClassFound = false;
		URLClassLoader loader = new URLClassLoader(new URL[] { classDestinationURL });
		for (File classFile : loadableClasses) {
			String classNameAndPackage = classFile.getAbsolutePath()
					.replace(classDestinationFile.getAbsolutePath() + "\\", "").replace("\\", ".");
			
			classNameAndPackage = classNameAndPackage.substring(0, classNameAndPackage.length() - 6);
			Class<?> cls = loader.loadClass(classNameAndPackage);
			if (StateInterface.class.isAssignableFrom(cls) && !StateInterface.class.equals(cls)) {
				stateClass = cls;
				isStateClassFound = true;
			} else if (OperatorInterface.class.isAssignableFrom(cls) && !OperatorInterface.class.equals(cls)) {
				operatorClasses.add(cls);
				isOperatorClassFound = true; 
			}
		}
		
		loader.close();
		
		if(!isStateClassFound){
			throw new StateNotFoundException();
		} else if(!isOperatorClassFound){
			throw new OperatorNotFoundException();
		}
	}
	
	private List<String> initAndStartChosenSolutionSearchers() throws StateInitializationException, OperatorInitializationException{
		List<String> outputFilePaths = new ArrayList<>();
		OperatorInstantiator operatorInstantiator = new OperatorInstantiator();
		List<OperatorInterface> OPERATORS = operatorInstantiator.getOperatorInstances(operatorClasses);
		
		StateInterface state = null;
		try {
			state = (StateInterface) stateClass.getConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new StateInitializationException(e);
		}
		
		if(userInput.isDoBackTrackSimple()){
			BackTrackSimpleNode backTrackSimpleNodeStart = new BackTrackSimpleNode(state.getStart(), null, null, 0, new ArrayList<>());
			BackTrackSimple backTrackSimple = new BackTrackSimple(backTrackSimpleNodeStart, OPERATORS);
			outputFilePaths.add(backTrackSimple.search());
		}
		
		if(userInput.isDoBackTrackCircle()){
			BackTrackCircleNode backTrackCircleNodeStart = new BackTrackCircleNode(state.getStart(), null, null, 0, new ArrayList<>());
			BackTrackCircle backTrackCircle = new BackTrackCircle(backTrackCircleNodeStart, OPERATORS);
			outputFilePaths.add(backTrackCircle.search());
		}

		if (userInput.isDoBackTrackPathLengthLimitation()) {
			BackTrackPathLengthLimitationNode backTrackPathLengthLimitationNode = new BackTrackPathLengthLimitationNode(state.getStart(), null, null, 0, new ArrayList<>(), 0);
			BackTrackPathLengthLimitation backTrackPathLengthLimitation = new BackTrackPathLengthLimitation(backTrackPathLengthLimitationNode, 10, OPERATORS);
			outputFilePaths.add(backTrackPathLengthLimitation.search());
		}

		if (userInput.isDoBackTrackOptimal()) {
			BackTrackOptimalNode backTrackOptimalNode = new BackTrackOptimalNode(state.getStart(), null, null, 0, new ArrayList<>(), 0);
			BackTrackOptimal backTrackOptimal = new BackTrackOptimal(backTrackOptimalNode, 10, OPERATORS);
			outputFilePaths.add(backTrackOptimal.search());
		}

		if (userInput.isDoBreadthFirst()) {
			BreadthFirstNode breadthFirstNode = new BreadthFirstNode(state.getStart(), null, null, 0, 0);
			BreadthFirst breadthFirst = new BreadthFirst(breadthFirstNode, OPERATORS);
			outputFilePaths.add(breadthFirst.search());
		}

		if (userInput.isDoDepthFirst()) {
			DepthFirstNode depthFirstNode = new DepthFirstNode(state.getStart(), null, null, 0, 0);
			DepthFirst depthFirst = new DepthFirst(depthFirstNode, OPERATORS);
			outputFilePaths.add(depthFirst.search());
		}

		if (userInput.isDoOptimal()) {
			OptimalNode optimalNode = new OptimalNode(state.getStart(), null, null, 0, 0);
			Optimal optimal = new Optimal(optimalNode, OPERATORS);
			outputFilePaths.add(optimal.search());
		}

		if (userInput.isDoBestFirst()) {
			BestFirstNode bestFirstNode = new BestFirstNode(state.getStart(), null, null, 0, "", null);
			BestFirst bestFirst = new BestFirst(bestFirstNode, "", null, OPERATORS);
			outputFilePaths.add(bestFirst.search());
		}

		if (userInput.isDoA()) {
			ANode aNode = new ANode(state.getStart(), null, null, 0, 0, "", null);
			A a = new A(aNode, "", null, OPERATORS);
			outputFilePaths.add(a.search());
		}
		
		return outputFilePaths;
	}
	
	public static boolean deleteFolder(File file) {
		if (file.isDirectory()) {
			for (File childOfFile : file.listFiles()) {
				deleteFolder(childOfFile);
			}
		}
		return file.delete();
	}
}
