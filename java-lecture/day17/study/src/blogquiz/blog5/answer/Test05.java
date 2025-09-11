package blogquiz.blog5.answer;

import blogquiz.blog5.answer.exception.NotEnoughStockException;

public class Test05 {
    public static void main(String[] args) {
        Inventory inventory = new Inventory(6);

        try{
            inventory.take("빵", 7);

        } catch (NotEnoughStockException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("남은 제고 : " + inventory.getStock());
        }
    }
}
