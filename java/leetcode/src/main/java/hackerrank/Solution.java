package hackerrank;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        float postiveNumbersLenght = 0;
        float negativeNumbersLenght = 0;
        for (int num : arr){
            if (num > 0) {
                postiveNumbersLenght++;
            }else if (num < 0) {
                negativeNumbersLenght++;
            }
        }

        System.out.format("%f",postiveNumbersLenght/arr.size());
        System.out.println();
        System.out.format("%f",negativeNumbersLenght/arr.size());
        System.out.println();
        System.out.format("%f",(arr.size()-(postiveNumbersLenght+negativeNumbersLenght))/arr.size());

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}