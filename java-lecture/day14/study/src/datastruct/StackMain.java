package datastruct;

import java.util.Stack;

public class StackMain {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);

        System.out.println("stack.peek() === " + stack.peek());

        int num01 = stack.pop();
        int num02 = stack.pop();
        int num03 = stack.pop();
        System.out.println(num01);
        System.out.println(num02);
        System.out.println(num03);
        System.out.println(stack);
    }
}
