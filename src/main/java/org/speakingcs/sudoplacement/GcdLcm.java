package sudoplacement;

import java.util.Scanner;

/**
 * Program to calculate GCD and LCM
 */
public class GcdLcm {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int noOfTestCases = sc.nextInt();
        for(int i = 0; i < noOfTestCases; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();

            int gcd = getGcd(num1, num2);
            int lcm = getLcm(num1, num2, gcd);
            int lcm2 = getLcm2(num1, num2);

            System.out.printf("lcm 1 = %d , lcm 2 = %d, gcd = %d \n", lcm, lcm2, gcd);
        }

    }

    private static int getLcm2(int num1, int num2) {

        int min, max, prod = -1;

        if(num1 <= num2) {
            min = num1;
            max = num2;
        } else {
            min = num2;
            max = num1;
        }

        for(int i = 1; ; i++) {
            prod = min * i;
            if( prod % max == 0) {
                return prod;
            }
        }

    }

    private static int getGcd(int num1, int num2) {

        int min = num1 < num2 ? num1 : num2;

        int gcd = 1;

        for(int i = 2; i <= min; i++) {

            if(num1 %i == 0 && num2 %i == 0) {
                gcd = i;
            }

        }
        return gcd;

    }

    private static int getLcm(int num1, int num2, int gcd) {

        return (num1 * num2) / gcd;

    }

}
