package WANGYI;

import java.util.ArrayList;

/**
 * @author mac
 *         小明陪小红去看钻石，他们从一堆钻石中随机抽取两颗并比较她们的重量。这些钻石的重量各不相同。在他们们比较了一段时间后，它们看中了两颗钻石g1和g2。现在请你根据之前比较的信息判断这两颗钻石的哪颗更重。
 * 
 *         给定两颗钻石的编号g1,g2，编号从1开始，同时给定关系数组vector,其中元素为一些二元组，第一个元素为一次比较中较重的钻石的编号，第二个元素为较轻的钻石的编号。最后给定之前的比较次数n。请返回这两颗钻石的关系，若g1更重返回1，g2更重返回-1，无法判断返回0。输入数据保证合法，不会有矛盾情况出现。
 * 
 *         测试样例： 2,3,[[1,2],[2,4],[1,3],[4,3]],4 返回: 1
 */
public class CompareWeight {
//	private  boolean reachable = false;
//	 
//    public int cmp(int g1, int g2, int[][] records, int n) {
//        // 生成一个有向图
//        HashMap<Integer, List<Integer>> map = generateMap(records, n);
//        if (map.isEmpty()) {
//            return 0;
//        }
//        depthSearch(g1, g2, map);
//        if (reachable) {
//            return 1;
//        }
//        depthSearch(g2, g1, map);
//        if (reachable) {
//            return -1;
//        }
//        return 0;
//    }
// 
//    private void depthSearch(int g1, int g2, HashMap<Integer, List<Integer>> map) {
//        if (!map.containsKey(g1)) {
//            reachable = false;
//        } else {
//            List<Integer> values = map.get(g1);
//            for (int value : values) {
//                if (g2 == value) {
//                    reachable = true;
//                    return;
//                } else {
//                    depthSearch(value, g2, map);
//                }
//            }
// 
//        }
//    }
// 
//    public HashMap<Integer, List<Integer>> generateMap(int[][] records, int n) {
//        HashMap<Integer, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            int key = records[i][0];
//            int value = records[i][1];
//            if (map.containsKey(key)) {
//                map.get(key).add(value);
//            } else {
//                List<Integer> list = new ArrayList<>();
//                list.add(value);
//                map.put(key, list);
//            }
//        }
//        return map;
//    }

	// fluid graph with direction
	public int cmp(int g1, int g2, int[][] records, int n) {
		ArrayList<Integer> bigger = new ArrayList<Integer>();// 存储比g1大的元素
		ArrayList<Integer> smaller = new ArrayList<Integer>();// 存储比g1小的元素 boolean flag=true;
		for (int i = 0; i < n; i++) {
			if (records[i][0] == g1) {
				smaller.add(records[i][1]);// 比g1小的集合
			} else if (records[i][1] == g1) {
				bigger.add(records[i][0]);// 比g1大的集合
			}
		}
		boolean flag = true;
		while (flag) {
			flag = false;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < smaller.size(); j++) {
					if (smaller.get(j) == records[i][0]) {
						smaller.add(records[i][1]);// 更新比g1小的集合
						records[i][0] = -1;// 比较过后则废弃
						flag = true;
					}
				}
			}
		}
		flag = true;
		while (flag) {
			flag = false;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < bigger.size(); j++) {
					if (bigger.get(j) == records[i][1]) {
						bigger.add(records[i][0]);// 更新比g1大的集合
						records[i][1] = -1;// 比较过后则废弃
						flag = true;
					}
				}
			}
		}
		for (int i = 0; i < smaller.size(); i++) {
			if (smaller.get(i) == g2) {
				return 1;// 如果g2在比g1小的集合中，则返回1
			}
		}
		for (int i = 0; i < bigger.size(); i++) {
			if (bigger.get(i) == g2) {
				return -1;// 如果g2在比g1大的集合中，则返回-1
			}
		}
		return 0;// 否则返回0
	}
}
