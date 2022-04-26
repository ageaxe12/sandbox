package leetcode;

import java.util.*;

public class ValidParenthese {

    Map<Character,Character> bracketMap =
            new HashMap<>();



    public boolean isValid(String input) {
        bracketMap.put('{','}');
        bracketMap.put('(',')');
        bracketMap.put('[',']');

        Stack<Character> stack = new Stack<>();
        for (int i = input.toCharArray().length-1 ; i >= 0; i--)
            stack.push(input.toCharArray()[i]);
        return isValid2(input.toCharArray(),0,input.toCharArray().length-1);
    }

    private boolean isValid2(char[] array,int startPointer,int endPointer) {
        if (startPointer > endPointer){
            return true;
        }

        Character currentBracket = array[startPointer];
        Character closingBracket =  bracketMap.get(currentBracket);;
        int currentBracketCount = 1;
        int i = startPointer+1;
        while (i <= endPointer){
            if (array[i]==currentBracket){
                currentBracketCount++;
            }else if (closingBracket !=null && array[i]==closingBracket && currentBracketCount ==1){
                break;
            }else  if (closingBracket !=null && array[i]==closingBracket){
                currentBracketCount--;
            }
            i++;
        }
        if (i > endPointer){
            return false;
        }
        return array[i]==closingBracket && isValid2(array,startPointer+1,i-1) && isValid2(array,i+1,endPointer);

    }


    private boolean isValid(Stack<Character> stack) {
        boolean isValid = false;

        Character currentBracket = null;
        Character closingBracket = null;

        int currentBracketCount = 0;
        List<Character> helper = new ArrayList<Character>();
        if (stack.isEmpty()){
            return true;
        }
        while (!stack.isEmpty()){
            Character temp = stack.pop();
            if (currentBracket == null) {
                currentBracket = temp;
                currentBracketCount++;
                closingBracket = bracketMap.get(currentBracket);
            }else if (temp == currentBracket){
                currentBracketCount++;
                helper.add(temp);
            }else if (closingBracket == temp){
                if (currentBracketCount ==1){
                    if (helper.size() % 2 != 0 ){
                        return false;
                    }
                    for (int i = helper.size()-1 ; i >= 0; i--)
                        stack.push(helper.get(i));
                    helper.clear();
                    return isValid(stack);
                } else {
                    currentBracketCount--;
                    helper.add(temp);
                }
            }else{
                helper.add(temp);
            }
        }
        return isValid;
    }




    public List<List<Integer>> threeSum(int[] inputArr) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Arrays.sort(inputArr);

        Integer lastI = null;
        Integer lastJ = null;
        Integer lastK = null;
        for (int i = 0 ; i < inputArr.length-2;i++){
            if (lastI != null && lastI == inputArr[i]){
                continue;
            }else{
                lastI = inputArr[i];
            }
            for(int j= i+1; j <  inputArr.length-1;j++){
                if (lastJ!= null && lastJ == inputArr[j]){
                    continue;
                }else{
                    lastJ = inputArr[j];
                }

                for(int k= j+1; k <  inputArr.length;k++){
                    if (lastK!= null && lastK == inputArr[k]){
                        continue;
                    }else{
                        lastK = inputArr[k];
                    }

                    if (inputArr[i] + inputArr[j] + inputArr[k] == 0 ){
                        result.add(Arrays.asList(inputArr[i] , inputArr[j] , inputArr[k]));
                    }
                }
            }
        }

        return result;
    }
    public boolean isPalindrome(String s) {
        char [] charArray = s.toCharArray();
        int [] countArray = new int[26];

        for(char c: charArray){
            int index = getIndex(c);
            if (index == -99){
                continue;
            }
            countArray[index]++;
        }

        boolean found = false;
        for (int i : countArray){
            if (i % 2 == 1){
                if (found == true) {
                    return false;
                }else{
                    found = true;
                }
            }
        }
        return found;
    }
    private int getIndex(char c) {
        if (c >= 'a' && c <= 'z' ){
            return c-'a';
        }else if (c >= 'A' && c <= 'Z' ){
            return c-'A';
        }else{
            return -99;
        }

    }
    public List<List<Integer>> threeSum(int[] inputArr,String s) {

        Set<List<Integer>> result = new HashSet<List<Integer>>();

        Map<Integer,Integer> map = new HashMap<>();

        Arrays.sort(inputArr);

        for(int i = inputArr.length-1 ; i > 0 ; i--){
            map.put(inputArr[i],i);
        }

        for(int i = 0 ; i < inputArr.length ; i++){
            for(int j = i+1 ; j < inputArr.length ; j++){
                Integer requiredNumber = 0-inputArr[i]-inputArr[j];
                Integer index = map.get(requiredNumber);
                if (null != index && (requiredNumber+inputArr[i]+inputArr[j]==0) && index >j){
                    List<Integer> element = new ArrayList<>();
                    element.add(inputArr[i]);
                    element.add(inputArr[j]);
                    element.add(requiredNumber);
                    result.add(element);
                    //break;
                }
            }
        }
        return new ArrayList<>(result);
    }
    public int myAtoi(String s) {
        char [] cArray = s.toCharArray();

        int multiplier = 1;
        int number = 0;
        int postive = -1;
        boolean topped = false;
        boolean breckOnSpace = false;

        for (int i =0 ; i < cArray.length ;i++){
            char c = cArray[i];
            if (c == ' ' && ! breckOnSpace){
                continue;
            }

            if (c == '+' || c == '-'){
                if (c == '-' && postive ==-1){
                    postive = 0;
                }else if (postive ==-1){
                    postive = 1;
                }else{
                    break;
                }
                continue;
            }

            if (!Character.isDigit(c)){
                break;
            }
            if (postive == -1){
                postive = 1;
            }
            breckOnSpace = true;
            number = number * multiplier +  Character.digit(c,10) ;
            multiplier = 10;
            if ((Integer.MAX_VALUE / 10 < number)  && i != (cArray.length -1) ||  number < 0){
                topped = true;
                break;
            }
        }

        if (topped && postive == 1){
            return Integer.MAX_VALUE;
        }else if (topped && postive == 0 ){
            return Integer.MIN_VALUE;
        }else if (postive == 0 ){
            return (0 - number);
        } else {
            return number;
        }

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> tList = new ArrayList<>();
        for (int i = 0 ; i < candidates.length ;i++){
            List<List<Integer>> tList2 = combinationSum(candidates,i,target);
            if (tList2 != null){
                tList.addAll(tList2);
            }
        }
        return tList;
    }

    private List<List<Integer>> combinationSum(int[] candidates,int index,int target){
        if (index == candidates.length){
            return null;
        }


        int target2 = target - candidates[index];
        if (target2 == 0){
            List<Integer> list = new ArrayList<>();
            list.add(candidates[index]);
            ArrayList<List<Integer>> tList = new ArrayList<List<Integer>>();
            tList.add(list);
            return tList;
        }
        if (target2 >= candidates[index]){
            List<List<Integer>> tList = tList = new ArrayList<>();;
            for (int i = index ; i < candidates.length ; i++){
                List<List<Integer>> tList2 = combinationSum(candidates,i,target2);
                    if (tList2 != null) {
                        for (List<Integer> list : tList2)
                            list.add(candidates[index]);
                        tList.addAll(tList2);
                    }
            }
            return tList;
        }
        return null;
    }
    public static void  main(String[] str){

        //System.out.println(new ValidParenthese().isValid("(([]){})"));
        //System.out.println(new ValidParenthese().threeSum(new int[]{1,-1,-1,0}));
        //System.out.println(new ValidParenthese().myAtoi("2147483648"));
        System.out.println(new ValidParenthese().combinationSum(new int[]{2,3,5}, 8));
        //System.out.println(new ValidParenthese().combinationSum(new int[]{2,3,6,7}, 7));

    }
}
