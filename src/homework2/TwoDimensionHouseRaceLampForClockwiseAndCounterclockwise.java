package homework2;

import java.util.Arrays;

public class TwoDimensionHouseRaceLampForClockwiseAndCounterclockwise {
    public static void main(String[] args) {
        int[][] map2 = {
                { 1,  2,  3,  4,  5,  6,  7,  8},
                {28, 29, 30, 31, 32, 33, 34,  9},
                {27, 48, 49, 50, 51, 52, 35, 10},
                {26, 47, 60, 61, 62, 53, 36, 11},
                {25, 46, 59, 64, 63, 54, 37, 12},
                {24, 45, 58, 57, 56, 55, 38, 13},
                {23, 44, 43, 42, 41, 40, 39, 14},
                {22, 21, 20, 19, 18, 17, 16, 15}
        };
        for (int times = 0; times < 4; times++) {
            int speed = 0;
            for(int loop = 1; loop <=4 ; loop++){
                //control the speed  the same time return the beginning
                if(loop == 1){
                    speed = 7;
                }

                if(loop == 2){
                    speed = 5;
                }

                if(loop == 3){
                    speed = 3;
                }
                if(loop == 4){
                    speed = 1;
                }
                while (speed-->0){
                    if(loop % 2 !=0) {
                        //row no change
                        int index;
                        int temp = map2[loop - 1][8 - loop];
                        for (index = 8 - loop; index >= loop; index--) {
                            map2[loop - 1][index] = map2[loop - 1][index - 1];
                        }
                        //col no change
                        int temp2 = map2[8-loop][8-loop];
                        for (index = 8 - loop;index > loop;index--){
                            map2[index][8-loop] = map2[index - 1][8-loop];
                        }
                        map2[index][8-loop] = temp;
                        //row no change
                        int temp3 = map2[8-loop][loop-1];
                        for(index = loop-1;index < 8 - loop - 1;index++){
                            map2[8-loop][index] = map2[8-loop][index+1];
                        }
                        map2[8-loop][index] = temp2;
                        //col no change
                        for(index = loop - 1;index < 8-loop-1;index++){
                            map2[index][loop-1] = map2[index+1][loop-1];
                        }
                        map2[index][loop - 1] = temp3;
                    }else {

                        int index;
                        int temp = map2[loop-1][loop-1];
                        //row no change
                        for(index = loop -1; index < 8 - loop ; index++){
                            map2[loop-1][index] = map2[loop-1][index+1];
                        }
                        //col no change
                        for(index = loop-1;index < 8-loop; index++){
                            map2[index][8 - loop] = map2[index+1][8 - loop];
                        }
                        //row no change
                        for(index = 8 - loop; index > loop - 1;index--){
                            map2[8-loop][index] = map2[8-loop][index-1];
                        }
                        //col no change
                        for(index = 8-loop;index >  loop - 1 ;index--){
                            map2[index][loop-1] = map2[index-1][loop-1];
                        }
                        map2[loop][index] = temp;
                    }
                }

            }
            for(int index = 0;index < 8; index++){
                System.out.println(Arrays.toString(map2[index]));
            }
            System.out.println();
        }

    }
}
