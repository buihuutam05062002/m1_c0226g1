package topic2;

public class bai4 {

    static int findElement(int[] arr, int numb) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == numb) {
                index = i;
                break;
            }
        }
        return index;
    }

    static int[] deleteElement(int[] arr, int numb) {
        int index = findElement(arr, numb);

        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = 0;
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {10, 4, 6, 7, 8, 6, 0, 0, 0, 0};

        int[] arr1 = deleteElement(arr, 4);

        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }
    }

}
