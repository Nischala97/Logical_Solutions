package arraylist;
import java.util.*;

public class Vector_EvenNumbers 
{
    public static void main(String[] args)
    {
        Vector<Integer> vec=new Vector<>();
        Scanner s=new Scanner(System.in);
        System.out.println("Enter number:");
        int n=s.nextInt();
        for(int i=0;i<n;i++)
        {
            vec.add(i);
        }
        
        Enumeration e=vec.elements();
        while(e.hasMoreElements())
        {
            int i=(Integer)e.nextElement();
            if(i%2==0)
                   System.out.print(i+" ");
        }
        System.out.println();
    }
}
