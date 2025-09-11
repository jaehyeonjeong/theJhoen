package QuizZip;

public class Grade {
    int nMath;
    int nScience;
    int nEnglish;

    public Grade() {

    }

    public Grade(int nMath, int nScience, int nEnglish) {
        this.nMath = nMath;
        this.nScience = nScience;
        this.nEnglish = nEnglish;
    }

    int average() {
        return (nMath + nScience + nEnglish) / 3;
    }
}
