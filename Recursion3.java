import java.util.ArrayList;

public class Recursion3 {
    public static void main(String[] args) {
        // printPermutaions("abc", "");

        // System.out.println(countPaths(3, 3, 0, 0));

        // System.out.println(placeTiles(4, 2));

        // System.out.println(invitePeople(4));

        ArrayList<Integer> subset = new ArrayList<>();
        findallSubsets(4, subset);
    }

    // print all permutaions
    // n! time complexity
    public static void printPermutaions(String s, String permutations) {
        if (s.length() == 0) {
            System.out.println(permutations);
        }
        for (int i = 0; i < s.length(); i++) {
            String newStr = s.substring(0, i) + s.substring(i + 1);
            printPermutaions(newStr, permutations + s.charAt(i));
        }
    }

    // Count total paths in a maze to move from (0,0) to (n,m)
    // given we can move towards right and only downwards
    // example matrix 3x3
    // (0,0),(0,1),(0,2)
    // (1,0),(1,1),(1,2)
    // (2,0),(2,1),(2,2)
    public static int countPaths(int n, int m, int i, int j) {
        if (i == n || j == m) {
            return 0;
        }
        if (i == n - 1 && j == m - 1) {
            return 1;
        }
        // down + right
        return countPaths(n, m, i + 1, j) + countPaths(n, m, i, j + 1);
    }

    // place tiles of size 1xm in a floor of size nxm
    public static int placeTiles(int n, int m) {
        if (n == m) {
            return 2;
        }
        // only horizontal placement
        if (m > n) {
            return 1;
        }
        // verical+horizontal
        return placeTiles(n - m, m) + placeTiles(n - 1, m);
    }

    // find the number of ways in which you can invite n people to your party,
    // single or pairs
    public static int invitePeople(int people) {
        if (people <= 1) {
            return 1;
        }
        // invite single person + invite in pairs(we mul because there are people-1
        // options for pair)
        return invitePeople(people - 1) + (people - 1) * (invitePeople(people - 2));
    }

    // print subsets of first n natural numbers
    public static void findallSubsets(int n, ArrayList<Integer> subset) {
        if (n == 0) {
            printSubset(subset);
            return;
        }
        // adding the element
        subset.add(n);
        findallSubsets(n - 1, subset);

        // not addind the subset
        // we first remove the added elemeent
        subset.remove(subset.size() - 1);
        findallSubsets(n - 1, subset);
    }

    public static void printSubset(ArrayList<Integer> subset) {
        for (int i = 0; i < subset.size(); i++) {
            System.out.print(subset.get(i) + " ");
        }
        System.out.println("");
    }
}
