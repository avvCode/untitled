package homework1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) throws IOException {
        int[] numbers = readNumbers();
        long start = System.nanoTime();
        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = 0; j < numbers.length - i - 1; j++){
                if(numbers[j] > numbers[j+1]){
                    //swap
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(numbers));

        long end = System.nanoTime();
        System.out.println("totalTime：" +(end - start));
    }
    static int[]readNumbers() throws IOException {
        int [] numbers;
        FileInputStream fileInputStream = new FileInputStream(new File("src/datafile.txt"));
        byte[] buff = new byte[214800000];
        int readLen=-1;
        String readNumbers = null;
        while((readLen = fileInputStream.read(buff))!= -1){
            readNumbers = new String(buff,0,readLen);
        }

        String[] split = readNumbers.split(",");
        numbers = new int[split.length];
        for(int  i = 0; i < split.length; i++){
            numbers[i] = Integer.parseInt(split[i]);
        }
        return numbers;
    }
}
