class Solution {
    public boolean repeatedSubstringPattern(String s) {
        // Create a doubled string
        String doubled = s + s;
        
        // Remove the first and last characters, then check if original 's' exists inside
        return doubled.substring(1, doubled.length() - 1).contains(s);
    }
}
