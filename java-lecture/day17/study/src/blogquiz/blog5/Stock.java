package blogquiz.blog5;

public class Stock {
    private String sku;
    private Integer available;
    private Integer requested;

    public Stock(String sku, Integer available, Integer requested) {
        this.sku = sku;
        this.available = available;
        this.requested = requested;
    }

    public void showAll() {
        System.out.println("물픔 : " + sku + ", 현재 수량 : " + available + ", 필요 수량 :");
        outOfStock();
    }

    public void outOfStock() {
        if(available < requested) {
            throw new NotEnoughStockException("재고가 부족 합니다.");
        }
    }
}
