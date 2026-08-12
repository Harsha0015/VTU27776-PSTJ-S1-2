class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        
        String[] week = {
            "Sunday", "Monday", "Tuesday",
            "Wednesday", "Thursday", "Friday", "Saturday"
        };

        int[] daysInMonth = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        // Count days from 1971 up to the given year
        int totalDays = 0;

        for (int y = 1971; y < year; y++) {
            if (isLeapYear(y)) {
                totalDays += 366;
            } else {
                totalDays += 365;
            }
        }

        // If current year is leap year, February has 29 days
        if (isLeapYear(year)) {
            daysInMonth[1] = 29;
        }

        // Add days from previous months
        for (int m = 0; m < month - 1; m++) {
            totalDays += daysInMonth[m];
        }

        // Add current day - 1
        totalDays += day - 1;

        // January 1, 1971 was Friday
        // Friday has index 5
        int index = (5 + totalDays) % 7;

        return week[index];
    }

    private boolean isLeapYear(int year) {
        return (year % 400 == 0) ||
               (year % 4 == 0 && year % 100 != 0);
    }
}
