package delegate;

public interface List<E> {
	public boolean add(E e); 
    public E remove(int index);
    public void clear();
}
