import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Set<String> pairs = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String first = sc.next();
            String second = sc.next();

            // Combine the pair into one unique string
            pairs.add(first + " " + second);

            System.out.println(pairs.size());
        }

        sc.close();
    }
}
