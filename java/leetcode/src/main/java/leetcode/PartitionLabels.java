package leetcode;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
	public List<Integer> partitionLabels(String s) {

		List<Integer> resultList = new ArrayList<>();

		List<Character>  charList = new ArrayList<Character>();

		List<Character>  uniqueSet = new ArrayList<Character>();

		
		for (Character c : s.toCharArray()) {
			charList.add(c);
			if (!uniqueSet.contains(c))
				uniqueSet.add(c);

		}

		System.out.println(s);

		int lastLength = -1;
		while (!uniqueSet.isEmpty()) {

			int length = this.getPartition(charList, uniqueSet);
			resultList.add(length - lastLength);

			System.out.println(s.substring(lastLength + 1, length + 1));

			lastLength = length;

		}

		printResult(resultList ,s);

		return resultList;
	}

	private int getPartition(List<Character> charList, List<Character> uniqueSet) {
		int partitionLenght = -1;
		List<Character> processedCharList = new ArrayList<Character>();
		int partitionFirstIndex = -1;
		for (Character c : uniqueSet) {
			int lastIndexCA = charList.lastIndexOf(c);

			int firstIndexCA = charList.indexOf(c);

			if (partitionLenght == -1) {
				partitionLenght = lastIndexCA;
				partitionFirstIndex = firstIndexCA;
			}

			if (partitionLenght < lastIndexCA && firstIndexCA > partitionLenght) {
				uniqueSet.removeAll(processedCharList);
				return partitionLenght;
			}

			if (partitionLenght < lastIndexCA) {
				partitionLenght = lastIndexCA;
			}
			if (firstIndexCA > partitionFirstIndex) {

				partitionFirstIndex = firstIndexCA;
			}

			processedCharList.add(c);
		}
		uniqueSet.removeAll(processedCharList);

		return partitionLenght;
	}
	
	private void printResult(List<Integer> resultList ,String s) {
		System.out.println("Input string : "+ s);
		int startIndex = 0 ;
		System.out.println(resultList);

		for (Integer i : resultList) {
			System.out.println(MessageFormat.format("{0} : {1}", i,s.substring(startIndex,startIndex+i)));
			startIndex = startIndex+i;
		}
		

	}
}
