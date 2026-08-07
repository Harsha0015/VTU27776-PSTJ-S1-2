import java.io.*;
import java.util.*;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {

    @Override
    public int compare(Player a, Player b) {
        if (a.score != b.score) {
            return b.score - a.score; // Descending score
        }
        return a.name.compareTo(b.name); // Ascending name
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Player[] player = new Player[n];

        for (int i = 0; i < n; i++) {
            player[i] = new Player(sc.next(), sc.nextInt());
        }

        Arrays.sort(player, new Checker());

        for (Player p : player) {
            System.out.println(p.name + " " + p.score);
        }

        sc.close();
    }
}
