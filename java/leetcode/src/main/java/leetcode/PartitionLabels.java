package leetcode;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class PartitionLabels {
	public List<Integer> partitionLabels(String s) {

		List<Integer> resultList = new ArrayList<>();

		Set<Character> uniqueSet = new LinkedHashSet<Character>();

		List<Character> charList = new ArrayList<Character>();

		for (Character c : s.toCharArray()) {
			charList.add(c);
			uniqueSet.add(c);

		}
		
		System.out.println(s);

		int lastLength = -1;
		while (!uniqueSet.isEmpty()) {
			
			int length = this.getPartition(charList, uniqueSet);
			resultList.add(length-lastLength);

			System.out.println(s.substring(lastLength+1,length+1));

			
			lastLength = length;
			
			
		}

		System.out.println(resultList);

		
		return resultList;
	}

	private int getPartition(List<Character> charList, Set<Character> uniqueSet) {
		int partitionLenght = -1;
		List<Character> processedCharList = new ArrayList<Character>();
		int partitionFirstIndex =-1;
		for(Character c : uniqueSet) {
			int lastIndexCA = charList.lastIndexOf(c);
			
			int firstIndexCA = charList.indexOf(c);
			
			if (partitionLenght ==-1) {
				partitionLenght = lastIndexCA;
				partitionFirstIndex = firstIndexCA;
			}

			
			if (partitionLenght < lastIndexCA && firstIndexCA > partitionLenght ) {
				uniqueSet.removeAll(processedCharList);
				return partitionLenght;
			}
			
			if (partitionLenght < lastIndexCA ) {
				partitionLenght = lastIndexCA;
			}
			if(firstIndexCA > partitionFirstIndex ) {

				partitionFirstIndex = firstIndexCA;
			}
			
			processedCharList.add(c);
		}
		uniqueSet.removeAll(processedCharList);

		return partitionLenght;
	}
}
