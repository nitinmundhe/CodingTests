package CommanFactors;

import java.io.BufferedReader;
import java.io.InputStreamReader;
class TestClass {
    long gcd(long first, long second) {
        if (first == 0) return second;
        return gcd(second % first, first);
    }
    long commDivsors(long first, long second) {
        long number = gcd(first, second);
        long result = 0;
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                if (number / i == i) result += 1;
                else result += 2;
            }
        }
        return result;
    }
    public static void main(String args[]) throws Exception {
        TestClass testClass = new TestClass();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        long n1 = Long.parseLong(line.split(" ")[0]);
        long n2 = Long.parseLong(line.split(" ")[1]);
        System.out.println(testClass.commDivsors(n1, n2));
    }
}