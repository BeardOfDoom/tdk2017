package Test;

import java.util.Stack;

import org.nfunk.jep.ParseException;
import org.nfunk.jep.function.PostfixMathCommand;

public class newFunctionTest extends PostfixMathCommand{

	public newFunctionTest(){
		numberOfParameters = -1;
	}
	
	public void run(Stack stack) throws ParseException {
		
  		// Check if stack is null
  		if (null == stack) {
			throw new ParseException("Stack argument null");
		}
        
        Object param = null;
        double result = 0;
        int i = 0;
        // repeat summation for each one of the current parameters
        while (i < curNumberOfParameters) {
        	// get the parameter from the stack
            param = stack.pop();
            if (param instanceof Number)   {
                // calculate the result
                result += ((Number) param).doubleValue();
            } else {
                throw new ParseException("Invalid parameter type");
            }
                
            i++;
        }
        
        // push the result on the inStack
        stack.push(new Double(result));
	}
}
