package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import model.UserInput;
import nodes.ANode;
import nodes.BackTrackCircleNode;
import nodes.BackTrackOptimalNode;
import nodes.BackTrackPathLengthLimitationNode;
import nodes.BackTrackSimpleNode;
import nodes.BestFirstNode;
import nodes.BreadthFirstNode;
import nodes.DepthFirstNode;
import nodes.OptimalNode;
import solutionsearchers.A;
import solutionsearchers.BackTrackCircle;
import solutionsearchers.BackTrackOptimal;
import solutionsearchers.BackTrackPathLengthLimitation;
import solutionsearchers.BackTrackSimple;
import solutionsearchers.BestFirst;
import solutionsearchers.BreadthFirst;
import solutionsearchers.DepthFirst;
import solutionsearchers.Optimal;

public class SolutionMaker {
	
	private List<String> filePaths;
	private UserInput userInput;
	private File classDestinationFile;
	private URL classDestinationURL;
	private List<File> loadableClasses;
	private Class<?> stateClass;
	private List<Class<?>> operatorClasses;
	
	public SolutionMaker(List<String> filePaths, UserInput userInput){
		this.filePaths = filePaths;
		this.userInput = userInput;
		classDestinationFile = new File("externalClasses/");
		makeTemporaryFolderForClasses();
		try {
			classDestinationURL = classDestinationFile.toURI().toURL();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loadableClasses = new ArrayList<>();
		operatorClasses = new ArrayList<>();
	}
	
	public void start(){
		validateFilePaths();
		compileFiles();
		getLoadableClassesInFolder(classDestinationFile);
		loadClasses();
		initAndStartChosenSolutionSearchers();
		deleteFolder(classDestinationFile);
	}
	
	private void validateFilePaths(){
		// TODO validate file formats
	}
	
	private void makeTemporaryFolderForClasses(){
		// TODO exception
		if(!classDestinationFile.exists()){
			classDestinationFile.mkdirs();
		}
	}
	
	private void compileFiles(){
		// TODO exception try-t kivenni
		List<String> processBuilderArgList = new ArrayList<>(Arrays.asList("javac", "-d", classDestinationURL.getPath(), getClass().getClassLoader().getResource("interfaces/StateInterface.java").getPath(), getClass().getClassLoader().getResource("interfaces/OperatorInterface.java").getPath()));
		processBuilderArgList.addAll(filePaths);
		
		ProcessBuilder processBuilder = new ProcessBuilder(processBuilderArgList);
		try {
			Process process = processBuilder.start();
			while(process.isAlive());
			BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			String line = null;
			while((line = errorReader.readLine()) != null){
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	private void loadClasses(){
		boolean isStateClassFound = false;
		boolean isOperatorClassFound = false;
		URLClassLoader loader = new URLClassLoader(new URL[] { classDestinationURL });
		for (File classFile : loadableClasses) {
		    try {
		    	String classNameAndPackage = classFile.getAbsolutePath().replace(classDestinationFile.getAbsolutePath() + "\\", "").replace("\\", ".");
		    	classNameAndPackage = classNameAndPackage.substring(0, classNameAndPackage.length() - 6);
		        Class<?> cls = loader.loadClass(classNameAndPackage);
		        if(StateInterface.class.isAssignableFrom(cls) && !StateInterface.class.equals(cls)){
		        	stateClass = cls;
		        	isStateClassFound = true;
		        } else if(OperatorInterface.class.isAssignableFrom(cls) && !OperatorInterface.class.equals(cls)){
		        	operatorClasses.add(cls);
		        	//operatorClass.getMethod("initOperators").invoke(operatorClass.newInstance());
		        	//isOperatorClassFound = true;
		        }
		    } catch (Exception ex) {
		    	// TODO generated
		    	ex.printStackTrace();
		    }
		}
		try {
			loader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!isStateClassFound){
			// TODO exception
		} else if(!isOperatorClassFound){
			// TODO exception
		}
	}
	
	private void initAndStartChosenSolutionSearchers(){
		OperatorInstantiator operatorInstantiator = new OperatorInstantiator();
		List<OperatorInterface> OPERATORS = operatorInstantiator.getOperatorInstances(operatorClasses);
		
		// TODO try kivétele
		StateInterface state = null;
		try {
			state = (StateInterface) stateClass.getConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
			| InvocationTargetException | NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(userInput.isDoBackTrackSimple()){
			BackTrackSimpleNode backTrackSimpleNodeStart = new BackTrackSimpleNode(state.getStart(), null, null, 0, new ArrayList<>());
			BackTrackSimple backTrackSimple = new BackTrackSimple(backTrackSimpleNodeStart, OPERATORS);
			backTrackSimple.search();
		}
		
		if(userInput.isDoBackTrackCircle()){
			BackTrackCircleNode backTrackCircleNodeStart = new BackTrackCircleNode(state.getStart(), null, null, 0, new ArrayList<>());
			BackTrackCircle backTrackCircle = new BackTrackCircle(backTrackCircleNodeStart, OPERATORS);
			backTrackCircle.search();
		}

		if (userInput.isDoBackTrackPathLengthLimitation()) {
			BackTrackPathLengthLimitationNode backTrackPathLengthLimitationNode = new BackTrackPathLengthLimitationNode(state.getStart(), null, null, 0, new ArrayList<>(), 0);
			BackTrackPathLengthLimitation backTrackPathLengthLimitation = new BackTrackPathLengthLimitation(backTrackPathLengthLimitationNode, 10, OPERATORS);
			backTrackPathLengthLimitation.search();
		}

		if (userInput.isDoBackTrackOptimal()) {
			BackTrackOptimalNode backTrackOptimalNode = new BackTrackOptimalNode(state.getStart(), null, null, 0, new ArrayList<>(), 0);
			BackTrackOptimal backTrackOptimal = new BackTrackOptimal(backTrackOptimalNode, 10, OPERATORS);
			backTrackOptimal.search();
		}

		if (userInput.isDoBreadthFirst()) {
			BreadthFirstNode breadthFirstNode = new BreadthFirstNode(state.getStart(), null, null, 0, 0);
			BreadthFirst breadthFirst = new BreadthFirst(breadthFirstNode, OPERATORS);
			breadthFirst.search();
		}

		if (userInput.isDoDepthFirst()) {
			DepthFirstNode depthFirstNode = new DepthFirstNode(state.getStart(), null, null, 0, 0);
			DepthFirst depthFirst = new DepthFirst(depthFirstNode, OPERATORS);
			depthFirst.search();
		}

		if (userInput.isDoOptimal()) {
			OptimalNode optimalNode = new OptimalNode(state.getStart(), null, null, 0, 0);
			Optimal optimal = new Optimal(optimalNode, OPERATORS);
			optimal.search();
		}

		if (userInput.isDoBestFirst()) {
			BestFirstNode bestFirstNode = new BestFirstNode(state.getStart(), null, null, 0, "", null);
			BestFirst bestFirst = new BestFirst(bestFirstNode, "", null, OPERATORS);
			bestFirst.search();
		}

		if (userInput.isDoA()) {
			ANode aNode = new ANode(state.getStart(), null, null, 0, 0, "", null);
			A a = new A(aNode, "", null, OPERATORS);
			a.search();
		}
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
