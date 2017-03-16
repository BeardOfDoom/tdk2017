package main;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import interfaces.StateInterface;
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

public class Main {
	
	// TODO hogy érdemes tárolni a dolgokat? vagy legyen funkció? sebesség vs memória spórolás. Tesztelni meik mit tud. Mind2 kell.
		// sebesség: mindent memóriában tárolunk.
		// memória spórolás: mindent kiírunk fájlba, memóriában csak azt tároljuk amit mindenképp szükséges.

	// TODO megfelelő helyre másolás DONEish
	// TODO valamilyen segitséget nyujtani hogy az interfaceket könnyen elérje a felhasználó
		
	// TODO BackTrackPathLengthLimitation-nél és BackTrackOptimal-nál limit javaslat funkció
	// TODO Heurisztikára ajánlás?
	// TODO generáljanak kimenetet a keresők
	// TODO érdekes részek kiemelése
	
	// TODO statisztika opció (külön szálakon elindul az összes keresés)

	private static final String JAVA = ".java";
	
	private static List<File> loadableClasses = new ArrayList<>();
	
	public static boolean deleteDir(File file) {
		if (file.isDirectory()) {
			for (File childOfFile : file.listFiles()) {
				deleteDir(childOfFile);
			}
		}
		return file.delete();
	}
	
	private static void getLoadableClassesInFolderAndSubFolders(File folder){
		if(folder.isDirectory()){
			for(File file : folder.listFiles()){
				getLoadableClassesInFolderAndSubFolders(file);
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
	
	public static void main(String[] args) throws IOException, ClassNotFoundException{	
		/*String stateClassFilePath = "C:\\workspace\\Prototypes\\src\\Hanoi\\State.java";
		String stateInterfaceFilePath = "C:\\workspace\\SzakdogaTMP\\src\\main\\java\\interfaces\\StateInterface.java";
		String operatorClassFilePath = "C:\\workspace\\Prototypes\\src\\Hanoi\\Operator.java";
		String operatorInterfaceFilePath = "C:\\workspace\\SzakdogaTMP\\src\\main\\java\\interfaces\\OperatorInterface.java";*/
		
		String stateClassFilePath = "C:\\Users\\Vécsi Ádám\\Desktop\\State.java";
		String stateInterfaceFilePath = "C:\\workspace\\SzakdogaTMP\\src\\main\\java\\interfaces\\StateInterface.java";
		String operatorClassFilePath = "C:\\Users\\Vécsi Ádám\\Desktop\\Operator.java";
		String operatorInterfaceFilePath = "C:\\workspace\\SzakdogaTMP\\src\\main\\java\\interfaces\\OperatorInterface.java";
		String plusClasspath = "C:\\Users\\Vécsi Ádám\\Desktop\\CommonUtils.java";
	
		File stateClassFile = new File(stateClassFilePath);
		File operatorClassFile = new File(operatorClassFilePath);
		
		if(stateClassFile.isFile() && operatorClassFile.isFile()){
			if(stateClassFilePath.endsWith(JAVA) && operatorClassFilePath.endsWith(JAVA)){
				File classDestinationFile = new File("externalClasses/");
				if(!classDestinationFile.exists()){
					classDestinationFile.mkdirs();
				}
				URL classDestination = classDestinationFile.toURI().toURL();
				
				ProcessBuilder processBuilder = new ProcessBuilder("javac", "-d", classDestination.getPath()/*"C:\\workspace\\SzakdogaTMP\\target\\classes"*/, plusClasspath, stateClassFilePath, stateInterfaceFilePath, operatorClassFilePath, operatorInterfaceFilePath);
				Process process = processBuilder.start();
				while(process.isAlive());
				
				getLoadableClassesInFolderAndSubFolders(classDestinationFile);
				
				String stateName = stateClassFile.getName().substring(0, stateClassFile.getName().length() - 5);
				String operatorName = operatorClassFile.getName().substring(0, operatorClassFile.getName().length() - 5);
				
				Class<?> stateClass = null;
				Class<?> operatorClass = null;
				
				URLClassLoader loader = new URLClassLoader(new URL[] { classDestination });

				for (File classFile : loadableClasses) {
				    try {
				    	String classNameAndPackage = classFile.getAbsolutePath().replace(classDestinationFile.getAbsolutePath() + "\\", "").replace("\\", ".");
				    	classNameAndPackage = classNameAndPackage.substring(0, classNameAndPackage.length() - 6);

				        String filename = classFile.getName();

				        String fileName = filename.substring(0, filename.length() - 6);
				        
				        if(fileName.equals(stateName)){
				        	stateClass = loader.loadClass(classNameAndPackage);
				        } else if(fileName.equals(operatorName)){
				        	operatorClass = loader.loadClass(classNameAndPackage);
				        	operatorClass.getMethod("initOperators").invoke(operatorClass.newInstance());
				        } else {
				        	Class<?> cls = loader.loadClass(classNameAndPackage);
				        }
				        // Do something with the class
				    } catch (Exception ex) {
				    	ex.printStackTrace();
				    }
				}
		
				if(interfaces.StateInterface.class.isAssignableFrom(stateClass) && interfaces.OperatorInterface.class.isAssignableFrom(operatorClass)){
					
					StateInterface state = null;
					try {
						state = (StateInterface) stateClass.getConstructor().newInstance();
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | NoSuchMethodException | SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		
					BackTrackSimpleNode backTrackSimpleNodeStart = new BackTrackSimpleNode(state.getStart(), null, null, 0, new ArrayList<>());
					BackTrackSimple backTrackSimple = new BackTrackSimple(backTrackSimpleNodeStart, operatorClass);
					
					BackTrackCircleNode backTrackCircleNodeStart = new BackTrackCircleNode(state.getStart(), null, null, 0, new ArrayList<>());
					BackTrackCircle backTrackCircle = new BackTrackCircle(backTrackCircleNodeStart, operatorClass);
					
					BackTrackPathLengthLimitationNode backTrackPathLengthLimitationNode = new BackTrackPathLengthLimitationNode(state.getStart(), null, null, 0, new ArrayList<>(), 0);
					BackTrackPathLengthLimitation backTrackPathLengthLimitation = new BackTrackPathLengthLimitation(backTrackPathLengthLimitationNode, 10, operatorClass);
					
					BackTrackOptimalNode backTrackOptimalNode = new BackTrackOptimalNode(state.getStart(), null, null, 0, new ArrayList<>(), 0);
					BackTrackOptimal backTrackOptimal = new BackTrackOptimal(backTrackOptimalNode, 10, operatorClass);
					
					BreadthFirstNode breadthFirstNode = new BreadthFirstNode(state.getStart(), null, null, 0, 0);
					BreadthFirst breadthFirst = new BreadthFirst(breadthFirstNode, operatorClass);
					
					DepthFirstNode depthFirstNode = new DepthFirstNode(state.getStart(), null, null, 0, 0);
					DepthFirst depthFirst = new DepthFirst(depthFirstNode, operatorClass);
					
					OptimalNode optimalNode = new OptimalNode(state.getStart(), null, null, 0, 0);
					Optimal optimal = new Optimal(optimalNode, operatorClass);

					BestFirstNode bestFirstNode = new BestFirstNode(state.getStart(), null, null, 0, "", null);
					BestFirst bestFirst = new BestFirst(bestFirstNode, "", null, operatorClass);
					
					ANode aNode = new ANode(state.getStart(), null, null, 0, 0, "", null);
					A a = new A(aNode, "", null, operatorClass);
					//"(Nodes.ANode.parent.id + Nodes.ANode.id) ^ 2", new HashSet<>(Arrays.asList("Nodes.ANode.parent.id", "Nodes.ANode.id"))
					
					//backTrackSimple.search();
					//backTrackCircle.search();
					//backTrackPathLengthLimitation.search();
					//backTrackOptimal.search();
					//breadthFirst.search();
					//depthFirst.search();
					//optimal.search();
					bestFirst.search();
					//a.search();
						
					deleteDir(classDestinationFile);
				}
			}
		}
	}
}
