import java.util.*;

public class Solution {

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();

        int[][] arr = new int[m][n];

        // Convert List<List<Integer>> to 2D array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = matrix.get(i).get(j);
            }
        }

        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {

            int top = layer;
            int left = layer;
            int bottom = m - 1 - layer;
            int right = n - 1 - layer;

            // Store the layer elements in anti-clockwise order
            List<Integer> elements = new ArrayList<>();

            // Left column: top -> bottom
            for (int i = top; i <= bottom; i++) {
                elements.add(arr[i][left]);
            }

            // Bottom row: left+1 -> right
            for (int j = left + 1; j <= right; j++) {
                elements.add(arr[bottom][j]);
            }

            // Right column: bottom-1 -> top
            for (int i = bottom - 1; i >= top; i--) {
                elements.add(arr[i][right]);
            }

            // Top row: right-1 -> left+1
            for (int j = right - 1; j > left; j--) {
                elements.add(arr[top][j]);
            }

            int len = elements.size();
            int shift = r % len;

            // Put rotated elements back
            int index = shift;

            // Left column
            for (int i = top; i <= bottom; i++) {
                arr[i][left] = elements.get(index);
                index = (index + 1) % len;
            }

            // Bottom row
            for (int j = left + 1; j <= right; j++) {
                arr[bottom][j] = elements.get(index);
                index = (index + 1) % len;
            }

            // Right column
            for (int i = bottom - 1; i >= top; i--) {
                arr[i][right] = elements.get(index);
                index = (index + 1) % len;
            }

            // Top row
            for (int j = right - 1; j > left; j--) {
                arr[top][j] = elements.get(index);
                index = (index + 1) % len;
            }
        }

        // Print result
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]);

                if (j < n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int r = sc.nextInt();

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                row.add(sc.nextInt());
            }

            matrix.add(row);
        }

        matrixRotation(matrix, r);

        sc.close();
    }
}
