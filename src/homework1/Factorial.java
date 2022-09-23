package homework1;

public class Factorial {
   static int factorial(int number){
        if(number == 1){//recursive condition
            return 1;
        }
        return number * factorial(number - 1);//n * n - 1 * n - 2 ... *1
    }

    public static void main(String[] args) {
//        System.out.println(factorial(5));
        String s = "sadasd";
       s.toCharArray();
    }
}
