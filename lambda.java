import java.util.*;

interface PerformOperation {
    boolean check(int a);
}

class MyMath {

    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    PerformOperation isOdd() {
        return n -> n % 2 != 0;
    }

    PerformOperation isPrime() {
        return n -> {
            if (n < 2) return false;
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) return false;
            }
            return true;
        };
    }

    PerformOperation isPalindrome() {
        return n -> {
            int temp = n, rev = 0;
            while (temp > 0) {
                rev = rev * 10 + temp % 10;
                temp /= 10;
            }
            return rev == n;
        };
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyMath ob = new MyMath();
        int T = sc.nextInt();

        while (T-- > 0) {
            int ch = sc.nextInt();
            int num = sc.nextInt();

            if (ch == 1)
                System.out.println(MyMath.checker(ob.isOdd(), num) ? "ODD" : "EVEN");
            else if (ch == 2)
                System.out.println(MyMath.checker(ob.isPrime(), num) ? "PRIME" : "COMPOSITE");
            else
                System.out.println(MyMath.checker(ob.isPalindrome(), num) ? "PALINDROME" : "NOT PALINDROME");
        }
        sc.close();
    }
}
