
package com.chinakalight.algo.sumof50algospractice;

class MedianPrac {
    public static void main(String[] args) {
        int[] array1 = { 1, 3, 5 };
        int[] array2 = {2, 3, 6 };

        double medianVal = median(array1, array2);

        System.out.println("MEDIAN:-VALUE:  " + medianVal);

    }

    static double median (int[] array1, int[] array2){
        int[] array_combined = new int[array1.length + array2.length];
        int i = 0, j = 0;
        while(i < array1.length && j < array2.length){
            if(array1[i] < array2[j]){
                array_combined[i] = array1[i];
                i++;
            }else{
                array_combined[j] = array2[j];
                j++;
            }
        }

        for (int k = 0; k < array_combined.length; k++) {
            System.out.print( array_combined[k] + " ");
        }

        while(i < array1.length ){
            array_combined[i] = array1[i];
            i++;
        }

        while (j < array2.length){
            array_combined[j] = array2[j];
            j++;
        }

        if(array_combined.length % 2 == 0 ){
            return (array_combined[array_combined.length / 2] + array_combined[array_combined.length / 2 + 1])/2.0;
        }else{
            return array_combined[array_combined.length/2 + 1];
        }
    }
}
