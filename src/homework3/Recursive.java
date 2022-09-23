package homework3;

public class Recursive {
    public static void main(String[] args) {
        int array[] = {1,2,3,4,5,6,7,8,9,10};
        forewordTraversal(array,0);
       // backTraversal(array,0);
    }
    public static void forewordTraversal(int[] array,int index){
        if(index == array.length - 1){
            System.out.print(array[index] + " ");
            return;
        }
        System.out.print(array[index]+" ");
        forewordTraversal(array,index+1);
    }
    public static void backTraversal(int[] array,int index){
        if(index == array.length - 1){
            System.out.print(array[index] + " ");
            return;
        }
        backTraversal(array,index+1);
       System.out.print(array[index]+" ");
    }
}
