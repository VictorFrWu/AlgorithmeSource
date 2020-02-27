package DesignPattern.Decartor;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author he.wu
 *	inputstream is abstract class 
 *	fileinputstream, stringbuffer, byteinput is a subclass of inputstream 
 *	filterinputstream is a decator class, who contain the inputstream
 *	datainput linenumberinput has instance of decoration like milk joja 
 *
 */
public class DecoJavadoc {
	public static void main(String[] args) throws IOException {
		DataInputStream d = new DataInputStream(new FileInputStream("C:/Users/he.wu/Desktop/rawdate.csv"));
		System.out.println(d.read());
		d.close();
	}
}

