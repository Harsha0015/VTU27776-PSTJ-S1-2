import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (p.length() > s.length()) {
            return result;
        }

        int[] countP = new int[26];
        int[] countWindow = new int[26];

        // Frequency of characters in p
        for (char c : p.toCharArray()) {
            countP[c - 'a']++;
        }

        int windowSize = p.length();

        // Create the first window
        for (int i = 0; i < windowSize; i++) {
            countWindow[s.charAt(i) - 'a']++;
        }

        // Check first window
        if (Arrays.equals(countP, countWindow)) {
            result.add(0);
        }

        // Slide the window
        for (int i = windowSize; i < s.length(); i++) {
            // Add new character
            countWindow[s.charAt(i) - 'a']++;

            // Remove old character
            countWindow[s.charAt(i - windowSize) - 'a']--;

            // Check if current window is an anagram
            if (Arrays.equals(countP, countWindow)) {
                result.add(i - windowSize + 1);
            }
        }

        return result;
    }
}
