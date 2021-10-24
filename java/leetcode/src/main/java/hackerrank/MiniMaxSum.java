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

class MiniMaxSumResult {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);

        UnsignedInt num;
        BigInteger   lowSum = BigInteger.ZERO;
        lowSum.add(String.valueOf(arr.get(0)).add()
        lowSum.
                new BigInteger(arr.get(0)+arr.get(1)+arr.get(2)+arr.get(3));
        BigInteger   hughSum = BigInteger.ZERO;
                new BigInteger(arr.get(4)+arr.get(1)+arr.get(2)+arr.get(3));
        System.out.format("%d %d",lowSum,hughSum);
    }

}

public class MiniMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        MiniMaxSumResult.miniMaxSum(arr);

        bufferedReader.close();
    }
}


