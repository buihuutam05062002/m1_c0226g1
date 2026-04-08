package topic2;

public class bai5 {
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

    // mang da day
    static int[] addElement(int[] arr, int index, int value) {
        for (int i = arr.length - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = value;
        return arr;
    }

    // mang chua day // cach 2
    static int[] addElement2(int[] arr, int index, int value) {
        int[] result = new int[arr.length + 1];

        for (int i = 0; i < index; i++) {
            result[i] = arr[i];
        }
        for (int i = index; i < arr.length; i++) {
            result[i + 1] = arr[i];
        }
        result[index] = value;

        return result;

    }


    public static void main(String[] args) {
        int[] arr = {10, 4, 6, 7, 8, 0, 0, 0, 0, 0};

        int[] arr1 = addElement2(arr, 3, 4);

        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }
    }
}
