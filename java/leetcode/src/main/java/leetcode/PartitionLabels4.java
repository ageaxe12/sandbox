package leetcode;

import java.text.MessageFormat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels4 {
	
	
	public List<Integer> partitionLabels(String s) {
		List<Integer> resultList = new ArrayList<>();

		//Map<Character, Map.Entry<Integer,Integer>> charMatrix= new HashMap<>();
		
		List<Character>  uniqueSet = new ArrayList<>();
		List<Integer>  startIndexList = new ArrayList<>();

		List<Integer>  endIndexList = new ArrayList<>();
		
		char [] charArr = s.toCharArray();
		//int uniqueSetIndex = 0;
		for (int i = 0 ; i < charArr.length ; i++ ) {
			Character currentChar = charArr[i];
			
			if (uniqueSet.contains(currentChar)) {
				int index = uniqueSet.indexOf(currentChar);
				endIndexList.set(index, i);
				
			}else {
				uniqueSet.add(currentChar);
				startIndexList.add(i);
				endIndexList.add(i);
				//uniqueSetIndex++;
			}
		}

		int pIndex = -99;
		int lastPindex = -1	;
		
		
		for(int i = 0 ; i< uniqueSet.size(); i++) {

			int charStartIndex = startIndexList.get(i);
			int charEndIndex = endIndexList.get(i);
			
			if(i ==0) {
				pIndex = charEndIndex; 
			}else if (charStartIndex > pIndex) {
				resultList.add(pIndex - lastPindex);
				lastPindex = pIndex;
				pIndex = charEndIndex;
				i--;
			}else if (charEndIndex > pIndex) {
				pIndex = charEndIndex;
			}
		
		}
		resultList.add(charArr.length-lastPindex-1);
		printResult(resultList ,s);
		return resultList;
		
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
