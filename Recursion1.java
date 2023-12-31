public class Recursion1 {
    public static void main(String[] args) {
        int n = 5;
        // printNum(n);
        // System.out.println(totalSum(n));
        // System.out.println(calcFactorial(n));
        // printFibonacci(0, 1, n);
        System.out.println(powerTo(2, n));
    }

    public static void printNum(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printNum(n - 1);
        System.out.println(n);
    }

    public static int totalSum(int n) {
        if (n == 0) {
            return 0;
        }
        return n + totalSum(n - 1);
    }

    public static int calcFactorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * calcFactorial(n - 1);
    }

    public static void printFibonacci(int a, int b, int n) {
        if (n == 0) {
            return;
        }
        System.out.println(a + b);
        printFibonacci(b, a + b, n - 1);
    }

    // public static int powerTo(int num, int power) {
    // if (num == 0) {
    // return 0;
    // }
    // if (power == 1) {
    // return num;
    // }
    // return num * powerTo(num, power - 1);
    // }
    // same but in log n (forms a tree)
    public static int powerTo(int num, int power) {
        if (power == 1) {
            return num;
        }
        if (power % 2 == 1) {
            return powerTo(num, power / 2) * powerTo(num, power / 2) * num;
        } else {
            return powerTo(num, power / 2) * powerTo(num, power / 2);
        }
    }
}