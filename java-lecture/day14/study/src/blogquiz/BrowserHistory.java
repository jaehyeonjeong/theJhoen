package blogquiz;

import java.util.ArrayDeque;
import java.util.Deque;

public class BrowserHistory {
    private final Deque<String> urlStack = new ArrayDeque<>();
    private final Deque<String> urlfront = new ArrayDeque<>();
    private String url;

    public void visitPage(String url){
        // 다음게 들어올 때 원래 가지고 있던 데이터를 푸쉬하고
        // this.url 변수로 새로운 데이터를 저장
        if(this.url != null) {
            urlStack.push(this.url);
        }
        this.url = url;
        System.out.println("방문 : " + url);
    }

    public String goBack(){
        if(!urlStack.isEmpty()) {
            this.url = urlStack.pop();
            return this.url;
        }
        return null;
    }
}
