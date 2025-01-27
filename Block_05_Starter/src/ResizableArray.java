import java.util.ArrayList;
import java.util.Arrays;

public class ResizableArray<T> {
    
    private T[] array;
    private int size;

    @SuppressWarnings("unchecked")
    public ResizableArray(int size) {
        this.size = size;
        array = (T[]) new Object[size];  // default capacity
    }

    @SuppressWarnings("unchecked")
    public ResizableArray() {
        size = 0;
        array = (T[]) new Object[10];  // default capacity
    }
    
    public void add(T element){
        if(size == array.length){
            resize();
        }
        size++;
        array[size] = element;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newArray = (T[]) new Object[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public T get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return array[index];
    }

    public void set(int index, T element){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        array[index] = element;
    }

    public T remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        T removedElement = array[index];
        for(int i = index; i < size - 1; i++){
            array[i] = array[i+1];
        }
        array[--size] = null; // Prevent memory leaks
        return removedElement;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void sort(){
        Arrays.sort(array);
    }

}
