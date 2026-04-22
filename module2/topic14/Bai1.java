package topic14;

public class Bai1 {

    public static void insertSort(int arr[]){
        for(int i = 1; i < arr.length ; ++i){
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key){
                    arr[j+1] = arr[j];
                    j = j - 1;
            }
            arr[j + 1] = key;

            String str = "";
            for (int k = 0; k < arr.length; k++) {
                str += arr[k] + ", ";
            }
            System.out.println("lần "+ i + ": "+  str);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 23, 78, 5, 91, 44, 12, 67, 30, 88, 16};

        insertSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
