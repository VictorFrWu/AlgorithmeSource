package Calypso;

import java.io.File;

public class windowFile {
	public static void main(String[] args) {
		File file0 = new File("1.txt");
		File file1 = new File("D:/myjava/a.txt");
		File file2 = new File("D:/myjava", "a/abc");
		File file3 = new File(file2, "c.txt");
		System.out.println("----------file0-----------------");
		System.out.println(file0.getAbsoluteFile()); // D:\myjava\io\1.txt
		System.out.println(file0.getAbsolutePath()); // D:\myjava\io\1.txt
		System.out.println(file0.getName()); // 1.txt
		System.out.println(file0.getParent()); // null
		System.out.println(file0.getParentFile()); // null
		System.out.println(file0.getPath()); // 1.txt
		System.out.println("----------file1-----------------");
		System.out.println(file1.getAbsoluteFile()); // D:\myjava\a.txt
		System.out.println(file1.getAbsolutePath()); // D:\myjava\a.txt
		System.out.println(file1.getName()); // a.txt
		System.out.println(file1.getParent()); // D:\myjava
		System.out.println(file1.getParentFile()); // D:\myjava
		System.out.println(file1.getPath()); // D:\myjava\a.txt
		System.out.println("----------file2-----------------");
		System.out.println(file2.getAbsoluteFile()); // D:\myjava\a\abc
		System.out.println(file2.getAbsolutePath()); // D:\myjava\a\abc
		System.out.println(file2.getName()); // abc
		System.out.println(file2.getParent()); // D:\myjava\a
		System.out.println(file2.getParentFile()); // D:\myjava\a
		System.out.println(file2.getPath()); // D:\myjava\a\abc
		System.out.println("----------file3-----------------");
		System.out.println(file3.getAbsoluteFile()); // D:\myjava\a\abc\c.txt
		System.out.println(file3.getAbsolutePath()); // D:\myjava\a\abc\c.txt
		System.out.println(file3.getName()); // c.txt
		System.out.println(file3.getParent()); // D:\myjava\a\abc
		System.out.println(file3.getParentFile()); // D:\myjava\a\abc
		System.out.println(file3.getPath()); // D:\myjava\a\abc\c.txt
	}
}
