package crazytree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CrazyTreeOne {

    private long[] tree;
    private int[] ar;
    private int[] levelIndexes;
    private long[] prefixSum;
    private final int M = 1299709;

    public CrazyTreeOne(int L) {
        ar = leafArray(L);
        int n = ar.length;
        tree = new long[2 * n - 1];
        build(0, 0, n - 1);
        levelIndexes = new int[L + 1];
        constructLevelArray(L);
        prefixSum = new long[2 * n - 1];
        prefixSum(L);
    }

    private int[] leafArray(int L) {
        int n = 1 << L - 1;
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = i + 1;
        }
        return ar;
    }

    private void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = ar[start];
            return;
        }
        int mid = mid(start, end);
        build(2 * node + 1, start, mid);
        build(2 * node + 2, mid + 1, end);
        tree[node] = (tree[2 * node + 1] % M * tree[2 * node + 2] % M) % M;
    }

    private void constructLevelArray(int L) {
        levelIndexes[1] = 0;
        for (int i = 2; i <= L; i++) {
            levelIndexes[i] = 2 * levelIndexes[i - 1] + 1;
        }
    }

    private void prefixSum(int L) {
        for (int l = 1; l <= L; l++) {
            int idx = levelIndexes[l];
            int until = 2 * idx + 1;
            prefixSum[idx] = tree[idx];
            for (int j = idx + 1; j < until; j++) {
                prefixSum[j] = (prefixSum[j - 1] % M + tree[j] % M) % M;
            }
        }
    }

    private int mid(int start, int end) {
        return start + (end - start) / 2;
    }

    public long query(int N, int X, int Y) {
        int idx = levelIndexes[N];
        int end = idx + Y - 1;
        int start = idx + X - 1;
        if (X == 1) {
            return prefixSum[end];
        }
        return ((prefixSum[end] - prefixSum[start - 1]) % M + M) % M;
    }

    private static int intOf(String n) {
        return Integer.parseInt(n);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line1 = in.readLine().split(" ");
        int L = intOf(line1[0]);
        int Q = intOf(line1[1]);
        CrazyTreeOne crazyTree = new CrazyTreeOne(L);
        while (Q-- > 0) {
            String[] query = in.readLine().split(" ");
            int N = intOf(query[0]);
            int X = intOf(query[1]);
            int Y = intOf(query[2]);
            long res = crazyTree.query(N, X, Y);
            out.write(res + "\n");
        }
        out.flush();
    }
}