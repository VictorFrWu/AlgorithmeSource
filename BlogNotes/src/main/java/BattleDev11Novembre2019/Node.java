package BattleDev11Novembre2019;

public class Node {
	Node left, right;
	int value;

	Node(int value) {
		this.value = value;
	}

	public Node find(int val) {
		if (val > this.value) {
			if(this.right == null) 
				return null;
			return this.right.find(val);
		} else if (val < this.value) {
			if(this.left == null)
				return null;
			return this.left.find(val);
		} else {
			return this;
		}
	}

	public static void main(String[] args) {
		Node p = new Node(10);
		Node p1 = new Node(9);
		Node p2 = new Node(15);
		Node p3 = new Node(11);
		Node p4 = new Node(20);
		p.left = p1;
		p.right = p2;
		p2.left = p3;
		p3.right = p4;
		Node n = p.find(7);
		System.out.println(n);
	}
}
