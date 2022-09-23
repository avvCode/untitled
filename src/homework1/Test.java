package homework1;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        //mat(8);
//        HashMap<String,String> hashMap = new HashMap<>();
//        hashMap.put("1","2");
//        hashMap.put("1","3");
//        System.out.println(hashMap.get("2"));
//        System.out.println((int)'0');
//        System.out.println((int)'9');
//        System.out.println((int)'a');
//        System.out.println((int)'z');
//        System.out.println((int)'A');
//        System.out.println((int)'Z');
//        System.out.println((char)72);
//
//     int[] o = {1,2,3,4,5,6};
//        Arrays.asList(o);
        System.out.println(Long.MAX_VALUE);


    }
    static int[][] mat (int n){
        int[][] mat = new int[n][n];
        int cnt = 1;
        int i = 0;
        while(cnt<=n*n){
            for(int j = i; j <= n - 1 - i; j++){
                mat[i][j] = cnt++;
            }

            for(int j = i + 1; j <= n - 1-i; j++){
                mat[j][n-1-i] = cnt++;
            }

            for(int j = n-1-i-1; j >= i; j--){
                mat[n-1-i][j] = cnt++;
            }
            for (int j = n - 2 - i; j > i; j--){
                mat[j][i] = cnt++;
            }
            i++;
        }

       for(int k = 0; k < n; k++){
           System.out.println(Arrays.toString(mat[k]));
       }
        return mat;
    }
}
