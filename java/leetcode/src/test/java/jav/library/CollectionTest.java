package jav.library;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CollectionTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testContains() {
		List<List<Integer>> results = new ArrayList<List<Integer>>();

		results.add(Arrays.asList(1, 2, 3));

		results.add(Arrays.asList(2, 3, 4));

		results.add(Arrays.asList(4, 5, 6));
		
		List<Integer> tuple = Arrays.asList(2, 1, 3);

		if(!results.contains(tuple)) {
			for (List<Integer> result  : results) {
				System.out.println("\nResult Array = "+ result + ",\ntuple"+tuple+",\ncontainsAll() result "+result.containsAll(tuple));
	
			}
		}
		
		assertTrue(results.contains(tuple));

		System.out.println("Result Array = "+ results + ",\ntuple"+tuple+",/ncontainsAll() result"+results.contains(tuple));
		
		

	}

	@Test
	public void testAsArray() {
		int[] nums = new int[] {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
		List<Integer> tuple = Arrays.asList(nums[8],
				nums[10], nums[15]);
		
		System.out.println("Result Array = "+ tuple);

	}	
}
