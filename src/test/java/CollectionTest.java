import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.Collection;
import java.util.stream.Collectors;


public class CollectionTest {
    public void methodIterator(Collection list){
        Iterator iterator = list.iterator();

        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }

    public void methodFor(Collection list){
        for (Object next : list) {
            System.out.println(next);
        }
    }

    @Nested
    @DisplayName("arrayList : 한 덩어리의 큰 배열을 사용하는 방식이다.")
    public class ArrayList{
        Collection listA = new java.util.ArrayList();
        Collection listADest = new java.util.ArrayList();

        @Test
        @DisplayName("이터레이터 사용해 값 가져오기")
        public void useIterator(){
            listA.add("aa");
            listA.add("bb");
            listA.add("cc");
            methodIterator(listA);

            //이터레이터로 가져온 값들을 listADest에 넣음
            listADest.addAll(listA);
            listADest.stream()
                    .map(list -> list.toString())
                    .collect(Collectors.toList());
            System.out.println("m :"+listADest);


        }

        @Test
        @DisplayName("두 for문 사용해 값 가져오기")
        public void useFor(){
            listA.add("강아지");
            listA.add("고양이");
            listA.add("얼룩말");

            methodFor(listA);
        }

        @Test
        @DisplayName("인덱스 값 찾기")
        public void findElementIdx(){
            listA.add("강아지");
            listA.add("고양이");
            listA.add("얼룩말");

            String list = "사자";
            String list2 = "악어";

            listA.add(list);
            listA.add(list2);
            int index1 = ((java.util.ArrayList<?>) listA).indexOf(list);
            int index2 = ((java.util.ArrayList<?>) listA).indexOf(list2);
            int lastindex = ((java.util.ArrayList<?>) listA).lastIndexOf(list2);

            System.out.println("index1 : "+ index1);
            System.out.println("index2 : "+ index2);
            System.out.println("lastIndex2 : "+ lastindex);
        }

        @Test
        @DisplayName("리스트 포함 여부 찾기")
        public void containElement(){
            String txt = "element 1";
            listA.add(txt);

            //element 1 있는지 확인
            boolean containElement = listA.contains("element 1");
            System.out.println("element 1있는지 : "+containElement);

            //element 1 있는지 확인
            boolean containsAllElement = listA.containsAll(listA);
            System.out.println("listA있는지 :"+containsAllElement);

            listA.add(null);

            //null 체크
            containElement = listA.contains(null);
            System.out.println("null : "+containElement);
        }

        @Test
        @DisplayName("리스트 삭제")
        public void removeList(){
            listA.add("강아지");
            listA.add("고양이");
            listA.add("얼룩말");

            //특정 문자 삭제
            listA.remove("얼룩말");
            System.out.println(listA);

            //리스트 전체 삭제
            listA.removeAll(listA);
            System.out.println(listA);
        }

        @Test
        @DisplayName("두 리스트 교집합")
        public void retainAll(){
            Collection colA = new java.util.ArrayList();
            Collection colB = new java.util.ArrayList();

            colA.add("A");
            colA.add("B");
            colA.add("C");

            colB.add("1");
            colB.add("2");
            colB.add("3");
            colB.add("A");

            Collection target = new HashSet();

            target.addAll(colA);
            System.out.println(target);
            target.addAll(colB);
            System.out.println(target);

            target.retainAll(colB);
            System.out.println(target);

        }
    }

    @Nested
    @DisplayName("LinkedList : 각각의 노드를 연결(양방향)하는 방식을 사용함 / 각 노드는 데이터와 함께 next(다음노드)와 prev(이전노드)값을 내부적으로 가지고 있다.")
    public class LinkedList{
        Collection listB = new java.util.LinkedList();
        @Test
        @DisplayName("가용량이 의미가 없기 때문에 가용량을 받는 생성자가 존재하지 않음")
        public void iterator() {
            listB.add("LinkedList 1");
            listB.add("LinkedList 2");
            listB.add("LinkedList 3");


            methodIterator(listB);
        }

        @Test
        @DisplayName("for문을 이용함")
        public void useFor() {
            listB.add("LinkedList for1");
            listB.add("LinkedList for2");
            listB.add("LinkedList for3");
            methodFor(listB);

        }

    }
}