package Recursion;

import java.util.*;

public class SortStack {

    // Insert an element into a sorted stack
    static void insertSorted(Stack<Integer> stack, int value) {
        // Base case: empty stack or top <= value
        if (stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
            return;
        }

        // Remove top and recurse
        int top = stack.pop();
        insertSorted(stack, value);

        // Put the top back
        stack.push(top);
    }

    // Sort stack using recursion
    static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        // Remove top element
        int top = stack.pop();

        // Sort remaining stack
        sortStack(stack);

        // Insert top element back in sorted order
        insertSorted(stack, top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(4);

        sortStack(stack);

        System.out.println("Sorted Stack (smallest at bottom): " + stack);
    }
}
