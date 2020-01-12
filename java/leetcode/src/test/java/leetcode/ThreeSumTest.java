package leetcode;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ThreeSumTest {
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void positiveTest() {
		int[] source = new int[] {-1, 0, 1, 2, -1, -4};
		List<List<Integer>>  result = new ThreeSum().worstCase(source);
		System.out.println("Result = "+result);
	}

}
