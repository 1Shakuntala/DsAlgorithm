package Recursion;

import java.util.*;

public class ReverseStack {

    // Function to insert element at the bottom of the stack
    public static void insertAtBottom(Stack<Integer> stack, int value) {
        if (stack.isEmpty()) {
            stack.push(value); // if empty, just push
            return;
        }

        // Hold all items in Function Call Stack until we reach empty
        int top = stack.pop();
        insertAtBottom(stack, value);

        // Push back the held items
        stack.push(top);
    }

    // Function to reverse the stack
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return; // base case
        }

        // Remove the top element
        int top = stack.pop();

        // Reverse the remaining stack
        reverse(stack);

        // Insert the top element at the bottom
        insertAtBottom(stack, top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Push some elements
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
        }

        System.out.println("Original Stack: " + stack);

        reverse(stack);

        System.out.println("Reversed Stack: " + stack);
    }
}
