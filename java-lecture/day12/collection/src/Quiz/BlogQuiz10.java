package Quiz;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class BlogQuiz10 {
    //

    public static void main(String[] args) {
        List<Word> list = new List<>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Word> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Word word) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Word> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Word> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public Word get(int index) {
                return null;
            }

            @Override
            public Word set(int index, Word element) {
                return null;
            }

            @Override
            public void add(int index, Word element) {

            }

            @Override
            public Word remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Word> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Word> listIterator(int index) {
                return null;
            }

            @Override
            public List<Word> subList(int fromIndex, int toIndex) {
                return List.of();
            }
        };

        list.add(new Word("constructor", "생성자"));
        list.add(new Word("overriding", "재정의"));
        list.add(new Word("extends", "상속"));
        list.add(new Word("array", "배열"));
        list.add(new Word("string", "문자열"));
        list.add(new Word("character", "문자"));
        list.add(new Word("integer", "정수"));
        list.add(new Word("double", "실수"));
        list.add(new Word("abstract", "추상"));
        list.add(new Word("implements", "구현하다"));

        System.out.println("Java 단어 테스트를 시작합니다. -1을 입력하면 종료합니다.");
        System.out.println("현재 " + list.size() + "개의 단어가 들어 있습니다.");

        Iterator<Word> listIterator = list.iterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

    }
}
