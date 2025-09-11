package subject;

import java.util.Arrays;

public class StringMethod {
    public static void main(String[] args) {
        String text = "hello world, hello java";

        StringBuffer stringBuffer = new StringBuffer(text);

        System.out.println(stringBuffer.capacity());

    }
}
