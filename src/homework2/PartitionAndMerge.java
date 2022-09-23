package homework2;

import java.util.Arrays;

public class PartitionAndMerge {


    public static void main(String[] args) {
        char[] array = init(20);
        char[][] partition = partition(array);
        merge(partition[0],partition[1]);
    }

    public static char[][] partition(char[] array){
        char[][] result = new char[2][];
        int numberLength=0,charLength=0;
        for(int length = 0; length < array.length;length++){
            if(array[length] >= '0' && array[length] <= '9'){
                numberLength++;
            }else {
                charLength++;
            }
        }
        char[] numbers = new char[numberLength];
        char[] chars = new char[charLength];
        numberLength = 0;
        charLength=0;
        for(int length = 0; length < array.length;length++){
            if(array[length] >= '0' && array[length] <= '9'){
                numbers[numberLength++] = array[length];
            }else {
                chars[charLength++] = array[length];
            }
        }
        sort(chars,true);
        sort(numbers,false);
        System.out.println("afterPartition：");
        System.out.println("arrays：" + Arrays.toString(chars));
        System.out.println("numbers：" + Arrays.toString(numbers));
        result[0] = chars;
        result[1] = numbers;
        return result;
    }

    public static char[] merge(char[] chars,char[]numbers){
        char[] afterMerge = new char[chars.length+numbers.length];
        int length = 0;
        int charsLength = 0;
        int numbersLength = 0;
        while(length < afterMerge.length){
         afterMerge[length++] = chars[charsLength++];
         afterMerge[length++] = numbers[numbersLength++];
         if(charsLength == chars.length || numbersLength == numbers.length){
             break;
         }
        }
        while(length < afterMerge.length){
            afterMerge[length++] = chars[charsLength++];
        }

        while(length < afterMerge.length){
            afterMerge[length++] = numbers[charsLength++];
        }

        System.out.println("afterMerge：" + Arrays.toString(afterMerge));
        return afterMerge;
    }

    public static void sort(char[]array,boolean isAscent){
        for(int stepFindMax = 0; stepFindMax < array.length - 1; stepFindMax++) {
            for (int compareStep = 0; compareStep < array.length - stepFindMax - 1; compareStep++) {
                if(isAscent) {
                    if (array[compareStep] > array[compareStep + 1]) {
                        char temp = array[compareStep + 1];
                        array[compareStep + 1] = array[compareStep];
                        array[compareStep] = temp;
                    }
                }else {
                    if (array[compareStep] < array[compareStep + 1]) {
                        char temp = array[compareStep + 1];
                        array[compareStep + 1] = array[compareStep];
                        array[compareStep] = temp;
                    }
                }
            }
        }
    }

    public static char[] init(int length){
        char[]array = new char[length];
        for(int index = 0; index < array.length;index++){
            int rand = (int)(Math.random()*(122-48))+48;
            if((rand >= 48 && rand <= 57)||(rand >= 65 && rand <= 90)|| (rand>=97 && rand <= 122)){
                array[index] = (char)rand;//force to integer
            }else {
                index--;//more step
            }
        }
        System.out.println("init："+Arrays.toString(array));
        return array;
    }
}
