package blogquiz.blog5.answer;

import blogquiz.blog5.answer.exception.NotEnoughStockException;

// 제고 물품
public class Inventory {
    private int stock;

    public Inventory(int stock) {
        this.stock = stock;     // 남은 물품
    }

    public int getStock() {
        return stock;
    }

    public void take(String sku, int qty) {
        // 예상가능
        if(qty < 0) {
            throw new IllegalArgumentException("수량은 0보다 작을 수 없습니다.");
        }

        if(qty > stock) {
            throw new NotEnoughStockException(sku, stock, qty);
        }

        stock -= qty;
    }

}
