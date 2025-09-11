package blogquiz.blog3.answer.exception;

public class CsvFormatException01 extends Exception {
    public CsvFormatException01(String message, String str) {
        super("원인 : " + message + " / [" + str + "]"); // 정수이어야 합니다.[kim, 서른, 서울]
    }

    public CsvFormatException01(String message) {
        super("원인 : " + message);
    }

}
