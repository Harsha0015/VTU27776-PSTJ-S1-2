import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> frequency = new HashMap<>();

        int maxUnique = 0;

        for (int i = 0; i < n; i++) {
            // Add current element to deque and frequency map
            deque.addLast(nums[i]);
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);

            // Remove elements when window size exceeds k
            if (deque.size() > k) {
                int removed = deque.removeFirst();
                frequency.put(removed, frequency.get(removed) - 1);

                if (frequency.get(removed) == 0) {
                    frequency.remove(removed);
                }
            }

            // Update maximum unique count
            if (deque.size() == k) {
                maxUnique = Math.max(maxUnique, frequency.size());
            }
        }

        System.out.println(maxUnique);

        sc.close();
    }
}
