package Test;

import java.io.File;
import java.io.FilenameFilter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
	
	private static File mainFolder;
	private static List<File> knownFolders = new ArrayList<>();
	private static List<Integer> knownFolderSizes = new ArrayList<>();
	
	private static void searchForSubFolders(File folder){
		if(folder.isDirectory()){
			knownFolders.add(folder);
			List<File> filesInFolder = new ArrayList<>(Arrays.asList(folder.listFiles()));
			knownFolderSizes.add(filesInFolder.size());
			for(File file : filesInFolder){
				searchForSubFolders(file);
			}
		}
	}
	
	private static File getChangedDirectory(){
		for(int i = 0; i < knownFolders.size(); i++){
			if(Arrays.asList(knownFolders.get(i).listFiles()).size() > knownFolderSizes.get(i)){
				return knownFolders.get(i);
			}
		}
		return null;
	}
	
	public static void main(String[] args) throws MalformedURLException {
		mainFolder = new File(Test.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		searchForSubFolders(mainFolder);
		
		System.out.println(knownFolders);
		System.out.println(knownFolderSizes);
		
		System.out.println(getChangedDirectory());
		
		File f = new File("C:/workspace/Prototypes/bin/"); // Folder containing the .class files
		System.out.println(f.toURI().toURL());
		URLClassLoader loader = new URLClassLoader(new URL[] { f.toURI().toURL() });
		/*try {
			String filename = f.getName();
			System.out.println(filename);
			// Remove the .class extension
			Class<?> cls = loader.loadClass(filename.substring(0, filename.length() - 6));
			System.out.println(cls);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		*/
		for (File classFile : f.listFiles(new FilenameFilter() {
		    public boolean accept(File dir, String name) {
		        return name.endsWith(".class");
		    }
		})) {
		    try {
		    	System.out.println("asddd " + classFile);
		    	
		        String filename = classFile.getName();
		        
		        System.out.println(filename);
		        
		        // Remove the .class extension
		        Class<?> cls = loader.loadClass(filename.substring(0, filename.length() - 6));
		        // Do something with the class
		    } catch (Exception ex) {
		    	ex.printStackTrace();
		    }
		}
		System.out.println("asd " + new File("").getAbsolutePath());
		System.out.println(new File("C:\\workspace\\Prototypes\\src\\Hanoi\\State.java").getName());
		System.out.println(new File("").toURI().toURL().getPath());
	}
}
