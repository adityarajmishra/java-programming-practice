package evaluations.level1;

public class GenericContainer <T>{
    private T[] tArray;
    private int currentPointer;

    public GenericContainer(int size) {
        this.tArray = (T[]) new Object[size];
        currentPointer = 0;
    }

    public T getValue(int sequence) {
        if(sequence >= tArray.length) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        return tArray[sequence];
    }

    public boolean addValue(T value) {
        if(currentPointer==tArray.length) return false;
        tArray[currentPointer++] = value;
        return true;
    }

    public void printContainer() {
        for(int i=0; i<currentPointer; i++) {
            System.out.println(tArray[i]);
        }
    }
}
