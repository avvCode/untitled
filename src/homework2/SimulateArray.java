package homework2;

import java.util.NoSuchElementException;

public class SimulateArray {
    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        array.add(1);
        array.add(2);
        array.add(6);
        array.add(4);
        array.add(5);
        array.add(3);
        array.add(3);
        array.add(3);
        array.add(3);
        array.add(3);
        array.add(3);
        System.out.println("search 3："+array.search(3));
        //System.out.println(array.size());
        //System.out.println(array.toString());
        //System.out.println("afterInsert:");
     //   array.insert(6,9);
       // System.out.println(array.size());
//        array.insert(3,5);
//        System.out.println("insert 5 to position 3:");
        System.out.println(array.toString());

    }
}
class Array<Type>{
    //the true length
    private int length;

    private Type [] array;
    //init
    public Array(){
        //init length 10
        this.array = (Type[]) new Object[10];
        this.length = 10;
    }
    public Array(Type [] array){
        this.array = array;
    }
    //position
    public Type location(int index){
        return array[index];
    }
    //search
    public int search(Type element){
        for(int index = 0; index < size(); index++) {
            if (element.equals(array[index])) {
                return index;
            }
        }
        return -1;
    }
    //insert
    public void insert(int position,Type element){
        if(this.length == this.size()){
            expand();
        }
        for(int index = size(); index < array.length; index--) {
            if (index == position) {
                array[index] = element;
                break;
            }
            array[index] = array[index - 1];
        }
    }

    //append
    public void add(Type element){
        if(size() == this.length){
            expand();
        }
        this.array[size()] = element;
    }
    //delete
    public void deleteByPosition(int position){
        for(int index = position;index < size() ;index++){
            array[index] = array[index+1];
        }
        array[size()] = null;
    }
    public void delete(Type element){
        int position = search(element);
        if(position == -1){
            throw new NoSuchElementException("not exits this element");
        }else {
            deleteByPosition(position);
        }

    }
    //expand 2
    public void expand(){
        Type[] array = (Type[]) new Object[ 2 * this.length];
        for(int index = 0; index < this.array.length;index++){
            array[index] = this.array[index];
        }
        this.array = array;
        this.length *= 2;
    }
    //size
    public int size(){
        int size = 0;
        for (Type type : this.array) {
            if(type != null){
                size++;
            }
        }
        return size;
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();
        print.append("[").append(array[0]);
        for(int index = 1; index < this.size()-1;index++){
           print.append(", "+array[index]);
        }
        print.append("]");
        return print.toString();
    }
}