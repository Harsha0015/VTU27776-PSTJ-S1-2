import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of lines
        int n = sc.nextInt();

        // Create ArrayList of ArrayLists
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        // Read each line
        for (int i = 0; i < n; i++) {

            // Number of integers in this line
            int d = sc.nextInt();

            ArrayList<Integer> row = new ArrayList<>();

            // Store the integers
            for (int j = 0; j < d; j++) {
                row.add(sc.nextInt());
            }

            list.add(row);
        }

        // Number of queries
        int q = sc.nextInt();

        // Process each query
        while (q-- > 0) {

            int x = sc.nextInt();
            int y = sc.nextInt();

            try {
                // x = line number, y = position
                // -1 because ArrayList uses 0-based indexing
                System.out.println(list.get(x - 1).get(y - 1));
            } catch (Exception e) {
                System.out.println("ERROR!");
            }
        }

        sc.close();
    }
}
