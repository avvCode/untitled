package homework2;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,10,9,8,7,6};
        System.out.println("origin:" +Arrays.toString(array));
        int maxPosition = -1;//the maxNumber index
        for(int index = 0; index < array.length - 1 ;index++){
            if(array[index] > array[index+1]){
                maxPosition = index;
                break;
            }
        }
        //front half reverse
        int left = 0,right = maxPosition;
        while(left <= right){
            //swap
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
        //back half reverse
        left = maxPosition+1;right=array.length-1;
        while(left<=right){
            //swap
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
        System.out.println("afterReverse："+Arrays.toString(array));
    }
}
