package leetcode;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ThreeSumTest {
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	//@Test
	public void positiveTest4() {
		int[] source = new int[] {0,14,-7,2,7,11,-9,11,-12,6,-10,-8,9,-3,7,-6,3,4,14,-10,-8,5,-1,6,12,9,12,-11,-15,-5,5,0,-6,13,9,9,10,7,5,13,-2,11,-10,-15,-15,4,-14,-4,-15,7,-7,-15,-3,8,-2,-13,-6,-5,-9,-14,5,12,1,6,2,-12,-8,-11,10,13,-13,-14,1,14,8,1,-4,9,4,-12,-6,13,10,6,6,-7,8,7,3,7,8,-15,-4,-14,-1,13,-11,6,-12,-15,4,12,8,-10,4,1,-1,7,-13,-12,10,-4,8,6,10,-1,6,-5,13,-13,9,6,-13,-10};
		List<List<Integer>>  result = new ThreeSum().approch1(source);
		System.out.println("Result 4= "+result);
	}

	//@Test
	public void positiveTest42() {
		int[] source = new int[] {0,14,-7,2,7,11,-9,11,-12,6,-10,-8,9,-3,7,-6,3,4,14,-10,-8,5,-1,6,12,9,12,-11,-15,-5,5,0,-6,13,9,9,10,7,5,13,-2,11,-10,-15,-15,4,-14,-4,-15,7,-7,-15,-3,8,-2,-13,-6,-5,-9,-14,5,12,1,6,2,-12,-8,-11,10,13,-13,-14,1,14,8,1,-4,9,4,-12,-6,13,10,6,6,-7,8,7,3,7,8,-15,-4,-14,-1,13,-11,6,-12,-15,4,12,8,-10,4,1,-1,7,-13,-12,10,-4,8,6,10,-1,6,-5,13,-13,9,6,-13,-10};
		List<List<Integer>>  result = new ThreeSum().approch2(source);
		System.out.println("Result 42= "+result);
	}
	

	//@Test
	public void positiveTest5() {
		int[] source = new int[] {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
		List<List<Integer>>  result = new ThreeSum().approch1(source);
		System.out.println("Result 5= "+result);
	}

	@Test
	public void positiveTest52() {
		int[] source = new int[] {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
		List<List<Integer>>  result = new ThreeSum().approch2(source);
		System.out.println("Result 52= "+result);
	}

	@Test
	public void positiveTest53() {
		Integer[] source = new Integer[] {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
		List<List<Integer>>  result = new ThreeSum().approch3(source);
		System.out.println("Result 53= "+result);
	}
	
}
