package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class String2IntegerAtoi {
    public int myAtoi(String s) {

        char [] cArray = s.toCharArray();
        boolean ignoreLeadingSpace = true;
        boolean positiveNum = true;
        boolean readNum = false;
        long num = 0;
        
        
        for (char c: s.toCharArray()){
            if(ignoreLeadingSpace && !readNum && c == ' '){
                continue;
            }else if((c == '+'|| c == '-'|| Character.isDigit(c)) && !readNum ){
                ignoreLeadingSpace = false ;
                if (c == '-') positiveNum = false;
                if (Character.isDigit(c)){
                    readNum = true;
                    num = num*10 + Character.getNumericValue(c);
                    if (positiveNum && (num > Integer.MAX_VALUE)){
                        return Integer.MAX_VALUE;                        
                    }else if (!positiveNum && ((0-num) > Integer.MIN_VALUE)){
                        return Integer.MIN_VALUE;                        
                    }
                } 
            }else if (readNum && Character.isDigit(c)){
                num = num*10 + Character.getNumericValue(c);
                if (positiveNum && (num > Integer.MAX_VALUE)){
                    return Integer.MAX_VALUE;                        
                }else if (!positiveNum && ((0-num) > Integer.MIN_VALUE)){
                    return Integer.MIN_VALUE;                        
                }              
            }else{
                
                return (int)num;   
            }
        }
        
        return (int)num;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        int startIndex = 0;
        int endIndex = nums.length - 1;
        int bestSum = Integer.MAX_VALUE;
        this.findSum(bestSum, nums, startIndex, endIndex, result);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list.addAll(result);
        return list;
    }

    private int findSum2(int bestSum, int[] nums, int startIndex, int endIndex, Set<List<Integer>> result) {
        int currentIndex = startIndex + 1;
        while (currentIndex < endIndex) {
            bestSum = Math.abs(nums[startIndex] + nums[currentIndex] + nums[endIndex]) < Math.abs(bestSum)
                    ? nums[startIndex] + nums[currentIndex] + nums[endIndex]
                    : bestSum;
            if (nums[startIndex] + nums[currentIndex] + nums[endIndex] == 0) {
                result.add(
                        Arrays.asList(new Integer[] { nums[startIndex], nums[currentIndex], nums[endIndex] }));
            }
            currentIndex++;
        }
        return bestSum;
    }

    private void findSum(int bestSum, int[] nums, int startIndex, int endIndex, Set<List<Integer>> result) {

        while (startIndex < endIndex) {
            bestSum = this.findSum2(bestSum, nums, startIndex, endIndex, result);
            if (bestSum == 0) {
                this.findSum(0, nums, startIndex + 1, endIndex, result);
                this.findSum(0, nums, startIndex, endIndex - 1, result);
                startIndex++;
                endIndex--;
            } else if (bestSum > 0) {
                endIndex--;
            } else {
                startIndex++;
            }
        }
    }

    public List<List<Integer>> threeSum3(int[] inputArr) {

        Set<List<Integer>> result = new HashSet<List<Integer>>();

        Map<Integer, List<Integer>> map = new HashMap<>();

        Arrays.sort(inputArr);

        for (int i = inputArr.length - 1; i > 0; i--) {
            List<Integer> list = map.get(inputArr[i]);
            if (list == null)
                list = new ArrayList<>();
            list.add(i);
            map.put(inputArr[i], list);
        }

        for (int i = 0; i < inputArr.length; i++) {
            for (int j = i + 1; j < inputArr.length; j++) {
                Integer requiredNumber = 0 - inputArr[i] - inputArr[j];
                List<Integer> indexs = map.get(requiredNumber);
                if (null != indexs) {
                    for (Integer index : indexs) {
                        if (index > j) {
                            List<Integer> element = new ArrayList<>();
                            element.add(inputArr[i]);
                            element.add(inputArr[j]);
                            element.add(requiredNumber);
                            result.add(element);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }


    public int romanToInt(String s) {
        char [] cArray = s.toCharArray();
        int cp = 0;
        int num =0;
        
        Map<Character, Integer> simpleRoman = new HashMap<Character, Integer>(){{
            put('M', 1000);
            put('D', 500);
            put('C', 100);
            put('L', 50);
            put('X', 10);
            put('V', 5);
            put('I', 1);
        }};
        
        List<String> allowedComposite = Arrays.asList("CM", "CD", "XC","XL","IX","IV");
        
        while(cp < cArray.length){
        
            boolean composite = false;
            
            char c = cArray[cp];
            
            String compositeString = null;
            
            if(cp+1 < cArray.length){
                char c2 = cArray[cp+1];
                compositeString = "" + c + c2;
                if(allowedComposite.contains(compositeString)){
                    cp = cp +2;
                    num = num + (simpleRoman.get(c2) - simpleRoman.get(c))  ;
                    continue;
                }
            }
            num = num + simpleRoman.get(c);                    
            cp++;
        }
        return num;
    }


    public static void main(String[] args) {
        //List<List<Integer>> list =  new String2IntegerAtoi().threeSum3(new int[] {34,55,79,28,46,33,2,48,31,-3,84,71,52,-3,93,15,21,-43,57,-6,86,56,94,74,83,-14,28,-66,46,-49,62,-11,43,65,77,12,47,61,26,1,13,29,55,-82,76,26,15,-29,36,-29,10,-70,69,17,49});
        System.out.println(new String2IntegerAtoi().romanToInt("MCMXCIV"));    
    }
        
    
}