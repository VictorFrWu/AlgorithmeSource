package Calypso;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.Vector;

import DragonJump.MainFrame;

public class StackCopy {
	private int size = 0;
	private Object[] elements;

	public StackCopy(int initialCapacity) {
		this.elements = new Object[initialCapacity];
	}

	public void push(Object object) {
		ensureCapacity(size + 1);
		elements[size++] = object;
	}

	private void ensureCapacity(int minCapacity) {
		// overflow-conscious code
		if (minCapacity - elements.length > 0)
			grow(minCapacity);
	}

	private void grow(int minCapacity) {
		int oldCapacity = elements.length;
		int newCapacity = oldCapacity * 2;
		elements = Arrays.copyOf(elements, newCapacity);
	}

	public Object pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		return elements[--size];
	}

	public static void main(String[] args) {
		StackCopy s = new StackCopy(100000);
		System.out.println(
				"KB: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 10240);
		for (int i = 0; i < 100000; i++) {
			s.push(i);
		}
		System.out.println(
				"KB: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 10240);
		for (int i = 0; i < 100000; i++) {
			s.pop();
		}
		System.out.println(
				"KB: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 10240);
	}
}
