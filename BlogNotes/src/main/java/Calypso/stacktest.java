package Calypso;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;

class StackT {

    // keep these two fields as they​​​​​​‌​​​‌​‌‌​‌‌‌​​‌‌​‌​‌‌‌‌‌​ are
    private Object[] elements;
	private int size = 0;

	public StackT(int initialCapacity) {
		elements = new Object[initialCapacity];
	}

	public void push(Object object) {
		ensureCapacity();
		elements[size++] = object;
	}

	public Object pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}

		return elements[--size];
	}

	private void ensureCapacity() {
		if (elements.length == size) {
			Object[] old = elements;
			elements = new Object[2 * size + 1];
			System.arraycopy(old, 0, elements, 0, size);
		}
	}
}


public class stacktest {
	static Map<Integer, NewObject> map = new HashMap<Integer, NewObject>();

    public static void main(String[] args){
    	StackT stack = new StackT(50000);
    	 System.out.println("KB: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 10240);
    	for (int i = 0; i < 100000; i++) {
			stack.push(i);
		}
    	 System.out.println("KB: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 10240);
        //fillMemory(25);
        for (int i = 0; i < 100000; i++) {
			stack.pop();
		}
        System.out.println("KB: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 10240);
    }

    static int j=0;
    public static void fillMemory(int i){

        for(int k=0; k< 2000; k++)
            map.put(j++, new NewObject());

    }


    public static class NewObject{
        long i = 0L;
        long j = 0L;
        long k = 0L;
    }
}