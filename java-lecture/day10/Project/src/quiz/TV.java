package quiz;
//다음 tv class를 참고하여 1~2번을 완성하시오.

class TV {

    private int size;

    public TV(int size) {
        this.size = size;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public String toString() {
        return "TV [size=" + size + ", getSize()=" + getSize() + "]";
    }
}
