package Test;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Arrays;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.commons.io.FilenameUtils;
import org.nfunk.jep.JEP;

public class ScriptEngineTest {

	String asd;
	String asdsad;
	Integer asdsadsa;
	
	
	
	public ScriptEngineTest(String asd, Integer asdsadsa) {
		super();
		this.asd = asd;
		this.asdsadsa = asdsadsa;
	}



	public ScriptEngineTest(String asd, String asdsad, Integer asdsadsa) {
		super();
		this.asd = asd;
		this.asdsad = asdsad;
		this.asdsadsa = asdsadsa;
	}



	/*public ScriptEngineTest() {
	}
*/
	public ScriptEngineTest(String asd) {
		super();
		this.asd = asd;
	}





	public static void main(String[] args) throws ScriptException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, URISyntaxException {
		/*ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");
	    String foo = "";
	    System.out.println(engine.eval(foo));
	    
	    JEP myParser = new JEP();
	    myParser.addStandardFunctions();
	    myParser.addStandardConstants();
	    myParser.addFunction("testFunction", new newFunctionTest());
	    myParser.addVariable("x", 10);
	    myParser.parseExpression("5 * 5 + 2 ^ 2 + testFunction(x, x, x, x)");
	    System.out.println(myParser.getValue());
		System.out.println(Double.POSITIVE_INFINITY);
		System.out.println(ScriptEngineTest.class.getSuperclass().newInstance());
		System.out.println(Arrays.asList(ScriptEngineTest.class.getDeclaredConstructors()));*/
		System.out.println(Test.class.getClassLoader().getResource("interfaces/StateInterface.java").getPath());
		System.out.println(Paths.get(Test.class.getClassLoader().getResource("interfaces/StateInterface.java").toURI()));
		System.out.println(new File(Test.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()));
	}
	
}
