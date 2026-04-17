package topic10.list1;

public class MyListTest {
    public static void main(String[] args) {
        Mylist<Integer> temp = new Mylist<>();
        temp.add(10);
        temp.add(20);
        temp.add(30);


        System.out.println("Phần tử tại index 0: " + temp.get(0)); // 10
        temp.add(2, 99);
        System.out.println("" + temp.get(2));
        System.out.println("" + temp.get(3));


        int removed = temp.remove(2);


        // contain
        System.out.println(temp.containers(30));

        // indexof
        System.out.println(temp.indexOf(30));

        Mylist<Integer> cloned = temp.clone();
        System.out.println(cloned.size());
    }
}
