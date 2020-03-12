package XMLReader;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXQueryDemo {
	public static void main(String[] args) {

		try {
			File inputFile = new File("C:/Users/he.wu/eclipse-workspace/AlgorithmeSource/BlogNotes/src/main/java/XMLReader/Students.xml");
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			UserHanlder userhandler = new UserHanlder();
			saxParser.parse(inputFile.getAbsolutePath(), userhandler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
