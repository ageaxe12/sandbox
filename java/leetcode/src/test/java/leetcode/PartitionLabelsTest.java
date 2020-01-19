package leetcode;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class PartitionLabelsTest {
	private PartitionLabels testObject = new PartitionLabels();

	@Test
	public void leetCodeSampleTest() {
		
		List<Integer> result = testObject.partitionLabels("ababcbacadefegdehijhklij");
		//assertEquals(4, result);
	}


}
