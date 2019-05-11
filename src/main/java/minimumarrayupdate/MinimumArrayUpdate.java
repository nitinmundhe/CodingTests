package minimumarrayupdate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
class TestClass {
    private long getSum(long[] nums){
        long sum=0;
        for(int i=0;i< nums.length;i++){
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String args[]) throws Exception {
        TestClass testClass = new TestClass();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        long n1 = Long.parseLong(line1.split(" ")[0]);
        String line2 = br.readLine();
        String[] stringNumbers = line2.split(" ");
        long[] data = new long[stringNumbers.length];
        for (int i = 0; i < stringNumbers.length; i++) {
            data[i] = Long.parseLong(stringNumbers[i]);
        }
        long sum = testClass.getSum(data);
        long newSum = 0;
        long i=1;
        int length = data.length;
        while(newSum <= sum){
            newSum = length*i;
            i++;
        }
        System.out.println(--i);
    }
}