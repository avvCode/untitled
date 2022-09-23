package homework2;

public class OddAndEvenPartitionAndMerge {
    public static void main(String[] args) {
//        int[] oddsAndEvens = init();
//        System.out.println("init：" + Arrays.toString(oddsAndEvens));
//        System.out.println();
//        int[][] partition = partition(oddsAndEvens);
//        System.out.println("odds：" + Arrays.toString(partition[0]));
//        System.out.println();
//        System.out.println("evens：" + Arrays.toString(partition[1]));
//        System.out.println();
//        int[] afterMerge = merge(partition[0], partition[1]);
//        System.out.println("afterMerge：" + Arrays.toString(afterMerge));

        Long start = System.nanoTime();
        int[] array = new int[100];
        for(int index = 0; index < 100; index++){
            array[index] = (int)(Math.random()*10001);//0 - 10000 random number
        }
       // System.out.println("init：" + Arrays.toString(array));

        int oddNumbersLength = 0;
        int evenNumbersLength = 0;
        for (int index = 0; index < array.length ;index++){
            if(array[index] % 2 == 0){// is odd or even
                evenNumbersLength++;
            }else {
                oddNumbersLength++;
            }
        }
        int[] oddNumbers = new int[oddNumbersLength];
        int[] evenNumbers = new int[evenNumbersLength];
        oddNumbersLength = 0;
        evenNumbersLength = 0;
        for (int index = 0; index < array.length ;index++){
            if(array[index] % 2 == 0){
                evenNumbers[evenNumbersLength++] = array[index];
            }else {
                oddNumbers[oddNumbersLength++] = array[index];
            }
        }

        // bubble sort
        for(int stepFindMax = 0; stepFindMax < oddNumbers.length - 1; stepFindMax++) {//find max
            for (int compareStep = 0; compareStep < oddNumbers.length - stepFindMax - 1; compareStep++) {//compare step
                if (oddNumbers[compareStep] > oddNumbers[compareStep + 1]) {
                    int temp = oddNumbers[compareStep];
                    oddNumbers[compareStep] = oddNumbers[compareStep+1];
                    oddNumbers[compareStep+1]=temp;
                }
            }
        }

        for(int stepFindMax = 0; stepFindMax < evenNumbers.length - 1; stepFindMax++) {
            for (int compareStep = 0; compareStep < evenNumbers.length - stepFindMax - 1; compareStep++) {
                if (evenNumbers[compareStep] > evenNumbers[compareStep + 1]) {
                    int temp = evenNumbers[compareStep];
                    evenNumbers[compareStep] = evenNumbers[compareStep+1];
                    evenNumbers[compareStep+1]=temp;
                }
            }
        }
       // System.out.println("oods：" + Arrays.toString(oddNumbers));
       // System.out.println("even：" + Arrays.toString(evenNumbers));

        int[] afterMerge = new int[oddNumbers.length+evenNumbers.length];
        //tow point way to merge
        int oddsIndex = 0;
        int evenIndex = 0;
        int index = 0;
        while (index < afterMerge.length){
            if(oddNumbers[oddsIndex] > evenNumbers[evenIndex]){ // find max and index increase
                afterMerge[index++] = evenNumbers[evenIndex++];
            }else {
                afterMerge[index++] = oddNumbers[oddsIndex++];
            }
            if(evenIndex == evenNumbers.length || oddsIndex == oddNumbers.length){// has an arraysLength end
                break;
            }
        }
        while(evenIndex < evenNumbers.length){
            afterMerge[index++] = evenNumbers[evenIndex++];
        }
        while (oddsIndex < oddNumbers.length){
            afterMerge[index++] = oddNumbers[oddsIndex++];
        }
        //System.out.println("merge：" + Arrays.toString(afterMerge));
        Long end = System.nanoTime();
        System.out.println("totalTime：" + (end-start));//count time


    }
    public static int[] init(){
        int[] array = new int[100];
        for(int index = 0; index < 100; index++){
            array[index] = (int)(Math.random()*10001);//0 - 10000 random number
        }
        return array;
    }
    public static int[][] partition(int[] array){
        int[][] result = new int[2][];
        int oddNumbersLength = 0;
        int evenNumbersLength = 0;
        for (int index = 0; index < array.length ;index++){
            if(array[index] % 2 == 0){
                evenNumbersLength++;
            }else {
                oddNumbersLength++;
            }
        }
        int[] oddNumbers = new int[oddNumbersLength];
        int[] evenNumbers = new int[evenNumbersLength];
        oddNumbersLength = 0;
        evenNumbersLength = 0;
        for (int index = 0; index < array.length ;index++){
            if(array[index] % 2 == 0){
                evenNumbers[evenNumbersLength++] = array[index];
            }else {
                oddNumbers[oddNumbersLength++] = array[index];
            }
        }
        oddNumbers = bubbleSort(oddNumbers);
        evenNumbers = bubbleSort(evenNumbers);
        result[0] = oddNumbers;
        result[1] = evenNumbers;
        return result;
    }
    public static int[]merge(int[] odds ,int[] even){
        int[] afterMerge = new int[odds.length+even.length];
        //tow point way to merge
        int oddsIndex = 0;
        int evenIndex = 0;
        int index = 0;
        while (index < afterMerge.length){
            if(odds[oddsIndex] > even[evenIndex]){
                afterMerge[index++] = even[evenIndex++];
            }else {
                afterMerge[index++] = odds[oddsIndex++];
            }
            if(evenIndex == even.length || oddsIndex == odds.length){
                break;
            }
        }
        while(evenIndex < even.length){
            afterMerge[index++] = even[evenIndex++];
        }
        while (oddsIndex < odds.length){
            afterMerge[index++] = odds[oddsIndex++];
        }
        return afterMerge;
    }
    public static int[] bubbleSort(int[] array){
        for(int stepFindMax = 0; stepFindMax < array.length - 1; stepFindMax++) {
            for (int compareStep = 0; compareStep < array.length - stepFindMax - 1; compareStep++) {
                    if (array[compareStep] > array[compareStep + 1]) {
                        int temp = array[compareStep];
                        array[compareStep] = array[compareStep+1];
                        array[compareStep+1]=temp;
                    }
            }
        }
        return array;
    }
}
