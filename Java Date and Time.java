import java.io.*;
import java.util.*;

class Result {

    public static String findDay(int month, int day, int year) {
        Calendar calendar = Calendar.getInstance();

        calendar.set(year, month - 1, day);

        String[] days = {
            "SUNDAY",
            "MONDAY",
            "TUESDAY",
            "WEDNESDAY",
            "THURSDAY",
            "FRIDAY",
            "SATURDAY"
        };

        return days[calendar.get(Calendar.DAY_OF_WEEK) - 1];
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(
            new InputStreamReader(System.in)
        );

        String[] firstMultipleInput = bufferedReader.readLine()
                .replaceAll("\\s+$", "")
                .split(" ");

        int month = Integer.parseInt(firstMultipleInput[0]);
        int day = Integer.parseInt(firstMultipleInput[1]);
        int year = Integer.parseInt(firstMultipleInput[2]);

        String res = Result.findDay(month, day, year);

        System.out.println(res);

        bufferedReader.close();
    }
}
