package Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.UUID;

public class ScriptEngineTest {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, URISyntaxException, IOException {
		System.out.println(new URL("jar:file:/C:/.m2/repository/SzakdogaTMP/SzakdogaTMP/1.0/SzakdogaTMP-1.0.jar!/interfaces/StateInterface.java").getPath());

	}
	
}
