package blogquiz.blog3.answer;

import blogquiz.blog3.answer.exception.CsvFormatException01;

public class ClassValidator {
    public static void validate(String csv) {
        try {
            String[] csvs = csv.split(",");
            if(csv == null || csv.isBlank()) {
                throw new CsvFormatException01("csv는 필수 입력 사항입니다.", csv) ;
            }

            if(csvs.length !=3 ) {
                throw new CsvFormatException01("컬럼수는 3개이어야 합니다.", csv);
            }

            try {
                Integer.parseInt(csvs[1].trim());   // 숫자가아닌 다른 타입의 변수를 작성하면 catch

            } catch (NumberFormatException  e1) {
                throw new CsvFormatException01("나이는 정수여야 합니다. : " + e1.getMessage(), csv);
            }
            System.out.println(csv);
        } catch (CsvFormatException01 e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("csv 검사 종료");
        }
    }
}
