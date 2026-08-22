import java.io.*;
import java.util.*;

public class Solution {

    public static int marsExploration(String s) {
        String pattern = "SOS";
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != pattern.charAt(i % 3)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(marsExploration(s));

        sc.close();
    }
}
