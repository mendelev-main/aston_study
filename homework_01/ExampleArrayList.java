// Реализовать свой ArrayList или LinkedList (методы вставки, удаления, конструкторы по
// умолчанию, с заданием параметров)

package homework_01;
import java.util.Arrays;

class ExampleArrayList<T>{

    private T[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;


    public ExampleArrayList(){
        this(DEFAULT_CAPACITY);
    }

    public ExampleArrayList(int initialCapacity){
        if (initialCapacity < 0){
            throw new IllegalArgumentException("Размер не может быть" + initialCapacity);
        }
        data = (T[]) new Object[initialCapacity];
        size = 0;
    }

    public void add (T element){
      checkingCapacity(size + 1);
      data[size++] = element;
    }
    public void add (int index, T element){
        chekingIndex(index);
        increase(size + 1);

        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
    }

    public T remove(int index){
        chekingIndex(index);

        T removedElement = data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null;
        return removedElement;
    }

    public boolean remove(Object o){
        if (o == null) {
            for (int index = 0; index < size; index++){
                if (data[index] == null) {
                    fastRemove(index);
                    return true;

                }

            }
        } else {
            for (int index = 0; index < size; index++){
                if (o.equals(data[index])) {
                    fastRemove(index);
                    return true;

                }
            }
        }
        return false;
    }

    public void clear(){
        for (int i = 0; i < size; i++){
            data[i] = null;
        }
        size = 0;
    }


    private void fastRemove (int index) {
        System.arraycopy(data, index + 1, data, index, size - index -1);
        data[--size] = null;
    }

    private void chekingIndex(int index){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Индекс " + index + " выходит за рамки массива");
        }
    }



    private  void checkingCapacity (int minCapacity){
        if (minCapacity - data.length > 0){
            increase(minCapacity);
        }
    }


    private void increase (int minCapacity){
        int oldCapacity = data.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0){
            newCapacity = minCapacity;
        }
        if (newCapacity > Integer.MAX_VALUE){
            newCapacity = Integer.MAX_VALUE;
        }
        data = Arrays.copyOf(data, newCapacity);
    }


}
