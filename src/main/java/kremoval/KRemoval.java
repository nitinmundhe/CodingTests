package kremoval;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class KRemoval {

    private int calculateABSMaximum(int[] array) {
        int maxValue = 0;
        for (int i = 0; i < array.length - 1; i++) {
            maxValue += Math.abs(array[i] - array[i + 1]);
        }
        return maxValue;
    }
    private int[] calculateDifferenceArray(int[] array) {
        int newArray[] = new int[array.length - 1];
        for (int i = 0; i < array.length - 1; i++) {
            newArray[i] = Math.abs(array[i] - array[i + 1]);
        }
        return newArray;
    }
    private int minIndex(int[] array) {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
                index = i;
            }
        }
        return index;
    }
    private int maxIndex(int[] array) {
        int max = Integer.MAX_VALUE+1;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
                index = i;
            }
        }
        return index;
    }
    private int solve(int[] array,int k){
        if(array.length - k == 1 )
            return array[maxIndex(array)];
        int[] diffArray = calculateDifferenceArray(array);
        int removeIndex;
        for(int i = 0; i< k; i++ ){
            removeIndex = minIndex(diffArray);
            for(int j = removeIndex; j < diffArray.length -1; j++){
                diffArray[j] = diffArray[j + 1];
            }
            for(int j = removeIndex+1; j < array.length -1; j++){
                array[j] = array[j + 1];
            }
        }
        int[] resultArray = new int[array.length-k];
        for(int i = 0; i< array.length-k; i++ ){
            resultArray[i] = array[i];
        }
        return calculateABSMaximum(resultArray);
    }
    public static void main(String args[]) throws Exception {
        KRemoval kRemoval = new KRemoval();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = br.readLine();
        int N = Integer.parseInt(firstLine.split(" ")[0]);
        int K = Integer.parseInt(firstLine.split(" ")[1]);

        String strarray[]  = br.readLine().split(" ");
        int[] inputArray = new int[N];
        for (int count = 0; count < N ; count++) {
            inputArray[count] = Integer.parseInt(strarray[count]);
        }
        System.out.println(kRemoval.solve(inputArray,K));
    }
}
