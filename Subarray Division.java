import java.io.*;
import java.util.*;

public class Solution {

    public static int birthday(List<Integer> s, int d, int m) {
        int count = 0;
        int sum = 0;

        // If the required segment is longer than the array
        if (m > s.size()) {
            return 0;
        }

        // First window
        for (int i = 0; i < m; i++) {
            sum += s.get(i);
        }

        if (sum == d) {
            count++;
        }

        // Slide the window
        for (int i = m; i < s.size(); i++) {
            sum += s.get(i);
            sum -= s.get(i - m);

            if (sum == d) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> s = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            s.add(sc.nextInt());
        }

        int d = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(birthday(s, d, m));

        sc.close();
    }
}
