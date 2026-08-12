import java.util.*;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {

        // Store height -> name
        HashMap<Integer, String> map = new HashMap<>();

        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }

        // Sort heights in descending order
        Arrays.sort(heights);

        String[] result = new String[names.length];

        // Pick names according to descending heights
        int index = 0;

        for (int i = heights.length - 1; i >= 0; i--) {
            result[index++] = map.get(heights[i]);
        }

        return result;
    }
}
