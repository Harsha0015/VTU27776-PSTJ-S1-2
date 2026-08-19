import java.util.*;

public class Solution {

    public static int diagonalDifference(List<List<Integer>> arr) {
        int n = arr.size();

        int primary = 0;
        int secondary = 0;

        for (int i = 0; i < n; i++) {
            // Left-to-right diagonal
            primary += arr.get(i).get(i);

            // Right-to-left diagonal
            secondary += arr.get(i).get(n - 1 - i);
        }

        return Math.abs(primary - secondary);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                row.add(sc.nextInt());
            }

            arr.add(row);
        }

        System.out.println(diagonalDifference(arr));

        sc.close();
    }
}
