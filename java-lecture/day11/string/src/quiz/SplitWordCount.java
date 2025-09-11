package quiz;

public class SplitWordCount implements WordCounter {
    @Override
    public int nCountWord(String str) {
        String[] strArray = str.split(" ");
        return strArray.length;
    }
}
