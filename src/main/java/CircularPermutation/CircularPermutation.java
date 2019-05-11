package CircularPermutation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class CircularPermutation {
    private ArrayList<int []> accStore = new ArrayList<int[]>();
    private int N;
    private int A;
    private int length;
    private int[] input;
    public static void main(String args[]) throws Exception {
        CircularPermutation circularPermutation = new CircularPermutation();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        circularPermutation.N = Integer.parseInt(line.split(" ")[0]);
        circularPermutation.A = Integer.parseInt(line.split(" ")[1]);
        circularPermutation.length = (1 << circularPermutation.N );
        circularPermutation.input = new int[circularPermutation.length];

        circularPermutation.input[0] = 0;

        for (int i = 1; i < circularPermutation.length; i++) {
            circularPermutation.input[i] = i;
        }

        int fact=1;

        circularPermutation.solve();

        //circularPermutation.accStore.forEach(value -> System.out.println(Arrays.toString(value)));
        //System.out.println("Size of Array is "+circularPermutation.accStore.size());

    }
    public void solve(){

        storeAllRecursive(length,input);

        for(int i=0; i< accStore.size();i++){
            int[] testCase = accStore.get(i);
            if(verifyConstraints(testCase))
                System.out.println(Arrays.toString(testCase));
        }
    }

    public boolean verifyConstraints(int[] testCase){
        boolean isValid=false;
        boolean constraintOne=false;
        boolean constraintTwo=false;
        if(testCase[0]!=A) return false;

        for(int j=0;j<length-1;j++){
            if(differAtOneBitPos(testCase[0],testCase[length-1]))
                constraintOne=true;
            if(differAtOneBitPos(testCase[j],testCase[j+1]))
                constraintTwo=true;
        }

        if(constraintOne && constraintTwo)
            isValid=true;
        else
            isValid=false;
        return isValid;
    }

    public void storeAllRecursive(int n, int[] elements) {
        if(n == 1) {
            accStore.add(saveArray(elements));
        } else {
            for(int i = 0; i < N-1; i++) {
                storeAllRecursive(n - 1, elements);
                if(n % 2 == 0) {
                    swap(elements, i, n-1);
                } else {
                    swap(elements, 0, n-1);
                }
            }
            storeAllRecursive(n - 1, elements);
        }
    }
    private int[] saveArray(int[] array)
    {
        int[] newarray = new int[array.length];
        System.arraycopy(array, 0, newarray, 0, array.length);
        return newarray;
    }
    private int[] swap(int[] input, int a, int b) {
        int tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
        return input;
    }
    private boolean isPowerOfTwo(int x) {
        return x != 0 && ((x & (x - 1)) == 0);
    }
    private boolean differAtOneBitPos(int a, int b) {
        return isPowerOfTwo(a ^ b);
    }
}