package Practice;

import java.util.*;
public class LinkedList_OddNumbers {

	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter number");
		int n=s.nextInt();
		LinkedList<Integer> list=new LinkedList<>();
		for(int i=0;i<n;i++)
		{
			list.add(i);
		}
		ListIterator it=list.listIterator();
		while(it.hasNext())
		{
			int i=(Integer)it.next();
			if(i%2!=0)
				System.out.print(i+" ");
		}
	}
}
