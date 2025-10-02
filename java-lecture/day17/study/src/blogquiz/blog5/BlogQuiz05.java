package blogquiz.blog5;

public class BlogQuiz05 {
    public static void main(String[] args) {
        Stock[] stocks = new Stock[4];

        String[] strings = {"TSU-KSL", "TTL-SSU", "SRR-DDT", "WSS-ASD"};

        for(int i = 0; i < strings.length; i++){
            stocks[i] = new Stock(strings[i], (10 - i * 2), (5 + i * 2));
        }

        for(Stock stock : stocks) {
            try {
                stock.showAll();
            } catch (NotEnoughStockException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
