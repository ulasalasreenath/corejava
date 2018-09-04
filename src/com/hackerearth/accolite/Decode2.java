package com.hackerearth.accolite;

import java.io.*;
import java.util.*;


public class Decode2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            String P = br.readLine();
            String Q = br.readLine();
            int cost_size = Integer.parseInt(br.readLine().trim());
            String[] arr_cost = br.readLine().split(" ");
            int[] cost = new int[cost_size];
            for(int i_cost=0; i_cost<arr_cost.length; i_cost++)
            {
            	cost[i_cost] = Integer.parseInt(arr_cost[i_cost]);
            }

            int out_ = amount_to_pay(Q, P, cost);
            System.out.println(out_);
         }

         wr.close();
         br.close();
    }
    static int amount_to_pay(String Q, String P, int[] cost){
        // Return the amount monk has to pay  Write your code here
        int max_amount = 0;

		for (int i = 0; i < P.length(); i++) {
			int amount = getAmountToPay(P, Q, cost, i);
			if (amount > max_amount) {
				max_amount = amount;
			}
		}
        
        return max_amount;
    }
    
    private static int getAmountToPay(String str1, String prefix, int[] cost, int index) {

		int amount = 0;

		if (index + 1 >= str1.length()) {
			return 0;
		}

		for (int i = index; i < str1.length();) {
			String subStr = str1.substring(i);
			if (subStr.startsWith(prefix)) {
				amount += cost[i];
				i += 2;
			} else {
				i++;
			}
		}
		return amount;
	}
}
