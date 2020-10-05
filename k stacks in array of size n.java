// Java program to demonstrate implementation of k stacks in a single 
// array in time and space efficient way 

// Time for each push-O(1), pop-O(1), peek-O(1)
//space 3*n + 2*k- Total, 2n+2k extra, O(n)

import java.util.*;
public class GFG 
{ 
	// A Java class to represent k stacks in a single array of size n 
	static class KStack 
	{ 
	  int stack[]; //actual stack
      ArrayList<Integer> free; // to prev track of all free spaces in the stack array
      int top[]; //top of stack[i]
      int size[]; // size of stack[i]
      int prev[]; // index of previous index of stack[i] in the stack array
      
      KStack(int k, int n)
      {
        stack = new int[n];
        free =new ArrayList<Integer>(n);
		prev= new int[n];
        top=new int[k];
        size=new int[k];
        
        Arrays.fill(top, -1);
        Arrays.fill(prev, -1);
        for(int i=0; i<n; i++)
          free.add(i,i);
      }
      
      void push(int val, int k) throws Exception
      {
        if(free.size()!=0)
        {
        int pos=free.get(0);
        stack[pos]=val;//value inserted
          
        free.remove(0);//free removed
          
        prev[k]=top[k];//prev modified
        
        top[k]=pos;//top modified
          
        size[k]++;
        }
        else
        {
          throw new Exception("No space for any element. Array full");
        }
      }
      
      int pop(int k) throws Exception
      {
        if(size[k]!=0)
        {
        size[k]--;//size modified
          
        int val=stack[top[k]];//got value
          
        free.add(top[k]);//free modified
          
        int curTop= top[k];
          
        top[k]=prev[curTop];// modified top
          
        prev[curTop]=-1; //prev modified
          
         return val;
        }
        else
        {
          throw new Exception("Stack is empty");
        }
      }
      
      int peek(int k) throws Exception
      {
        if(top[k]!=-1)
        {
          return stack[top[k]];
        }
        else
          throw new Exception("Stack is empty);
      }
	} 

	// Driver program 
	public static void main(String[] args) 
	{ 
		// Let us create 3 stacks in an array of size 10 
		int k = 3, n = 10; 
		
		KStack ks = new KStack(k, n); 

		ks.push(15, 2); 
		ks.push(45, 2); 

		// Let us put some items in stack number 1 
		ks.push(17, 1); 
		ks.push(49, 1); 
		ks.push(39, 1); 

		// Let us put some items in stack number 0 
		ks.push(11, 0); 
		ks.push(9, 0); 
		ks.push(7, 0); 

		System.out.println("Popped element from stack 2 is " + ks.pop(2)); 
		System.out.println("Popped element from stack 1 is " + ks.pop(1)); 
		System.out.println("Popped element from stack 0 is " + ks.pop(0)); 
	} 
} 
// This code is Contributed by Sumit Ghosh 
