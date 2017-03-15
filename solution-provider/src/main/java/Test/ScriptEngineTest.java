package Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.nfunk.jep.JEP;

public class ScriptEngineTest {

	public static void main(String[] args) throws ScriptException {
		ScriptEngineManager mgr = new ScriptEngineManager();
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
	}
	
}
