package homework2;

import java.util.Arrays;

public class Shuffle {
    public static void main(String[] args) {
        int[] cards = init();

        //int[] afterGodShuffle = godShuffle(cards);
        //int[] afterCroupierShuffle = croupier(cards);
        //int[] afterMortalShuffle = mortal(cards);
    }
    public static int []init(){
        int[] cards = new int[52];
        for(int index = 1; index <= 52;index++){
            cards[index - 1] = index;
        }
        System.out.println("init Cards：" + Arrays.toString(cards));
        return cards;
    }
    public static int []godShuffle(int[] cards){
        //repeat three times
        for(int loop = 0; loop < 3; loop++){
            int []afterShuffle = new int[52];
            int leftHalf = 0;
            int rightHalf = 26;
            //step1
            for(int length = 0; length < afterShuffle.length;length++){
                if(length % 2 == 0){
                    afterShuffle[length] = cards[leftHalf++];
                }else {
                    afterShuffle[length] = cards[rightHalf++];
                }
            }
            System.out.println("step1：" + Arrays.toString(afterShuffle));
            check(afterShuffle);
            cards = step2(cards);
        }
        return cards;
    }

    public static int[]mortal(int[]cards){

        int[] afterMortalShuffle = new int[52];
        for (int loop = 0; loop < 3;loop++){
            int cardsLength =0,leftLength=0,rightLength=0;
            while(cardsLength < 52){
                int takeOutFromLeft = (int)(Math.random()*4);
                int takeOutFromRight = (int)(Math.random()*4);

                while(leftLength < 26 && takeOutFromLeft > 0){
                    int randPokerIndex = (int)(Math.random()*26);
                    if(cards[randPokerIndex] != 0){
                        afterMortalShuffle[cardsLength++] = cards[randPokerIndex];
                        cards[randPokerIndex] = 0;//every poker just can be take out once
                        takeOutFromLeft--;
                        leftLength++;
                    }
                }
                while (rightLength < 26 && takeOutFromRight > 0){
                    int randPokerIndex = (int)((Math.random()*26)+26);
                    if(cards[randPokerIndex] != 0){
                        afterMortalShuffle[cardsLength++] = cards[randPokerIndex];
                        cards[randPokerIndex] = 0;//every poker just can be take out once
                        takeOutFromRight--;
                        rightLength++;
                    }

                }
            }
            System.out.println("step1: ");
            System.out.println(Arrays.toString(afterMortalShuffle));
            afterMortalShuffle = step2(afterMortalShuffle);
            cards = afterMortalShuffle.clone();
        }
        return afterMortalShuffle;
    }

    public static int[]croupier(int[] cards){
       for(int loop = 0; loop <3;loop++){
           int diff = (int)(Math.random()*3)+1;
           int diffLeftOrRight = (int)(Math.random()*2);// left：1 right：0
           int leftStart = 0,leftEnd = 26,rightStart = 26,rightEnd = 52;
           int []afterCroupierShuffle = new int[52];
           if(diffLeftOrRight == 1){
               rightStart -=diff;//diff on left
               leftEnd -=diff;

           }else {
               leftEnd +=diff;//diff on right
               rightStart+=diff;

           }
           int length;
           for (length = 0; length < afterCroupierShuffle.length;length++){
               if(length % 2 == 0 && leftStart <  leftEnd){
                   afterCroupierShuffle[length] = cards[leftStart++];
               }
               if (length % 2 == 1 && rightStart < rightEnd){
                   afterCroupierShuffle[length] = cards[rightStart++];
               }
               if(leftStart == leftEnd || rightStart == rightEnd){
                   break;
               }
           }
            length++;
           if(diffLeftOrRight == 1){
               while (rightStart < rightEnd){
                   afterCroupierShuffle[length++] = cards[rightStart++];
               }
           }else {
               while (leftStart < leftEnd){
                   afterCroupierShuffle[length++] = cards[leftStart++];
               }
           }
           System.out.println("step1：" + Arrays.toString(afterCroupierShuffle));
           check(afterCroupierShuffle);
           cards = step2(cards);
       }
        return cards;
    }
    public static int[] step2(int[] cards){
        //step2:
        int[] afterShuffle = new int[52];
        int diffLeft = (int) (Math.random()*3+1);// add poker to left
        int diffRight = (int) (Math.random()*3+1);// add poker to right

        int leftLessOrMore = (int) (Math.random()*2);//less 1 more 0
        int rightLessOrMore = (int) (Math.random()*2);//less 1 more 0

        int putLeftOrRight = (int) (Math.random()*2);//right 1 left 0



        int leftStart = 0,leftEnd = 13,middleStart = 13,middleEnd = 39,rightStart=39,rightEnd=52;
        // diff in left
        if(leftLessOrMore == 1){//less some poker
            leftEnd -= diffLeft;
            middleStart-=diffLeft;
        }else {//more some poker
            leftEnd+=diffLeft;
            middleStart+=diffLeft;
        }
        //diff in right
        if(rightLessOrMore == 1){//less some poker
            middleEnd += diffRight;
            rightStart+=diffRight;
        }else {//more some poker
            middleEnd-=diffRight;
            rightStart-=diffRight;
        }


        for(int length = 0; length < afterShuffle.length;length++){
            if(putLeftOrRight == 1) {//put the middle to right
                //left
                if(leftStart < leftEnd){
                    afterShuffle[length] = cards[leftStart++];
                    continue;
                }
                //right
                if(rightStart < rightEnd){
                    afterShuffle[length] = cards[rightStart++];
                    continue;
                }
                //middle
                if(middleStart < middleEnd) {
                    afterShuffle[length] = cards[middleStart++];
                    continue;
                }
            }else {//put the middle to left
                if(rightStart < rightEnd ) {
                    afterShuffle[length] = cards[rightStart++];
                    continue;
                }
                if(leftStart < leftEnd){
                    afterShuffle[length] = cards[leftStart++];
                    continue;
                }
                if(middleStart < middleEnd){
                    afterShuffle[length] = cards[middleStart++];
                    continue;
                }
            }
        }
        System.out.println("step2：" + Arrays.toString(afterShuffle));
        check(afterShuffle);
        return afterShuffle;
    }
    public static void check(int [] cards){
        int[] hash = new int[52];
        for(int length = 0; length < 52;length++){
            hash[cards[length]-1]++;
        }
        System.out.println("check：" + Arrays.toString(hash));
    }
}
