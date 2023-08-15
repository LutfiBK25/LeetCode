package com.leetCode.PalindromeNumber;

public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrome(100));


    }
    public static boolean isPalindrome(int x) {
        boolean ans = true; //innocent until proven guilty
        if(x < 0) return false;
        Integer num = x;
        String s = num.toString();
        if (s.length() % 2 != 0){ //if dividing numbers to two sets not even
            int middleNumIndex = (s.length() - 1) /2;
            for (int i = 0; i <= middleNumIndex ; i++)
                if (s.charAt(middleNumIndex - i) != s.charAt(middleNumIndex + i)) return false;
        } else {
            int right_middle = s.length() / 2;
            int left_middle = (s.length() - 1) / 2;
            for (int i = 0; i < right_middle; i++)
                if (s.charAt(right_middle + i) !=(s.charAt(left_middle - i))) return false;
        }
        return ans;
    }

    //Leet Code Solution
    public boolean isPalindromeSolution(int x) {
        if (x < 0) {
            return false;
        }

        long reversed = 0;
        long temp = x;

        while (temp != 0) {
            int digit = (int) (temp % 10);
            reversed = reversed * 10 + digit;
            temp /= 10;
        }

        return (reversed == x);
    }
}
