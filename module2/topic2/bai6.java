package topic2;

public class bai6 {

    static int[] concat(int[] arrA, int[] arrB) {
        int []arrC =new int[arrA.length + arrB.length];

        int idx =0;
        for(int value: arrA){
            arrC[idx] = value;
            idx++;
        }
        for(int value: arrB){
            arrC[idx] = value;
            idx++;
        }
        return arrC;
    }

    public static void main(String[] args) {
        int[] arrA = {10, 4, 6};
        int[] arrB = {7, 8, 0, 0};

        int[] arrC = concat(arrA,arrB);

        for (int value : arrC){
            System.out.println(value);
        }
    }
}
