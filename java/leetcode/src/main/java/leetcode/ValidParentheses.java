package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {

    private final Map<Character, Character> myMap = new HashMap<Character, Character>() {{
        put('(', ')');
        put('{', '}');
        put('[', ']');
    }};

    private boolean isValid(char [] brackets , int startIndex , int endIndex) {

        if (startIndex == endIndex){
            return false;
        }

        if (startIndex > endIndex){
            return true;
        }

        Character expectedBacket = this.myMap.get(brackets[startIndex]);
        if(expectedBacket == null){
            return false;
        }

        for (int i = startIndex+1 ;i <= endIndex ; i++){
            if (brackets[i] == expectedBacket){
                if (i == endIndex){
                    return true;
                }
                return isValid(brackets , startIndex+1 , i-1) && isValid(brackets , i+1 , endIndex);
            }
        }
        return false;
    }

    public boolean isValid(String s) {
        char [] brackets = s.toCharArray();
        return this.isValid(brackets,0,brackets.length-1);
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("){"));
    }
}
