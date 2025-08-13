package Recursion;

import java.util.*;

public class DeleteMiddleElement {

    public static void deleteMiddle(Stack<Integer> stack, int current, int size) {
        // Base case: middle reached
        if (current == size / 2) {
            stack.pop(); // remove middle element
            return;
        }

        // Remove top element temporarily
        int top = stack.pop();

        // Recursive call
        deleteMiddle(stack, current + 1, size);

        // Put the top element back after deleting middle
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Push some values
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
        }

        System.out.println("Original Stack: " + stack);

        deleteMiddle(stack, 0, stack.size());

        System.out.println("After deleting middle: " + stack);
    }
}
