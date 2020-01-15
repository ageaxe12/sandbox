package leetcode;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore 
public class ThreeSumClosestTest {

	
	
	private ThreeSumClosest sumObject = new ThreeSumClosest(); 


	private void printResult(String methodName, int result, int[] source) {
		Arrays.sort(source);
		System.out.println(MessageFormat.format("*******Executing Test :: {0} *****\nInput = {1} \nResult = {2}\n",
				methodName, Arrays.toString(source), result));
	}

	@Test()
	public void noInputTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int[] source = new int[] {};
		int result = sumObject.threeLoops(source,0);
		printResult(Thread.currentThread().getStackTrace()[1].getMethodName(), result, source);
		assertEquals(result, 0);
	}

	@Test()
	public void exactTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int[] source = new int[] {0,1,2};
		int result = sumObject.threeLoops(source,0);
		printResult(Thread.currentThread().getStackTrace()[1].getMethodName(), result, source);
		assertEquals(result, 3);
	}

	
	@Test()
	public void smallNumberTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int[] source = new int[] {0,1,2,-1,-2};
		int result = sumObject.threeLoops(source,0);
		printResult(Thread.currentThread().getStackTrace()[1].getMethodName(), result, source);
		assertEquals(result, 1);
	}

	@Test()
	public void smallNumberTest2() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int[] source = new int[] {0,1,2,-1,-2};
		int result = sumObject.threeLoops(source,0);
		printResult(Thread.currentThread().getStackTrace()[1].getMethodName(), result, source);
		assertEquals(result, 2);
	}

	@Test()
	public void smallNumberTest3() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int[] source = new int[] {0,1,2,-1,-2};
		int result = sumObject.threeLoops(source,0);
		printResult(Thread.currentThread().getStackTrace()[1].getMethodName(), result, source);
		assertEquals(result, 3);
	}

}
