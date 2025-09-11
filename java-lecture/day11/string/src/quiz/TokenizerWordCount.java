package quiz;

import java.util.StringTokenizer;

public class TokenizerWordCount implements WordCounter {
    @Override
    public int nCountWord(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, " ");
        return stringTokenizer.countTokens();
    }
}
