package leetcode;

import java.text.MessageFormat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels2 {
	
	
	public List<Integer> partitionLabels(String s) {
		List<Integer> resultList = new ArrayList<>();

		Map<Character, Map.Entry<Integer,Integer>> charMatrix= new HashMap<>();
		
		List<Character>  uniqueSet = new ArrayList<>();

		
		char [] charArr = s.toCharArray();
		for (int i = 0 ; i < charArr.length ; i++ ) {
			Character currentChar = charArr[i];
			
			
			if (!uniqueSet.contains(currentChar))
				uniqueSet.add(currentChar);
			
			if(charMatrix.containsKey(currentChar)) {
				Map.Entry<Integer, Integer> indexEntry = charMatrix.get(currentChar);
				indexEntry.setValue(i);
			}else {
				Map.Entry<Integer, Integer> indexEntry = new AbstractMap.SimpleEntry<>(i,i); 
				charMatrix.put(currentChar,indexEntry);
			}
		}

		int firstIndexCA = -1;
		int lastIndexCA = -1;
		int lastLenght = -1	;
		//int lenght = -1;
		
		
		for(Character c : uniqueSet) {
			Map.Entry<Integer, Integer> indexEntry = charMatrix.get(c);
			
			if (lastIndexCA == -1 ) {
				lastIndexCA = indexEntry.getValue(); 
				firstIndexCA = indexEntry.getKey(); 
			}else if (lastIndexCA < indexEntry.getValue()  && indexEntry.getKey() > lastIndexCA){
				resultList.add(lastIndexCA-lastLenght);
				lastLenght = lastIndexCA;
				
				//TODO Update this logic
				lastIndexCA = indexEntry.getValue();
				firstIndexCA = indexEntry.getKey();
				continue;
			}else if (indexEntry.getKey() > lastIndexCA) {
				lastIndexCA = indexEntry.getKey();
			}
			
			if(indexEntry.getValue() > firstIndexCA) {
				firstIndexCA = indexEntry.getValue(); 
			}
			
		}
		resultList.add(charArr.length-lastLenght-1);
		
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
