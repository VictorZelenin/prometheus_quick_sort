package main;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by User on 30.01.2016.
 */
public class Main {

    public static long constant = 0;


    public void quickSort(int[] testArray, int p, int r) {

        if (testArray.length < 2 || p == r) {
            return;
        }
        int i = findIndex(testArray, p, r);
//        System.out.println(Arrays.toString(testArray));
//        System.out.println("MEDIAN: " + testArray[i]);

        int temp = testArray[i];
        testArray[i] = testArray[r - 1];
        testArray[r - 1] = temp;

        //swap(testArray, i, r);

        int index = partition(testArray, p, r);

        quickSort(testArray, p, index);
        quickSort(testArray, index + 1, r);


    }

    public int partition(int[] testArray, int l, int r) {


        if (r == 1 && l == 0) {
            return 0;
        }

        int n = r - 1;
        int i = l - 1;


        for (int j = l; j < n; j++) {
            constant++;
            if (testArray[j] <= testArray[n]) {
                i++;
                int temp = testArray[j];
                testArray[j] = testArray[i];
                testArray[i] = temp;

            }
        }

        int temp = testArray[n];
        testArray[n] = testArray[i + 1];
        testArray[i + 1] = temp;

        //System.out.println("ARRAY: " + Arrays.toString(testArray));
        return i + 1;
    }


    private int findIndex(int[] array, int left, int right) {

        if (right - left == 1 || right - left == 0) {
            return left;
        }

        int[] tempArray = new int[3];

        int firstIndex = left;
        int middleIndex = (left + right - 1) / 2;
        int lastIndex = right - 1;


        tempArray[0] = array[firstIndex];
        tempArray[1] = array[middleIndex];
        tempArray[2] = array[lastIndex];

//        for (int i = 0; i < 3; i++){
//            System.out.print(array[i] + " ");
//        }
//
//        System.out.println();
        Arrays.sort(tempArray);


//        System.out.println("FIRST: " + array[firstIndex] + " index: " + firstIndex);
//        System.out.println("SECOND: " + array[middleIndex] + " index: " + middleIndex);
//        System.out.println("THIRD: " + array[lastIndex] + " index: " + lastIndex);


        // System.out.println(Arrays.toString(tempArray));
        if (array[firstIndex] == tempArray[1]) {
            return firstIndex;
        } else if (array[middleIndex] == tempArray[1]) {
            return middleIndex;
        } else return lastIndex;


    }


    public static int[] parseData(File file) throws IOException {
        int[] result = new int[10];
        Scanner scanner = new Scanner(file);
        int j = 0;


        while (scanner.hasNext()) {

            result[j] = scanner.nextInt();
            j++;
        }


        return result;
    }


    public static void main(String[] args) throws IOException {


        int[] test1 = parseData(new File("input__10.txt"));

        new Main().quickSort(test1, 0, test1.length);


//        System.out.println(new Main().findIndex(new int[]{1, 2, 5}, 0, 3));

//        new Main().quickSort(new int[]{8, 2, 4, 5, 7, 1}, 0, 6);


        System.out.println(constant);


    }
}
