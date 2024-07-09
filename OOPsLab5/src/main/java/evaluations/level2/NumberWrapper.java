package evaluations.level2;

public class NumberWrapper <T extends Number>{
    T content;

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}