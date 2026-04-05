package org.sirdarey.custom_algorithms;

public class CheckAPrimeNumber {

    public static void main(String[] args) {
        int number = 11;
        System.out.println();
        System.out.println(number + " is prime? " + isPrime(number));
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false; // 0 and 1 are not prime
        if (num <= 3) return true;  // 2 and 3 are prime

        if (num % 2 == 0 || num % 3 == 0) return false; // eliminate multiples of 2 and 3

        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false; // check for factors from 5 to sqrt(num)
            }
        }

        return true; // number is prime
    }
}