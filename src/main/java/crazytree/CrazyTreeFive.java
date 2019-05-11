package crazytree;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class CrazyTreeFive {
    public static long ar[] = new long[10000001];
    public static long tree[] = new long[10000001];
    public static int pos[] = new int[22];
    public static long pre[][] = new long[22][1048577];
    public static long mod = 1299709;

    public static void build_tree(int node, int i, int j, int level) {
        if (i == j) {
            tree[node] = ar[i];
            pre[level][++pos[level]] = tree[node];
            return;
        }
        build_tree(2 * node, i, (i + j) / 2, level + 1);
        build_tree(2 * node + 1, (i + j) / 2 + 1, j, level + 1);
        tree[node] = tree[2 * node] * tree[2 * node + 1];
        tree[node] %= mod;
        pre[level][++pos[level]] = tree[node];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int l, x, y, n, q, i, j;
        String inp[] = new String[4];
        inp = br.readLine().split(" ");
        n = Integer.parseInt(inp[0]);
        q = Integer.parseInt(inp[1]);
        int limit = (int) Math.pow(2, n - 1);
        for (i = 1; i <= limit; i++)
            ar[i] = i;
        for (i = 1; i <= n; i++)
            pos[i] = 0;
        build_tree(1, 1, limit, 1);
        for (i = 1; i <= n; i++)
            for (j = 1; j <= pos[i]; j++) {
                pre[i][j] = ((pre[i][j - 1] + pre[i][j]));
            }
        while (q-- > 0) {
            inp = br.readLine().split(" ");
            l = Integer.parseInt(inp[0]);
            x = Integer.parseInt(inp[1]);
            y = Integer.parseInt(inp[2]);
            out.println((pre[l][y] - pre[l][x - 1] + mod) % mod);
        }
        out.close();
        br.close();
    }

}