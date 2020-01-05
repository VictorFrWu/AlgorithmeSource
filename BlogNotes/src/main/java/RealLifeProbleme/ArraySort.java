package RealLifeProbleme;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * Hello world!
 *
 */
public class ArraySort {
	class DateObject {
		int id;
		Date date;

		public DateObject(int id, Date date) {
			super();
			this.id = id;
			this.date = date;
		}

	}

	public List<String> arraySort(List<String> list) throws ParseException {
		List<DateObject> l = new ArrayList<DateObject>();
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
		for (int i = 0; i < list.size(); i++) {
			l.add(new DateObject(i, formatter1.parse(list.get(i))));
		}
		PriorityQueue<DateObject> pq = new PriorityQueue<DateObject>((o1, o2) -> o2.date.compareTo(o1.date));
		for (DateObject o : l) {
			pq.add(o);
		}
		List<String> ll = new ArrayList<String>();
		for (DateObject o : pq) {
			ll.add(list.get(o.id));
		}
		return ll;

	}

	@Test
	public void test() throws ParseException {
		List<String> list = Arrays.asList("3/11/2010", "3/11/2011", "4/11/2010", "4/11/2011");
		arraySort(list);
	}
}
