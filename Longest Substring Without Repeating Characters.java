class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastIndex = new int[128];

        // -1 means the character has not appeared
        for (int i = 0; i < 128; i++) {
            lastIndex[i] = -1;
        }

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // Move left past the previous occurrence
            if (lastIndex[ch] >= left) {
                left = lastIndex[ch] + 1;
            }

            lastIndex[ch] = right;

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
