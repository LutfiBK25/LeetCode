package com.leetCode.RomanToInteger;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String roman = "MCMXCIV";
        System.out.println(romanToInt(roman));
    }





    public static int romanToInt(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case ('I') -> ans += 1;
                case ('V') -> ans += 5;
                case ('X') -> ans += 10;
                case ('L') -> ans += 50;
                case ('C') -> ans += 100;
                case ('D') -> ans += 500;
                case ('M') -> ans += 1000;
            }
            if (i != 0) {
                if (s.charAt(i - 1) == 'I') {
                    switch (s.charAt(i)) {
                        case ('V'), ('X'):
                            ans -= 2;
                    }


                } if (s.charAt(i - 1) == 'X') {
                    switch (s.charAt(i)) {
                        case ('C'), ('L'):
                            ans -= 20;
                    }


                } if (s.charAt(i - 1) == 'C') {
                    switch (s.charAt(i)) {
                        case ('D'), ('M'):
                            ans -= 200;
                    }


                }

            }
        }


        return ans;
    }

    //other solution
    class Solution {
        public int romanToInt(String s) {
            Map<Character, Integer> m = new HashMap<>();

            m.put('I', 1);
            m.put('V', 5);
            m.put('X', 10);
            m.put('L', 50);
            m.put('C', 100);
            m.put('D', 500);
            m.put('M', 1000);

            int ans = 0;
            //i will go through the world size
            for (int i = 0; i < s.length(); i++) {
                //if it is not the last letter && this letter is less than the letter after
                if (i < s.length() - 1 && m.get(s.charAt(i)) < m.get(s.charAt(i + 1))) {
                    //subtract the letter value from the answer
                    ans -= m.get(s.charAt(i));
                } else {
                    //add the letter value to the answer
                    ans += m.get(s.charAt(i));
                }
            }

            return ans;
        }
    }
}
