package homework3;

public class Magic {
    public static void main(String[] args) {
        int[][] construct = construct(5);
        for(int row = 0; row < construct.length; row++){
            for(int col = 0; col < construct[0].length;col++){
                System.out.print(construct[row][col]+" ");
            }
            System.out.println();
        }

    }

    static int[][]construct(int n){
        int[][] magic = new int[n][n];
        int count = 1;
        int row = 0,col = n / 2;
        while(count <= n * n){
            if(magic[row][col] == 0){
                magic[row][col] = count++;
            }
            if(row  == 0 || col  == n - 1){
               if((col  == n - 1 && row == 0) ){
                   row = (row + 1) % n;
                   col = col;

               }else {
                   row =  ((row - 1) + n )% n;

                   col = (col + 1) % n;
               }
            }else if(row < n && col < n &&magic[row-1][col+1] != 0){
                row = (row + 1) % n;
                col = col;
            } else {
                row-=1;
                col+=1;
            }

        }
        return magic;
    }
}
