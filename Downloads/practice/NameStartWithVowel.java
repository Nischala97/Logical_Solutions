package Practice;

import java.util.*;
public class NameStartWithVowel 
{
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		List<String> list=new ArrayList<>();
		System.out.println("Enter number of names");
		int n=s.nextInt();
		String str="";
		while(n>0)
		{
			System.out.print("Enter name:");
			str=s.next();
			list.add(str);n--;
		}
		//System.out.println(list);
		Iterator it=list.iterator();
		while(it.hasNext())
		{
			String st=(String)it.next();
			if(st.startsWith("a")|| st.startsWith("e")||st.startsWith("i")||st.startsWith("o")||st.startsWith("u"))
			{
				System.out.print(st+" ");				
			}
		}
	}
}
