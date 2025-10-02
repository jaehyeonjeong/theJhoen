package character;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.SortedMap;

public class CharsetMain {
    private static final Charset EUC_KR = Charset.forName("EUC-KR");
    public static void main(String[] args) {
        SortedMap<String, Charset> charsetSortedMap = Charset.availableCharsets();
        for(String charsetName : charsetSortedMap.keySet()) {       // 키 값이 String 이기 떄문에 for문으로 출력되는 Key위주로 출력함.
            System.out.println("charsetName : " + charsetName);
        }

        System.out.println("===================================");

        encoding("A", StandardCharsets.US_ASCII);
        encoding("A", StandardCharsets.ISO_8859_1);
        encoding("A", EUC_KR);
        encoding("A", StandardCharsets.UTF_8);
        encoding("A", StandardCharsets.UTF_16BE);

        System.out.println("===================================");

        encoding("가", StandardCharsets.US_ASCII);
        encoding("가", StandardCharsets.ISO_8859_1);
        encoding("가", EUC_KR);
        encoding("가", StandardCharsets.UTF_8);
        encoding("가", StandardCharsets.UTF_16BE);

        System.out.println("===================================");

        encoding("巄", StandardCharsets.US_ASCII);
        encoding("巄", StandardCharsets.ISO_8859_1);
        encoding("巄", EUC_KR);
        encoding("巄", StandardCharsets.UTF_8);
        encoding("巄", StandardCharsets.UTF_16BE);

        // 한글은 UTF-8에서 3바이트로 처리된다.

//        for(String charsetName : charsetSortedMap.keySet()) {
//            System.out.println("charsetName : " + charsetName);
//        }
    }
    static void encoding(String str, Charset charset) {

        byte[] bytes = str.getBytes(charset);
        System.out.printf("%s -> [%s] 인코딩 -> %s %sbyte\n", str, charset, Arrays.toString(bytes), bytes.length);
    }
}
