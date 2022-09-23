package homework1;

public class HundredDollarHundredChickens{
    public static void main(String[] args) {
        long start = System.nanoTime();
        int allNumber = 10000;//totalNumber
        int totalCount = 0;
//        for(int cockNumber = 0; cockNumber <= allNumber; cockNumber++){
//            for(int henNumber = 0; henNumber <= allNumber; henNumber++){
//                for(int chickNumber = 0; chickNumber <= allNumber; chickNumber++){
//                    if(chickNumber % 3 == 0 && cockNumber + henNumber + chickNumber == allNumber
//                            && cockNumber * 5 + henNumber * 3 + chickNumber / 3 == allNumber){
//                        totalCount++;
//                    }
//                }
//            }
//        }
        for(int cockNumber = 0; cockNumber <= allNumber; cockNumber++){
            for(int henNumber = 0; henNumber <= allNumber - cockNumber; henNumber++){
                int chickNumber = allNumber - cockNumber - henNumber;
                if( chickNumber % 3 == 0 && cockNumber * 5 + henNumber * 3 + chickNumber / 3 == allNumber ){
                    totalCount++;
                }

            }
        }
        long end = System.nanoTime();
        System.out.println("totalCount：" + totalCount);
        System.out.println("totalTime：" + (end -start));
    }
}