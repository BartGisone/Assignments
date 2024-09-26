package lab4;

import java.util.NoSuchElementException;

public class QueueTester {

	public static void main(String[] args) {


		Queue<Integer> q1 = new YorkArrayQueue<>();
		System.out.println("size of queue is ==> "+ q1.size());
		try {
		q1.dequeue();
		}catch (NoSuchElementException e) {
			System.out.println("Should throw NoSuchElementException - "+ e.getMessage());;
		}
		System.out.println("Queue = "+ q1);
		for (int i =0; i<15;i++)
			q1.enqueue(i);
		System.out.println("size of queue is ==> "+ q1.size());
		System.out.println("Queue = "+ q1);
		System.out.println("Front of queue is : "+ q1.first());
		q1.dequeue();
		q1.dequeue();
		q1.dequeue();
		q1.dequeue();
		System.out.println("Front of queue is : "+ q1.first());
		System.out.println("Queue = "+ q1);
		q1.clear();
		System.out.println("size of queue is ==> "+ q1.size());
		System.out.println("Queue = "+ q1);
		
		for (int i =0; i<=15;i++)
			q1.enqueue(i);
		q1.enqueue(13);
		q1.enqueue(50);
		
		System.out.println("size of queue is ==> "+ q1.size());
		System.out.println("Queue = "+ q1);
		
		System.out.println("Queue contains 50 ==>"+ q1.contains(50));
		

	}

}
