package leetcode;

import java.util.*;

public class StrobogrammaticNumberII {

    private List<Character> singleNumStrobogrammaticList = Arrays.asList('0','1','8');


    private Map<Character, Character> twoNumCtrobogrammaticMap = new HashMap<Character, Character>() {{
        put('0','0');
        put('1', '1');
        put('6', '9');
        put('8', '8');
        put('9', '6');

    }};
    public List<String> findStrobogrammatic(int n) {
        List<String> result = new ArrayList<String>();
        Long maxNumber = Math.round(Math.pow(10,n))-1;
        Long minNumber = 0L;
        if(n>1)
            minNumber = Math.round(Math.pow(10,n-1));

        for (Long i = minNumber;  i < maxNumber ; i++){
            String numString = String.valueOf(i);
            if (this.strobogrammatic(0,numString.length()-1,numString.toCharArray())){
                result.add(numString);
            }
        }
        return result;
    }


    private boolean strobogrammatic(int startIndex , int endIndex, char [] numCharArr){

        if( endIndex - startIndex == 0){
            return singleNumStrobogrammaticList.contains(numCharArr[startIndex]);
        }else {
            Character char1 = twoNumCtrobogrammaticMap.get(numCharArr[startIndex]);
            if (char1  != null && char1 == numCharArr[endIndex]){
                if( endIndex - startIndex == 1){
                    return true;
                }else{
                    return this.strobogrammatic(startIndex+1,endIndex-1,numCharArr);
                }
            }else {
                return false;
            }
        }

    }


    public static void main(String [] str){
        System.out.println(new StrobogrammaticNumberII().findStrobogrammatic(5));
    }
}
