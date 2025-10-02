package datastruct;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeStack {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();      // Deque를 stack으로 사용할 수 있음
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);      // LIFO (Last In First Out)
        System.out.println("stack.peek() === " + stack.peek());
        System.out.println("stack.pop() === " + stack.pop());
        System.out.println("stack.pop() === " + stack.pop());
        System.out.println("stack.pop() === " + stack.pop());
        System.out.println(stack);
    }
}
