package lab4;



public class YorkQueueUsingStackTester {
	
	public static void main(String[] args) {
		YorkQueueUsingStacks<Integer> q1 = new YorkQueueUsingStacks<>();
		System.out.println("size of Queue is 0: ==> "+ q1.size());
	    // insert into queue
	    for(int i = 1; i <= 13; i++)
	        q1.enqueue(i);
	    System.out.println("size of Queue is 13: ==> "+ q1.size());
	    System.out.println("Dequeued 10 elements : ");
	    for(int i = 0; i < 10; i++)
	       System.out.println(q1.dequeue());
	    System.out.println("size of Queue is 3: ==> "+ q1.size());
	    System.out.println("==========================");
	    // insert more elements 
	    for(int i = 50; i <= 54; i++)
	        q1.enqueue(i);
	    System.out.println("size of Queue is 8: ==> "+ q1.size());
	    System.out.println("==========================");
	    // dequeue the rest
	    while(!q1.isEmpty())
	        System.out.println("Dequeued: " + q1.dequeue());
	    System.out.println("size of Queue is 0: ==> "+ q1.size());
	    System.out.println("==========================");
	    //// test the toString 
	 // insert more elements 
	    for(int i = 100; i <= 108; i++)
	        q1.enqueue(i);
	    System.out.println("size of Queue is 8: ==> "+ q1.size());
	    System.out.println("queue : "+ q1);
	    System.out.println("First element of the queue is 100 ==>"+ q1.first());
	    // three dequeue 
	    q1.dequeue();q1.dequeue();q1.dequeue();
	    System.out.println("==========================");
	    System.out.println("queue : "+ q1);
	    System.out.println("==========================");
	    // test contains queue should contains 103, 104, 105, 106, 107, 108
	    System.out.println(q1.contains(103));
	    System.out.println(q1.contains(108));
	    
	    System.out.println(q1.contains(109));
	    System.out.println("==========================");
	    System.out.println("queue : "+ q1);

	    
	    
	    
	}
	
}
