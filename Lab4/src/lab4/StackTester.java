package lab4;

import java.util.*;

public class StackTester {

	public static void main(String[] args) {
		

	        Stack<String> s1 = new YorkArrayStack<>();
	        
	        System.out.println("Stack size is zero ===> " + s1.size());
	        try {
	        	s1.top();
	        } catch (EmptyStackException e) {
	        	System.out.println("Should throw EmptyStackException - "+ e.getMessage());;
			}

	        s1.push("EECS2101");
	        s1.push("LAB4");
	        s1.push("My Stack Array");
	        System.out.println("TOP of stack is\'My Stack Array\'==> "+  s1.pop());
	        s1.push("Current Term");
	        System.out.println("Stack size is 3 ===> " + s1.size());
	        
	        while (!s1.isEmpty()) {
	            System.out.println(s1.pop());
	        }
	        System.out.println(">>>>>-------------<<<<<<<");
	        System.out.println(">>>>>Create stack of Integers<<<<<<<");
	        Random rand =  new Random();
	        Integer [] a = new Integer[16];
	        
	        for (int i =0; i<a.length;i++)
	        	a[i]= rand.nextInt(20)+5;
	        Stack<Integer> s2 = new YorkArrayStack<>(a);
	        System.out.println("Stack size is 16 ===> " + s2.size());
	        s2.push(50);
	        System.out.println("Stack size is 17 ===> " +  s2.size());
	        
	        System.out.println("-------------------");
	        
	        //Stack<Integer> temp = new YorkArrayStack<>(a);
	        //temp.push(50);
	        //for(int i = 0; i < temp.size(); i++) {
	        //	System.out.print(s2.pop() + " ");
	        //}
	        //System.out.println("");
	        //System.out.println(s2.size());
	        //System.out.println("-------------------");
	        
	        System.out.println("Top of Stack is 50 ==>" + s2.top());
	        while (!s2.isEmpty()) {
	            System.out.println(s2.pop());
	        }
	        System.out.println(">>>>>-------------<<<<<<<");
	        System.out.println("Stack size is 0 ===> " + s2.size());
	        
	        for (int i=0; i<14;i++) {
	        	s1.push("Element "+i);
	        }
	        System.out.println("Stack size is 14 ==> "+ s1.size());
	        s1.clear();
	        System.out.println("Stack size is 0 ==> "+ s1.size());
	        
	}

}
