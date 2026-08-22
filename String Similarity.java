import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read the number of test cases
        String tLine = br.readLine();
        if (tLine == null || tLine.trim().isEmpty()) return;
        int t = Integer.parseInt(tLine.trim());
        
        StringBuilder output = new StringBuilder();
        
        while (t-- > 0) {
            String s = br.readLine();
            if (s == null) break;
            s = s.trim();
            
            output.append(calculateSimilaritySum(s)).append("\n");
        }
        
        // Print all outputs at once
        System.out.print(output);
    }

    private static long calculateSimilaritySum(String s) {
        int n = s.length();
        int[] z = new int[n];
        
        // The similarity of the string with itself is always its total length
        long sum = n; 
        
        // Lower and upper bounds of the current Z-box
        int l = 0;
        int r = 0;
        
        for (int i = 1; i < n; i++) {
            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }
            
            // Explicitly match characters to expand the Z-box
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }
            
            // Update the Z-box boundaries if a match extends beyond the current window
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
            
            // Add the current suffix similarity to the total sum
            sum += z[i];
        }
        
        return sum;
    }
}
