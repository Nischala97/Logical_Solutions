package Practice;

import java.util.*;
import java.util.Scanner;

public class CollectionSearch {

	public static void main(String[] args)
	{
		ArrayList<Integer> list=new ArrayList<>();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter number");
		int n=s.nextInt();
		for(int i=0;i<n;i++)
		{
			list.add(i);
		}
		System.out.println(list);
		System.out.println("Enter element to search");
		int se=s.nextInt();
		System.out.println(list.contains(se));
		Iterator it=list.listIterator();
		int flag=-1,c=0;
		while(it.hasNext())
		{
			c++;
			int i=(Integer)it.next();
			if(i==se) {flag=c;break;}
		}
		if(flag>0)
		System.out.println("Element found at "+flag);
		else
			System.out.println("element not found");
	}

}
