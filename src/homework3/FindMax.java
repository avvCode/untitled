package homework3;

public class FindMax {
    public static void main(String[] args) {
        int arr[]={1,2,321231,4,5,622,7,8,9,10};
        System.out.println(findMax(arr,0));
    }
    static int findMax(int[]array,int index){
        if(index == array.length - 1){
            return -1;
        }
        int max = findMax(array,index+1);
        System.out.println(max + " compare with " + array[index]+" index = " + index);
        return Math.max(max, array[index]);
    }
}
