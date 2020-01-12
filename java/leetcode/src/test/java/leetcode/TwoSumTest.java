package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TwoSumTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void positiveTest() {
		int[] source = new int[] { 1, 2, 3, 4, 5 };
		int[] result = new TwoSum().twoSum(source, 9);
		System.out.println("Result = [" + result[0] + "," + result[1] + "]");
		assertEquals(source[result[0]] + source[result[1]], 9);
	}

	@Test(expected = IllegalArgumentException.class)
	public void negativeTest() {
		int[] source = new int[] { 1, 2, 3, 4, 5 };
		new TwoSum().twoSum(source, 10);

	}

	@Test
	public void positiveTestV2() {
		int[] source = new int[] { 1, 2, 3, 4, 5 };
		int[] result = new TwoSum().twoSumV2(source, 9);
		System.out.println("Result = [" + result[0] + "," + result[1] + "]");
		assertEquals(source[result[0]] + source[result[1]], 9);
	}

	@Test(expected = IllegalArgumentException.class)
	public void negativeTestV2() {
		int[] source = new int[] { 1, 2, 3, 4, 5 };
		new TwoSum().twoSumV2(source, 10);

	}

	@Test
	public void positiveTestV3() {
		int[] source = new int[] { 1, 2, 3, 4, 5 };
		int[] result = new TwoSum().twoSumV3(source, 9);
		System.out.println("Result = [" + result[0] + "," + result[1] + "]");
		assertEquals(source[result[0]] + source[result[1]], 9);
	}

	@Test(expected = IllegalArgumentException.class)
	public void negativeTestV3() {
		int[] source = new int[] { 1, 2, 3, 4, 5 };
		new TwoSum().twoSumV3(source, 10);

	}


}
