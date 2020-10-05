// Java program to implement Queue using 
// two stacks with costly deQueue and front operation.
//enqueue-O(1), rear-O(n), dequeue-O(1), rear-o(1)
//dequeue and rear operations may take O(n) in worst case.
//But as the probability of occurrences of worst case is very low. As movement of element from one stack to another is reduced.
//So, by amortized analysis dequeue and front is also considered O(1)

import java.util.*; 

class GFG 
{ 
static class Queue 
{ 
	Stack<Integer> s1; 
	Stack<Integer> s2; 
  	int rearValue=-1;
  	public int front()
    {
      if(s2.size()==0)
      while(s1.size()!=0)
        s2.push(s1.pop());
      return s2.peek();
    }
  	public int rear()
    {
      if(s1.size()==0 && s2.size()==0)
        return -1;
      return rearValue;
    }
	public Queue()
    {
      s1 = new Stack<Integer>();
      s2 = new Stack<Integer>();
      //rearValue=1;
    }
	void enQueue(int x) 
	{ 
        rearValue=x;
		s1.push(x);
	} 

	// Dequeue an item from the queue 
	int deQueue() 
	{ 
      if(s2.size()==0)
		while(s1.size()!=0)
        {
          if(s2.size()==0)
            rearValue=s1.peek();
          s2.push(s1.pop());
        }
      	return s2.pop();
	} 
}; 

// Driver code 
public static void main(String[] args) 
{ 
	Queue q = new Queue(); 
	q.enQueue(1); 
	q.enQueue(2);
  	System.out.println("Rear= "+q.rear());
	q.enQueue(3); 
	//System.out.println(q.front());
  	System.out.println("Rear= "+q.rear());
	System.out.println(q.deQueue()); 
  	System.out.println("Rear= "+q.rear());
	System.out.println(q.deQueue()); 
	System.out.println(q.deQueue()); 
} 
} 

// This code is contributed by Prerna Saini 
