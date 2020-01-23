package leetcode;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionLabels3 {

	public List<Integer> partitionLabels(String s) {
		List<Integer> resultList = new ArrayList<>();
		char[] charArr = s.toCharArray();
		int[] positionArr = new int[26];

		for (int i = 0; i < charArr.length; i++) {
			positionArr[charArr[i] - 'a'] = i;
		}
		int charLastPos = 0, partPos = 0, partLastPos = -1;
		for (int i = 0; i < charArr.length; i++) {
			charLastPos = positionArr[charArr[i] - 'a'];

			if (i != 0 && i > partPos) {
				resultList.add(partPos - partLastPos);
				partLastPos = partPos;
				partPos = charLastPos;
				i--;
			} else if (charLastPos > partPos) {
				partPos = charLastPos;
			}
		}

		resultList.add(charArr.length- partLastPos-1);

		//System.out.println(MessageFormat.format("Input Array {0} ", String.valueOf(charArr)));
		//System.out.println(MessageFormat.format("Position Array {0}", Arrays. toString(positionArr)));

		printResult(resultList, s);
		return resultList;

	}

	private void printResult(List<Integer> resultList, String s) {
		System.out.println("Input string : " + s);
		int startIndex = 0;
		System.out.println(resultList);

		for (Integer i : resultList) {
			System.out.println(MessageFormat.format("{0} : {1}", i, s.substring(startIndex, startIndex + i)));
			startIndex = startIndex + i;
		}

	}
}
