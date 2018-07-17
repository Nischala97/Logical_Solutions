package Practice;

import java.util.*;
public class StackOperations 
{
	public static void main(String[] args)
	{
		Stack<Integer> stack=new Stack<>();
		for(int i=0;i<10;i++)
			stack.push(i);
		System.out.println(stack);
		stack.push(0);
		stack.push(2);
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		int i=stack.pop();
		System.out.println(i+" "+stack);
		System.out.println(stack.peek());
		int b=stack.search(9);
		System.out.println("9 "+b+" "+stack );
		b=stack.search(10);
		System.out.println("10 "+b+" "+stack);
	}
} 