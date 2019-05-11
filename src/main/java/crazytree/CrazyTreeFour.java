package crazytree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class CrazyTreeFour {

    static boolean debug;
    static int M = 1299709;

    static void log(String s) {
        if(debug) {
            System.out.println(s);
        }
    }

    static void solve() throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = in.readLine();
        String parts[] = line.split(" ");
        int l = Integer.parseInt(parts[0]);
        int q = Integer.parseInt(parts[1]);
        int start, end;

        StringBuilder sb = new StringBuilder("");
        for (int testCases = 0; testCases < q; testCases++) {

            line = in.readLine();
            parts = line.split(" ");
            int n = Integer.parseInt(parts[0]);
            int x = Integer.parseInt(parts[1]);
            int y = Integer.parseInt(parts[2]);
            // log("n = " + n + ", x = " + x + ", y = " + y);

            long sum = 0;
            int levelBelow = l - n;
            // y = Math.min(y, 1 << (n - 1));

            if(n == l) {
                // Sum of n terms of arithmetic series
                sum = (long) (x + y) * (y - x + 1) / 2;
                // log("Sum = " + sum);
                sum %= M;

            } else {

                for(int i = x; i <= y; i++) {
                    start = (1 << levelBelow) * (i - 1) + 1;
                    end = start + (1 << levelBelow) - 1;

                    long num = 1;
                    for(int j = start; j <= end; j++) {
                        num = (num * j) % M;
                    }

                    sum = (sum + num) % M;
                }
            }

            out.write(sum + "\n");
        }

        out.close();
    }

    public static void main(String args[] ) throws Exception {

        if(args.length > 0 && "debug".equals(args[0])) {
            debug = true;
        }

        solve();
    }
}