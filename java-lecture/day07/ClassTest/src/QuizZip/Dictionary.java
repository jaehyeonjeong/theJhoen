package QuizZip;

class Dictionary {
    private static String[] kor = {"사랑", "아기", "돈", "미래", "희망"};
    private static String[] eng = {"love", "baby", "money", "future", "hope"};

    public static String kor2Eng(String word) {
        // 한국어 사전 전체 범위
        for (int i = 0; i < kor.length; i++) {
            // 한글을 찾으면
            if (kor[i].equals(word)) {
                // 같은 인덱스의 eng[i]를 출력
                return eng[i];
            }
        }
        return word + "는 저의 사전에 없습니다.";
    }
}
