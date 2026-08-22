import java.io.*;
import java.util.*;

class Result {

    public static List<Integer> maxSubarray(List<Integer> arr) {

        int current = arr.get(0);
        int maxSubarray = arr.get(0);

        int maxElement = arr.get(0);
        int maxSubsequence = 0;

        for (int num : arr) {

            // Maximum subarray - Kadane's Algorithm
            if (num == arr.get(0)) {
                continue;
            }

            current = Math.max(num, current + num);
            maxSubarray = Math.max(maxSubarray, current);

            // Maximum subsequence
            if (num > 0) {
                maxSubsequence += num;
            }

            maxElement = Math.max(maxElement, num);
        }

        // If all numbers are negative
        if (maxSubsequence == 0) {
            maxSubsequence = maxElement;
        }

        return Arrays.asList(maxSubarray, maxSubsequence);
    }
}

public class Solution {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();

            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                arr.add(sc.nextInt());
            }

            List<Integer> result = Result.maxSubarray(arr);

            System.out.println(result.get(0) + " " + result.get(1));
        }

        sc.close();
    }
}
