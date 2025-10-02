package blogquiz.blog2;

public class WeakPassword{
    private final String strPW;

    public WeakPassword(String strPW) {
        this.strPW = strPW;
    }

    public String getStrPW() {
        return strPW;
    }

    public String checkPassWord() {
        if(strPW.length() < 8) {
            return strPW;
        }
        else {
            throw new WeakPasswordException("비밀번호가 8자리 이상입니다.");
        }
    }
}
