package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> uniqueChars = new HashMap<>();
        int longestLength = 0;
        int startIndex = -1;

        char []  stringArr = s.toCharArray();

        for (int i= 0 ; i < stringArr.length ; i++){

            if(uniqueChars.containsKey(stringArr[i]) && startIndex < uniqueChars.get(stringArr[i])){
                startIndex = uniqueChars.get(stringArr[i]);
            }
            uniqueChars.put(stringArr[i],i);

            if (longestLength < i - startIndex){
                longestLength = i - startIndex;
            }
        }

        return longestLength;

    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abba"));
    }

}
