package homework2;

import java.util.Arrays;

public class OneHouseRaceLamp {
    public static void main(String[] args) {
        int [] numbers = {1,2,3,4,5,6,7,8,9,10,11};
        int numbersLength = numbers.length;
        while(numbersLength > 0){
            //save the first element
            int  temp = numbers[0];
            //cover before
            for(int index = 0 ; index < numbersLength - 1;index++) {
                numbers[index] = numbers[index + 1];
            }
            numbers[numbersLength - 1] = temp;
            //print
            System.out.println(Arrays.toString(numbers));
            numbersLength--;
        }
    }
}
