package homework2;

import java.util.Arrays;

public class TwoDimensionHouseRaceLampForScrew {
    public static void main(String[] args) {
        for(int times = 0; times < 4; times++){
            int [][]map = {
                    { 1, 2, 3, 4},
                    {12,13,14, 5},
                    {11,16,15, 6},
                    {10, 9, 8, 7}
            };
            int temp = map[2][1];
            for(int index = 1;index<2;index++){
                map[2][index] = map[2][index+1];
            }
            for(int index = 2;index>1;index--){
                map[index][2] = map[index-1][2];
            }
            for(int index = 2;index>0;index--){
                map[1][index] = map[1][index-1];
            }
            for(int index = 1 ; index < 3 ;index++){
                map[index][0] = map[index+1][0];
            }
            for(int index = 0 ; index < 3;index++){
                map[3][index] = map[3][index +1];
            }
            for(int index = 3; index > 0 ;index--){
                map[index][3] = map[index - 1][3];
            }

            for(int index = 3; index > 0;index--){
                map[0][index] = map[0][index - 1];
            }
            map[0][0] = temp;

            for(int index = 0;index < 4; index++){
                System.out.println(Arrays.toString(map[index]));
            }
            System.out.println();
        }
    }
}
