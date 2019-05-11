package crazytree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class CrazyTreeSix {
    // private static long[] tree;
    private static int[] levels;
    private static long[] tree;
    private static final int M = 1299709;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));
//		reader = new BufferedReader(new FileReader(new File(
//				"input/crazytree.txt")));
        PrintWriter out = new PrintWriter(System.out);
        int[] a = readLine(reader);
        int l = a[0];
        int q = a[1];
        tree = new long[(int) Math.pow(2, l)];
        levels = new int[l];
        levels[l - 1] = 1;
        int index = 1, k = 1, s = 0;
        while (Math.pow(2, l - 1) >= 1) {
            for (int i = 1; i <= Math.pow(2, l - 1); i++) {
                if (s == 0)
                    tree[index++] = i;
                else
                    tree[index++] = (tree[k++] * tree[k++]) % M;
            }
            s += 1;
            l -= 1;
            if (l != 0)
                levels[l - 1] = index;
        }
        while (q-- > 0) {
            a = readLine(reader);
            int n = a[0], x = a[1], y = a[2], ind = levels[n - 1] - 1 + x;
            long count = 0;
            if (n == levels.length) {
                count = (long) (((y - x + 1) / 2.0) * (2 * x + y - x));
                out.append(count % M + "\n");
            } else {
                for (; x <= y; x++) {
                    count += tree[ind++];
                }
                out.append(count % M + "\n");
            }
        }
        out.flush();
        out.close();
    }

    private static int[] readLine(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        String[] elements = line.split(" ");
        int[] input = new int[elements.length];
        for (int i = 0; i < elements.length; i++)
            input[i] = Integer.parseInt(elements[i]);
        return input;

    }
}