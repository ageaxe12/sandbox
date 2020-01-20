package leetcode;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class PartitionLabelsTest {
	private PartitionLabels3 testObject = new PartitionLabels3();

	@Test
	public void leetCodeSampleTest() {
		
		List<Integer> result = testObject.partitionLabels("ababcbacadefegdehijhklij");
		//assertEquals(4, result);
	}


	
	@Test
	public void leetCodeSampleTest2() {
		
		List<Integer> result = testObject.partitionLabels("caedbdedda");
		//assertEquals(4, result);
	}

	@Test
	public void leetCodeSampleTest3() {
		
		List<Integer> result = testObject.partitionLabels("dccccbaabe");
		//assertEquals(4, result);
	}


}
