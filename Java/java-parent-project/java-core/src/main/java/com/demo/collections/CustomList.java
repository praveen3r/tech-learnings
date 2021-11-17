package com.demo.collections;

import java.util.Arrays;

public class CustomList<E> {

	private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public CustomList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }


    private void ensureCapa() {
        int newSize = elements.length * 2;
       // elements = Arrays.copyOf(elements, newSize);
        //System.arraycopy(elements, 0, newSize, 0, elements.length);
        Object newData[]=new Object[newSize];
		for(int i=0; i<elements.length;i++){
			newData[i]=elements[i];
		}
		this.elements=newData;
		newData = null;
       
    }
    
    public Object remove(int index) throws Exception{
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
		}
		Object removedElement = elements[index];
		
		System.out.println("Object getting removed:"+removedElement);
		
		/*
		 * int numMoved = size - index - 1; if (numMoved > 0) System.arraycopy(elements,
		 * index+1, elements, index,numMoved); elements[--size] = null;
		 */
	            		
		for(int x=index; x<elements.length-1;x++){
			elements[x]=elements[x+1];
		}
		elements[--size] = null;
		
		return removedElement;
	}
    
    public boolean remove(Object o) {
        if (o == null) {
            for (int index = 0; index < size; index++)
                if (elements[index] == null) {
                    fastRemove(index);
                    return true;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (o.equals(elements[index])) {
                    fastRemove(index);
                    return true;
                }
        }
        return false;
    }
    
    private void fastRemove(int index) {
    	for(int x=index; x<elements.length-1;x++){
			elements[x]=elements[x+1];
		}
		elements[--size] = null;
    }
    
    public Object set(int index, E element) {
        rangeCheck(index);

        Object oldValue = elements[index];
        elements[index] = element;
        return oldValue;
    }
    
    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size );
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index >= size || index <0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size );
        }
        return (E) elements[index];
    }
    
    public void display() {
        System.out.print("Displaying list : ");

        for (int i = 0; i < size; i++) {
               System.out.print(elements[i] + " ");
        }
   }
    
    public int size() {
        return this.size;
   }

	@Override
	public String toString() {
		return "CustomList [elements=" + Arrays.toString(elements) + "]";
	}
    
    
}
