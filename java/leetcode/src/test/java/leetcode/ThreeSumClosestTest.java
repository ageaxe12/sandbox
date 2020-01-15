package leetcode;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ThreeSumClosestTest {

	
	private Method method;
	
	private ThreeSumClosest sumObject = new ThreeSumClosest(); 

	@Before
    public void setUp() throws NoSuchMethodException, SecurityException {

    	  method = ThreeSumClosest.class.getDeclaredMethod("threeLoops", int[].class,int.class);
    	  //method.re
    }

	private void printResult(String methodName, int result, int[] source) {
		Arrays.sort(source);
		System.out.println(MessageFormat.format("*******Executing Test :: {0} *****\nInput = {1} \nResult = {2}\n",
				methodName, Arrays.toString(source), result));
	}

	@Test()
	public void noInputTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int[] source = new int[] {};
		int result = (int)method.invoke(sumObject,source,0);
		printResult(Thread.currentThread().getStackTrace()[1].getMethodName(), result, source);
		assertEquals(result, 0);
	}

	@Test()
	public void exactTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int[] source = new int[] {0,1,2};
		int result = (int)method.invoke(sumObject,source,1);
		printResult(Thread.currentThread().getStackTrace()[1].getMethodName(), result, source);
		assertEquals(result, 3);
	}

	
	@Test()
	public void smallNumberTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int[] source = new int[] {0,1,2,-1,-2};
		int result = (int)method.invoke(sumObject,source,1);
		printResult(Thread.currentThread().getStackTrace()[1].getMethodName(), result, source);
		assertEquals(result, 1);
	}

	@Test()
	public void smallNumberTest2() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int[] source = new int[] {0,1,2,-1,-2};
		int result = (int)method.invoke(sumObject,source,2);
		printResult(Thread.currentThread().getStackTrace()[1].getMethodName(), result, source);
		assertEquals(result, 2);
	}

	@Test()
	public void smallNumberTest3() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int[] source = new int[] {0,1,2,-1,-2};
		int result = (int)method.invoke(sumObject,source,4);
		printResult(Thread.currentThread().getStackTrace()[1].getMethodName(), result, source);
		assertEquals(result, 3);
	}

}
