class Solution {
    public boolean rotateString(String s, String goal) {
        // Rotations are only possible if lengths are equal
        if (s.length() != goal.length()) {
            return false;
        }

        // Any rotation of s will appear in s + s
        return (s + s).contains(goal);
    }
}
