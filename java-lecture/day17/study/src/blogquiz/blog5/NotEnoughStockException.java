package blogquiz.blog5;

public class NotEnoughStockException extends RuntimeException{
    public NotEnoughStockException(String message) {
        super(message);
    }
}
