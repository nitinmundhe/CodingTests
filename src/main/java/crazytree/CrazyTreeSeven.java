package crazytree;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class CrazyTreeSeven {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] nos = line.split(" ");
        int level = Integer.parseInt(nos[0]);
        int query = Integer.parseInt(nos[1]);
        int count = 0;
        int[] levelStart = new int[level];
        for(int i =0; i < level ; i++)
        {
            levelStart[i] = count;
            count = count + (int)(Math.pow(2, level-1-i));
        }

        int[] bT = new int[count];
        long[] sT = new long[count];

        // create a binary tree of level
        for(int i =0; i < level ; i++)
        {
            int noOfNodes = (int)Math.pow(2, level-1-i);
            long sum = 0;
            for(int j = 0; j < noOfNodes; j++)
            {
                if(i == 0)
                {
                    bT[j] = j+1;
                    sum = sum + bT[j];
                    sT[j] = sum;
                }
                else
                {
                    int startNode = levelStart[i-1];
                    int childNode1 = startNode + 2 * (j);
                    int childNode2 = childNode1+1;
                    int currentNode = levelStart[i]+j;
                    long val = (long)bT[childNode1]  * (long)bT[childNode2];
                    val = val % 1299709;
                    sum = sum + val;
                    sT[currentNode] = sum;
                    bT[currentNode] = (int) val;
                }

            }
        }

        for(int i =0; i < query; i++)
        {
            line = br.readLine();
            String[] data = line.split(" ");
            int cL =  Integer.parseInt(data[0]);
            int s =  Integer.parseInt(data[1]) -1;
            int e =  Integer.parseInt(data[2]) -1;
            int startNode = levelStart[level-cL];
            int sNode = startNode + s;
            int eNode = startNode + e;
            long first = 0;
            long second = 0;
            if(sNode > startNode)
            {
                first = sT[sNode-1];
            }
            if(eNode >= startNode)
            {
                second = sT[eNode];
            }

            long rv = (second - first) %1299709;
            System.out.println((int)rv);
        }
    }
}
