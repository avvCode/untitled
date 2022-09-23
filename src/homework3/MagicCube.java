package homework3;

public class MagicCube {
    public static void main(String[] args) {
        int[][][] magicCube = new int[7][7][7];

        for(int index1 = 0; index1 < 7; index1++){
            for(int index2 = 0; index2 < 7; index2++){
                for(int index3 = 0; index3 <7;index3++){
                    magicCube[index1][index2][index3] = 1;
                    if(index1 == 0 || index2 == 0 || index3 == 0 ||index1 == 6 ||index2 == 6||index3==6){
                        magicCube[index1][index2][index3] = 0;
                    }
                }
            }
        }
        int area = 0;
        for(int index1 = 1; index1 < 6; index1++){
            for(int index2 = 1; index2 < 6; index2++){
                for(int index3 = 1; index3 <6;index3++){
                    if(magicCube[index1][index2][index3]==1){
                        if(magicCube[index1-1][index2][index3] == 0){
                            area++;
                        }
                        if( magicCube[index1+1][index2][index3] == 0){
                            area++;
                        }
                        if( magicCube[index1][index2-1][index3] == 0){
                            area++;
                        }
                        if(magicCube[index1][index2+1][index3] == 0){
                            area++;
                        }
                        if( magicCube[index1][index2][index3-1] == 0){
                            area++;
                        }
                        if( magicCube[index1][index2][index3+1] == 0){
                            area++;
                        }
                    }

                }
            }
        }
        System.out.println("origin area ：" + area);

        for(int index = 1; index <= 5; index++){
            magicCube[3][2][index] = 0;
            magicCube[2][3][index] = 0;
            magicCube[3][4][index] = 0;
            magicCube[3][3][index] = 0;
            magicCube[4][3][index] = 0;
            magicCube[index][3][2] = 0;
            magicCube[index][2][3] = 0;
            magicCube[index][3][4] = 0;
            magicCube[index][3][3] = 0;
            magicCube[index][4][3] = 0;
            magicCube[3][index][2] = 0;
            magicCube[2][index][3] = 0;
            magicCube[3][index][4] = 0;
            magicCube[3][index][3] = 0;
            magicCube[4][index][3] = 0;
        }
        for(int index1 = 0; index1 < 7; index1++){
            for(int index2 = 0; index2 < 7; index2++){
                for(int index3 = 0; index3 <7;index3++){
                    System.out.print(magicCube[index1][index2][index3]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
        area = 0;
        for(int index1 = 1; index1 < 6; index1++){
            for(int index2 = 1; index2 < 6; index2++){
                for(int index3 = 1; index3 <6;index3++){
                    if(magicCube[index1][index2][index3]==1){
                        if(magicCube[index1-1][index2][index3] == 0){
                            area++;
                        }
                        if( magicCube[index1+1][index2][index3] == 0){
                            area++;
                        }
                        if( magicCube[index1][index2-1][index3] == 0){
                            area++;
                        }
                        if(magicCube[index1][index2+1][index3] == 0){
                            area++;
                        }
                        if( magicCube[index1][index2][index3-1] == 0){
                            area++;
                        }
                        if( magicCube[index1][index2][index3+1] == 0){
                                area++;
                        }
                    }

                }
            }
        }
        System.out.println("the final area：" + area);
    }
}
