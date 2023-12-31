import java.util.HashSet;

public class Recursion2 {
    public static void main(String[] args) {
        // hanoi prob test
        // int n = 3;
        // HanoiProb(n, "S", "H", "D");

        // reverse string test
        // String a = "Hello";
        // printReverseString(a, 0);

        // first and last occurence test
        // String test = "abaacdaefaah";
        // firstAndLast(test, 'a', 0, -1, -1);

        // check if sorted test
        // int[] sorted = { 1, 2, 3, 4, 5 };
        // System.out.println(checkSorted(sorted, 0));

        // move element to last
        // System.out.println(moveToEnd("axbcxxd", 'x', 0, "", 0));

        // remove duplicate test
        // removeDuplicate("axbcxxdaaddkdaskjfhdjkadd", 0, "");

        // print all subsequesnces
        // printSubsequences("abc", 0, "");

        // preint unique subsequences
        // HashSet<String> set = new HashSet<>();
        // printUniqueSubsequence("aaa", 0, "", set);

        // print numkey
        printKeyPadComb("23", 0, "");
    }

    // Tower of Hanoi problem, o(2^n)
    public static void HanoiProb(int n, String src, String helper, String dest) {

        if (n == 1) {
            System.out.println("Transfer Disk " + n + " From " + src + " to " + dest);
            return;
        }
        HanoiProb(n - 1, src, dest, helper);
        System.out.println("Transfer Disk " + n + " From " + src + " to " + dest);
        HanoiProb(n - 1, helper, src, dest);
    }

    // print a string in reverse
    public static void printReverseString(String s, int i) {
        if (i == s.length()) {
            return;
        }
        System.out.print(s.charAt(s.length() - 1 - i));
        printReverseString(s, i + 1);
    }

    // find the first and last occurence of an element in a string
    // can use a helper funtion also, if the intial parameters are set to s and c
    public static void firstAndLast(String s, char c, int index, int first, int last) {
        if (index == s.length()) {
            System.out
                    .println("First occurence of char " + c + " in String " + s + " is at index " + first
                            + " and Last occurence at " + last);
            return;
        }
        if (c == s.charAt(index)) {
            if (first == -1) {
                first = index;
            } else {
                last = index;
            }
        }
        firstAndLast(s, c, index + 1, first, last);
    }

    // check if array is sorted in strictly increasing manner
    public static boolean checkSorted(int arr[], int index) {
        if (index == arr.length - 1) {
            return true;
        }
        if (arr[index] >= arr[index + 1]) {
            return false;
        }
        return checkSorted(arr, index + 1);

    }

    // move a charater to the end
    public static String moveToEnd(String s, char c, int index, String sol, int countChar) {
        if (index == s.length()) {
            for (int i = 0; i < countChar; i++) {
                sol = sol + c;
            }
            return sol;
        }
        if (s.charAt(index) == c) {
            countChar++;
            return moveToEnd(s, c, index + 1, sol, countChar);
        } else {
            sol = sol + s.charAt(index);
            return moveToEnd(s, c, index + 1, sol, countChar);
        }

    }

    // remove duplicates in a string
    public static boolean[] map = new boolean[26];
    // we crate an array to make a map out of it(ex:z-a = 25)

    public static void removeDuplicate(String s, int index, String newStr) {
        if (index == s.length()) {
            System.out.println(newStr);
            return;
        }
        if ((map[s.charAt(index) - 'a'] == true)) {
            removeDuplicate(s, index + 1, newStr);
        } else {
            newStr = newStr + s.charAt(index);
            map[s.charAt(index) - 'a'] = true;
            removeDuplicate(s, index + 1, newStr);
        }
    }

    // print all the subsequences of a string
    // time complexity, 2^n
    public static void printSubsequences(String s, int index, String newStr) {
        if (index == s.length()) {
            System.out.println(newStr);
            return;
        }
        // we add
        printSubsequences(s, index + 1, newStr + s.charAt(index));

        // we dont add
        printSubsequences(s, index + 1, newStr);
    }

    // unique subsequesnces of a string
    // hashset helps us to check if there is alread that substring or not
    public static void printUniqueSubsequence(String s, int index, String newStr, HashSet<String> set) {
        if (index == s.length()) {
            if (set.contains(newStr)) {
                return;
            } else {
                System.out.println(newStr);
                set.add(newStr);
                return;
            }

        }
        // we add
        printUniqueSubsequence(s, index + 1, newStr + s.charAt(index), set);

        // we dont add
        printUniqueSubsequence(s, index + 1, newStr, set);
    }

    // print keypad combinations
    // make a key
    public static String[] keypad = { ".", "abc", "def", "ghi", "jhl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static void printKeyPadComb(String s, int index, String newStr) {
        if (index == s.length()) {
            System.out.println(newStr);
            return;
        }

        String key = keypad[s.charAt(index) - '0'];
        for (char c : key.toCharArray()) {
            printKeyPadComb(s, index + 1, newStr + c);
        }

    }
}
