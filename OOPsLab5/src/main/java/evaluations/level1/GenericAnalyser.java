package evaluations.level1;

public class GenericAnalyser  <T>{
     private T[] tArray;
     int currentPointer;
     public GenericAnalyser(int size) {
         this.tArray = (T[]) new Object[size];
     }

     public boolean addValue(T t) {
         if(currentPointer==tArray.length) return false;
         tArray[currentPointer++] = t;
         return true;
     }

     public T getValue(int index) {
         if(index>=tArray.length) {
             throw new IndexOutOfBoundsException("Index out of bound");
         }
         return tArray[index];
     }

     public void printData() {
         for(int i=0; i<currentPointer; i++) {
             System.out.println(tArray[i]);
         }
     }

     public void reverseData() {
         int start = 0;
         int end = currentPointer - 1;
         while(start<end) {
             T temp = tArray[start];
             tArray[start] = tArray[end];
             tArray[end] = temp;
             start ++ ;
             end --;
         }
     }
}
