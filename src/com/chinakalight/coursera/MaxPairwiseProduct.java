package com.chinakalight.coursera;

/**
 * @author - Chinaka .I. Light <ichinaka@byteworks.com.ng>
 * Date: 07/10/2020
 */
import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(int[] numbers) {
        long max_product = 0l;
        int n = numbers.length;

        for (int first = 0; first < n; ++first) {
            for (int second = first + 1; second < n; ++second) {
                max_product = Math.max(max_product,
                        ((long)numbers[first] * (long)numbers[second]));
            }
        }

        return max_product;
    }
    static long getMaxPairwiseProductFast(int[] numbers) {
        long max_product = 0l;
        int n = numbers.length;

        int firstMaxNum = 0;
        for (int i = 0; i < n; i++) {
            if((numbers[i]) > numbers[firstMaxNum])
                firstMaxNum = i;
        }

        int secondMaxNum = 0;
        if(firstMaxNum == secondMaxNum) secondMaxNum = 1;
        for (int first = 0; first < n; ++first) {
            if((first != firstMaxNum) & (numbers[first] > numbers[secondMaxNum])) {
//                if(numbers[first] > numbers[secondMaxNum]) {
                    secondMaxNum = first;
//                }
            }
        }

        System.out.println("NUM: " + numbers[firstMaxNum] + " " + numbers[secondMaxNum]);
                max_product = Math.max(max_product,
                        ((long)numbers[firstMaxNum] * (long)numbers[secondMaxNum]));

        return max_product;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProductFast(numbers));
//        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
/*
    static class FasterScanner{
        BufferedReader br;
        StringTokenizer st;

        public FasterScanner(InputStream inputStream){
            try{
                br = new BufferedReader( new InputStreamReader(inputStream) );
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
*/

}
