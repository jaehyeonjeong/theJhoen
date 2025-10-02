package quiz;

import java.util.Stack;

public class Quiz01 {
    public static void main(String[] args) {
        //Deque<String> stack = new ArrayDeque<>();
        Stack<String> stack = new Stack<>();    // Deque를 이용한 방법도 있다.

        stack.push("www.youtube.com");
        stack.push("www.google.com");
        stack.push("www.facebook.com");
        System.out.println(stack);
        System.out.println("stack.pop() === " + stack.pop());
        System.out.println("stack.pop() === " + stack.pop());
        System.out.println("stack.pop() === " + stack.pop());
        System.out.println(stack);


    }
}
