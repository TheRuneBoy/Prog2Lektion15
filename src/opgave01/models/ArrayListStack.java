package opgave01.models;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ArrayListStack<E> implements StackEaaa {
    private ArrayList<E> arrayListStack = new ArrayList<>();

    @Override
    public void push(Object element) {
    arrayListStack.add((E) element);
    }

    @Override
    public Object pop() {
        throwIfEmpty();
        return arrayListStack.removeLast();
    }

    @Override
    public Object peek() {
        throwIfEmpty();
        return arrayListStack.getLast();
    }

    @Override
    public boolean isEmpty() {
        if (arrayListStack.isEmpty()){
            return true;
        } else
        return false;
    }

    @Override
    public void clear() {
    arrayListStack.clear();
    }

    @Override
    public int size() {
        return arrayListStack.size();
    }

    private void throwIfEmpty(){
        if (arrayListStack.isEmpty()){
            throw new  NoSuchElementException("Stack is empty");
        }
    }
}
