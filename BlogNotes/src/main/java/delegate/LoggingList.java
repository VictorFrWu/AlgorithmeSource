package delegate;

public class LoggingList<E> implements List<E>{
	 private final List<E> list1;
	    public LoggingList(List<E> list) { 
	        this.list1 = list; 
	    } 
	    public boolean add(E e) { 
	        System.out.println("Adding " + e); 
	        return list1.add(e); 
	    } 
	    public E remove(int index) { 
	        System.out.println("Removing at " + index); 
	        return list1.remove(index); 
	    }
		@Override
		public void clear() {
			list1.clear();
		}
		
}
