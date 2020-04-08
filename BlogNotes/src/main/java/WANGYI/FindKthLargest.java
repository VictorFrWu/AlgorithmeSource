package WANGYI;

import java.util.ArrayList;
import java.util.Collections;

public class FindKthLargest {
//	public int findKth(int[] a, int ns, int K) {
//		ArrayList<Integer> l = new ArrayList();
//		for (int i = 0; i < a.length; i++) {
//			l.add(a[i]);
//		}
//
//		Collections.sort(l);
//		int index = l.size() - 1;
//		while (K > 1) {
//			int temp = l.get(index);
//			index--;
//			while (l.get(index) == temp) {
//				index--;
//			}
//			K--;
//		}
//		return l.get(index);
//	}
	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 2, 2 };
		int n = 5, k = 3;
		System.out.println(findKth(arr, n, k));
	}

	public static int findKth(int[] a, int n, int K) {
		return findKth(a, 0, n - 1, K);
	}

	public static int findKth(int[] a, int low, int high, int k) {
		int part = partation(a, low, high);

		if (k == part - low + 1)
			return a[part];
		else if (k > part - low + 1)
			return findKth(a, part + 1, high, k - part + low - 1);
		else
			return findKth(a, low, part - 1, k);

	}

	public static int partation(int[] a, int low, int high) {
		int key = a[low];

		while (low < high) {
			while (low < high && a[high] <= key)
				high--;
			a[low] = a[high];
			while (low < high && a[low] >= key)
				low++;
			a[high] = a[low];
		}
		a[low] = key;
		return low;
	}
}
