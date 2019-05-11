import java.util.Arrays;
import java.util.Iterator;

public class Product {

    public int[] product_without_self(int[] arr) {
        int[] result = new int[arr.length];
        result[result.length-1] = 1;

        for(int i=arr.length-2; i>=0; i--) {
            result[i] = result[i+1] * arr[i+1];
        }

        int left = 1;
        for(int i=0; i<arr.length; i++) {
            result[i] *= left;
            left *= arr[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int arr[] = {10, 4, 1, 6, 2};
        int prod[] = {48,120,480,80,240};
        Product product = new Product();
        int resultArr[] = product.product_without_self(arr);
        Iterator<Integer> iterator = Arrays.stream(resultArr).iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

}
