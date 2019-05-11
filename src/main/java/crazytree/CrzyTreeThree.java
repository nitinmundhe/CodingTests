package crazytree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CrzyTreeThree {

    private static long[] tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int L = Integer.parseInt(input[0]);
        int Q = Integer.parseInt(input[1]);

        int totalNodes = (int) Math.pow(2, L);
        tree = new long[totalNodes];
        int llIndex = (int) Math.pow(2, L - 1);

        long count = 1;
        for (int l = llIndex; l < totalNodes; l++) {
            tree[l] = count++;
        }

        for (int q = 0; q < Q; q++) {
            String[] magicIns = br.readLine().split(" ");

            int level = Integer.parseInt(magicIns[0]);
            int x = Integer.parseInt(magicIns[1]);
            int y = Integer.parseInt(magicIns[2]);

            int startIndex = (int) Math.pow(2, level - 1);

            if (tree[startIndex] == 0) {
                fillTreeLevel(L, level);
            }

            long diff = y - x;

            if (level == L) {
                long sum = (diff * (diff + 1)) / 2;
                long result = (diff + 1) * x + sum;
                System.out.println(result % 1299709);

            } else {

                x = startIndex + x - 1;
                long result = tree[x];

                while (diff != 0) {
                    result %= 1299709;
                    result += tree[++x];
                    diff--;
                }

                System.out.println(result % 1299709);
            }
        }
    }

    private static void fillTreeLevel(int totalLevel, int reqdLevel) {

        int numOfNodes = 0;
        int llIndex = 0;

        for (int level = totalLevel - 1; level >= reqdLevel; level--) {

            llIndex = (int) Math.pow(2, level - 1);

            if (tree[llIndex] != 0) {
                continue;
            }

            numOfNodes = llIndex;

            while (numOfNodes != 0) {
                tree[llIndex] = (tree[(2 * llIndex)] % 1299709) * (tree[((2 * llIndex) + 1)] % 1299709);
                llIndex++;
                numOfNodes--;
            }

        }
    }

}