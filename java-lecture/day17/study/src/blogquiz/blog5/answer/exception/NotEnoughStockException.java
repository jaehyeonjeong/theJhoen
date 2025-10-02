package blogquiz.blog5.answer.exception;

public class NotEnoughStockException extends RuntimeException{
    // 클래스이기 때문에 필드를 가져도 상관없다.

    private final String sku;
    private final int available;
    private final int request;

    public NotEnoughStockException(String sku, int available, int request) {
        super("제고 부족 : " + sku + " available : " + available + " request : " + request);
        this.sku = sku;
        this.available = available;
        this.request = request;
    }
}
