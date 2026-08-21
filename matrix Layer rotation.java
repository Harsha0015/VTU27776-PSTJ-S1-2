import java.io.*;
import java.util.*;

public class Solution {

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();

        int[][] result = new int[m][n];

        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {
            int top = layer;
            int left = layer;
            int bottom = m - 1 - layer;
            int right = n - 1 - layer;

            // Store elements of this layer in anti-clockwise order:
            // left column (top -> bottom),
            // bottom row (left+1 -> right),
            // right column (bottom-1 -> top),
            // top row (right-1 -> left+1)
            List<Integer> elements = new ArrayList<>();

            for (int i = top; i <= bottom; i++)
                elements.add(matrix.get(i).get(left));

            for (int j = left + 1; j <= right; j++)
                elements.add(matrix.get(bottom).get(j));

            for (int i = bottom - 1; i >= top; i--)
                elements.add(matrix.get(i).get(right));

            for (int j = right - 1; j > left; j--)
                elements.add(matrix.get(top).get(j));

            int len = elements.size();
            int shift = r % len;

            // After anti-clockwise rotation, each element moves
            // 'shift' positions forward in this representation.
            int index = shift;

            // Left column
            for (int i = top; i <= bottom; i++) {
                result[i][left] = elements.get(index);
                index = (index + 1) % len;
            }

            // Bottom row
            for (int j = left + 1; j <= right; j++) {
                result[bottom][j] = elements.get(index);
                index = (index + 1) % len;
            }

            // Right column
            for (int i = bottom - 1; i >= top; i--) {
                result[i][right] = elements.get(index);
                index = (index + 1) % len;
            }

            // Top row
            for (int j = right - 1; j > left; j--) {
                result[top][j] = elements.get(index);
                index = (index + 1) % len;
            }
        }

        // Print result
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j > 0) System.out.print(" ");
                System.out.print(result[i][j]);
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
