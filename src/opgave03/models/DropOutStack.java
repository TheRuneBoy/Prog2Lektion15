package opgave03.models;

import opgave01.models.StackEaaa;

import java.util.NoSuchElementException;

public class DropOutStack<E> implements StackEaaa<E> {
    private Node<E> top;
    private Node<E> bottom;
    private int size;
    private int maxSize;

    public DropOutStack(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.top = null;
        this.bottom = null;
    }

    @Override
    public void push(E element) {
        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            top = newNode;
            bottom = newNode;
        } else {
            newNode.next = top;
            top.previous = newNode;
            top = newNode;
            if (size >= maxSize) {
                bottom = bottom.previous;
                if (bottom != null) {
                    bottom.next = null;
                }
            } else {
                size++;
            }
        }
    }

    @Override
    public E pop() {
        throwIfEmpty();
        E data = top.element;
        top = top.next;
        if (top != null) {
            top.previous = null;
        } else {
            bottom = null;
        }
        size--;
        return data;
    }

    @Override
    public E peek() {
        throwIfEmpty();
        return top.element;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0){
            return true;
        } else
        return false;
    }

    @Override
    public void clear() {
    top = null;
    bottom = null;
    size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void throwIfEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
    }

    private class Node<T> {
        T element;
        Node<T> next;
        Node<T> previous;

        public Node(T element) {
            this.element = element;
            this.next = null;
            this.previous = null;

        }
    }
}
