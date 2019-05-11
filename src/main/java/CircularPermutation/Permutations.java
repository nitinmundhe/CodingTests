package CircularPermutation;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author David
 */
public class Permutations {
    public static int[] a;
    public final int SIZE = 4;
    public final int NUMPERM;
    public final ArrayList<int[]> newlist;

    public Permutations()
    {

        a = new int[SIZE];
        for(int x = 0; x < SIZE; x++)
            a[x] = x;
        NUMPERM = Factorial(a.length);
        newlist = new ArrayList<>(NUMPERM);
    }
    public void permute()
    {
        permutation(a,0,a.length);
    }

    private void permutation(int array[],int start, int end)
    {
        newlist.add(saveArray(array));

        if (start<end)
        {
            int i,j;
            for(i=end-2; i>=start; i--)
            {
                for(j=i+1; j<end; j++)
                {
                    Swap(array,i,j);
                    permutation(array,i+1,end);
                }
                Rotate_Left(array,i,end);
            }
        }
    }
    private int[] saveArray(int[] array)
    {
        int[] newarray = new int[array.length];

        System.arraycopy(array, 0, newarray, 0, array.length);
        return newarray;
    }

    public void Print()
    {        //just to prove the list works
        System.out.println("the current size of newlist is : " + newlist.size());
        int[] array = new int[a.length];
        for(int x = 0; x < newlist.size(); x++)
        {
            array = newlist.get(x);
            System.out.println(Arrays.toString(array));
        }
    }
    private void Swap(int array[],int i,int j)
    {
        int t;
        t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
    private void Rotate_Left(int array[],int start,int end)
    {
        int tmp = array[start];
        for (int i=start; i < end-1; i++)
        {
            array[i] = array[i+1];
        }
        array[end-1] = tmp;
    }
    private int Factorial(int a)
    {
        int fact = 1;
        for(int x = a; x > 0; x++)
            fact *= a;
        return fact;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Permutations newperm = new Permutations();
        newperm.permute();
        newperm.Print();


    }
}