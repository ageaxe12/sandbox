package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PartitionLabels {
	public List<Integer> partitionLabels(String s) {

		List<Integer> resultList = new ArrayList<>();

		Set<Character> uniqueSet = new TreeSet<Character>();

		List<Character> charList = new ArrayList<Character>();

		for (Character c : s.toCharArray()) {
			charList.add(c);
		}
		
		uniqueSet.addAll(charList);

		
		while (!uniqueSet.isEmpty()) {
			resultList.add(this.getPartition(charList, uniqueSet, 0));
		}

		System.out.println(resultList);
		return resultList;
	}

	private int getPartition(List<Character> charList, Set<Character> uniqueSet, int charArrIndex) {
		int partitionLenght = 0;
		List<Character> processedCharList = new ArrayList<Character>();
		int partitionStart = 0;
		for(Character c : uniqueSet) {
			int tLength = charList.lastIndexOf(c);
			if (partitionLenght == 0) {
				partitionLenght = tLength;
				partitionStart = charList.indexOf(c);
			}else if (tLength> partitionLenght && charList.indexOf(c) > partitionStart) {
				partitionLenght = tLength;
			}else {
				uniqueSet.removeAll(processedCharList);
				break;
			}
			processedCharList.add(c);
		}
		return partitionLenght;
	}
}
