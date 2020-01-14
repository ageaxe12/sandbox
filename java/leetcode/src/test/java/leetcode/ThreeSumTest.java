package leetcode;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ThreeSumTest {
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	private Method method;
	
	private ThreeSum sumObject = new ThreeSum(); 

	@Before
    public void setUp() throws NoSuchMethodException, SecurityException {

    	  method = ThreeSum.class.getDeclaredMethod("sortedArray2", int[].class);
    	  //method.re
    }

	private void printResult(String methodName, List<List<Integer>> result, int[] source) {
		Arrays.sort(source);
		System.out.println(MessageFormat.format("*******Executing Test :: {0} *****\nInput = {1} \nResult = {2}\n",
				methodName, Arrays.toString(source), result));
	}

	@Test()
	public void sameNumbersTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int[] source = new int[] { -1, 1, 0, 2, -1, 0, 0 };
		List<List<Integer>> result = (List<List<Integer>>)method.invoke(sumObject,source);
		printResult(Thread.currentThread().getStackTrace()[1].getMethodName(), result, source);
		assertEquals(result.size(), 3);
	}

	@Test
	public void zeroNumberTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int[] source = new int[] {};
		List<List<Integer>> result = (List<List<Integer>>)method.invoke(sumObject,source);
		printResult(Thread.currentThread().getStackTrace()[1].getMethodName(), result, source);
		assertEquals(result.size(), 0);
	}

	@Test
	public void noMatchTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int[] source = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
		List<List<Integer>> result = (List<List<Integer>>)method.invoke(sumObject,source);
		printResult(Thread.currentThread().getStackTrace()[1].getMethodName(), result, source);
		assertEquals(result.size(), 0);
	}

	@Test
	public void randomNumberTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int[] source = new int[] { -4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0,2 };
		List<List<Integer>> result = (List<List<Integer>>)method.invoke(sumObject,source);
		printResult(Thread.currentThread().getStackTrace()[1].getMethodName(), result, source);
		assertEquals(result.size(), 8);
	}

	
	@Test
	public void dupicateGroupsTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int[] source = new int[] {-1,-1,0,1,1};
		List<List<Integer>> result = (List<List<Integer>>)method.invoke(sumObject,source);
		printResult(Thread.currentThread().getStackTrace()[1].getMethodName(), result, source);
		assertEquals(result.size(), 1);
	}

	
	@Test
	public void smallGroupTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int[] source = new int[] {0,0,0};
		List<List<Integer>> result = (List<List<Integer>>)method.invoke(sumObject,source);
		printResult(Thread.currentThread().getStackTrace()[1].getMethodName(), result, source);
		assertEquals(result.size(), 1);
	}

	
	@Test
	public void leetCodeFailure1Test() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int[] source = new int[] {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
		List<List<Integer>> result = (List<List<Integer>>)method.invoke(sumObject,source);
		printResult(Thread.currentThread().getStackTrace()[1].getMethodName(), result, source);
		assertEquals(result.size(), 6);
	}

	@Test
	public void leetCodeFailure2Test() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int[] source = new int[] {-4,-1,-4,0,2,-2,-4,-3,2,-3,2,3,3,-4};
		List<List<Integer>> result = (List<List<Integer>>)method.invoke(sumObject,source);
		printResult(Thread.currentThread().getStackTrace()[1].getMethodName(), result, source);
		assertEquals(result.size(), 4);
	}

}
