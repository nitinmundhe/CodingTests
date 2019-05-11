package ticketcounter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TicketCounterOne {

    static int[][] result = null;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int n = Integer.parseInt(line);
        line = br.readLine();
        int e = Integer.parseInt(line);
        int[][] fromJunctions = new int[n + 1][2];
        int[] toJunction = new int[n + 1];
        int[][] pCount = new int[n + 1][2];
        result = new int[n + 1][2];
        for (int i = 0; i < e; i++) {
            line = br.readLine();
            String[] lineArr = line.split(" ");
            int sjunction = Integer.parseInt(lineArr[0]);
            int ejunction = Integer.parseInt(lineArr[1]);
            int count = Integer.parseInt(lineArr[2]);
            toJunction[sjunction] = ejunction;
            if (fromJunctions[ejunction][0] == 0) {
                fromJunctions[ejunction][0] = sjunction;
                pCount[ejunction][0] = count;
            } else {
                fromJunctions[ejunction][1] = sjunction;
                pCount[ejunction][1] = count;
            }

        }
        int exit = 0;
        for (int i = 1; i < toJunction.length; i++) {
            if (toJunction[i] == 0 && (fromJunctions[i][0] != 0 || fromJunctions[i][1] != 0)) {
                exit = i;
                break;
            }
        }
        int x = minPath(exit, fromJunctions, pCount);
        System.out.print(x);
        Map<Integer, List<Integer>> printMap = new TreeMap<Integer, List<Integer>>();

        print(result, exit, new ArrayList<Integer>(), printMap);

        for (List<Integer> l : printMap.values()) {
            System.out.println();
            for (int i = l.size() - 1; i >= 0; i--) {
                if (i == 0) {
                    System.out.print(l.get(i));
                } else {
                    System.out.print(l.get(i) + " -> ");
                }
            }
        }
    }

    public static void print(int[][] result, int node, ArrayList<Integer> path, Map<Integer, List<Integer>> printMap) {
        if (node == 0) {
            return;
        }
        path.add(node);
        if (result[node][0] == 0 && result[node][1] == 0) {
            ArrayList<Integer> newPath = new ArrayList<>(path);
            printMap.put(newPath.get(newPath.size() - 1), newPath);
        } else {
            print(result, result[node][0], path, printMap);
            print(result, result[node][1], path, printMap);
        }
        path.remove(path.size() - 1);
    }

    static int minPath(int to, int[][] fromJunctions, int[][] pCount) {

        if (fromJunctions[to][0] == 0) {
            return 0;
        }
        int x = 0;
        x = (minPath(fromJunctions[to][0], fromJunctions, pCount) + pCount[to][0]);

        int y = 0;
        y = (minPath(fromJunctions[to][1], fromJunctions, pCount) + pCount[to][1]);
        int temp = x;
        if (x >= y) {
            x += y;
        } else {
            x = x * 2 + 1;
        }
        if (y != 0) {
            if (y >= temp) {
                y += temp;
            } else {
                y = y * 2 + 1;
            }
            if (x > y) {
                result[to][0] = fromJunctions[to][1];
                return y;
            } else if (y > x) {
                result[to][0] = fromJunctions[to][0];
                return x;
            } else {
                result[to][0] = fromJunctions[to][0];
                result[to][1] = fromJunctions[to][1];
                return x;
            }
        } else {
            result[to][0] = fromJunctions[to][0];
            return x;
        }
    }

}
