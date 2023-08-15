package com.leetCode;

public class SumofTwoIntegers {

    public static void main(String[] args) {
        System.out.println(getSum(12,3));

        //another solution but slower and easier LOL
        System.out.println(Integer.sum(12,3));

    }

    public static int getSum(int a, int b) {
        while(b !=0){
            int tmp = (a & b) << 1; //builds the carry by and shift left
            a = a ^ b; //XOR bit (gives sum without carry)
            b = tmp; // b = the carry
        }
        return a;
    }


}


