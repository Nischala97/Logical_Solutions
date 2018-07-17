package Practice;

import java.util.*;
public class LinkedHashSetToRemove 
{
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		HashSet<Integer> hs=new LinkedHashSet<>();
		System.out.println("Enter number of elements");
		int n=s.nextInt();
		for(int i=0;i<n;i++)
			hs.add(i);
		hs.add(5);
		System.out.println(hs);
		System.out.println("Element to remove");
		int rem=s.nextInt();
		hs.remove(rem);
		System.out.println(hs);
	}
}
