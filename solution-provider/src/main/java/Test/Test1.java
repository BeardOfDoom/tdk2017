package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test1 implements Test1Interface{

	private Test1 test;
	
	private int asd;
	
	private List<List<List<Double>>> asd2 = new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 31.0, 12.0, 13.0))))));

	public int getAsd() {
		return asd;
	}

	public void setAsd(int asd) {
		this.asd = asd;
	}

	@Override
	public void test() {
		asd = 10;
		System.out.println("asd" + asd);
	}

	public Test1(Test1 test, int asd) {
		this.test = test;
		this.asd = asd;
	}

	public Test1() {
	}

	public Test1 getTest() {
		return test;
	}

	public void setTest(Test1 test) {
		this.test = test;
	}
}
