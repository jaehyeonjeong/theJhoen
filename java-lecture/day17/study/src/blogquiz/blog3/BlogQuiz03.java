package blogquiz.blog3;

public class BlogQuiz03 {
    public static void main(String[] args) {
        CsvFormat[] csvFormats = new CsvFormat[3];

        csvFormats[0] = new CsvFormat("정재현", 29, "파주");
        csvFormats[1] = new CsvFormat("정다현", 28);
        csvFormats[2] = new CsvFormat("정해영");

        for(CsvFormat csvFormat : csvFormats) {
            try {
                csvFormat.showAll();
            } catch (CsvFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
