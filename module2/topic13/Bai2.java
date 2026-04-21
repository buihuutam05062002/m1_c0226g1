package topic13;

import java.sql.Array;

public class Bai2 {
    public static int findBinary(int left, int right, int x, int arr[]) {
        int mid = (left + right) / 2;

        if(left > right){
            return -1;
        }
        if (arr[mid] == x) {
            return mid;
        } else if (arr[mid] > x) {
            return findBinary(left, mid+1, x,arr);
        }
        else{
            return findBinary(mid+1, right, x,arr);
        }
    }

    public static void main(String[] args) {
        int []numb = {1,2,3,4,5,6,7,8,9};
        System.out.println(findBinary(0,numb.length-1, 2, numb));
    }


}

