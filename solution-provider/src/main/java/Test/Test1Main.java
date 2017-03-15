package Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Test1Main {
	static Class testClass = Test1.class;
	public static void main(String[] args){	
		try {
			Test1Interface asd = (Test1Interface) testClass.getConstructor().newInstance();
			asd.test();
			cucc(asd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void cucc(Object asd){
		asd = (Test1)asd;
		System.out.println(asd);
		System.out.println(asd.getClass());
	}
	
}
