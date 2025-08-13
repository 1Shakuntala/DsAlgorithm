package Recursion;

import java.util.*;

public class SortStack {

    public static void insert(Stack<Integer>s, int value){
        if(s.isEmpty() || s.peek()<value){
            s.push(value);
            return;
        }
        int top = s.pop();
        insert(s, value);
        s.push(top);
    }

   public static void sortStack(Stack<Integer> s){
       if(s.isEmpty()) return;
       int top = s.pop();
       sortStack(s);
       insert(s, top);
   }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(4);

        System.out.println("Sorted Stack (largest at bottom): " + stack);

        sortStack(stack);

        System.out.println("Sorted Stack (smallest at bottom): " + stack);
    }
}
