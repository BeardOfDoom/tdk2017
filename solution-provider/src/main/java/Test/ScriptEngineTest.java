package Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScriptEngineTest {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, URISyntaxException, IOException {
		String laciState = "C:\\Users\\Vécsi Ádám\\Desktop\\asdasdsaddas\\State.java";
		String laciOperator = "C:\\Users\\Vécsi Ádám\\Desktop\\asdasdsaddas\\Operator1.java";
		String laciPlusz = "C:\\Users\\Vécsi Ádám\\Desktop\\asdasdsaddas\\GeneratedUtils.java";
		
		List<File> files = new ArrayList<>(Arrays.asList(new File(laciState), new File(laciOperator), new File(laciPlusz)));

	}
	
}
