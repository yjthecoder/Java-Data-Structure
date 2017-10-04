package cs61bNoteCode;
	import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
	
/*
 * How to read a line of text? With readLine on BufferedReader.
 * How to create a BufferedReader? With an InputStreamReader.
 * How to create a InputStreamReader? With an InputStream.
 * How to create a InputStream? With a URL.
 */



public class readTheFirstLineFromAWebpage {

	
	 public static void main(String[] arg) throws Exception {
	 URL u = new URL("http://www.google.ca/");
	 InputStream ins = u.openStream();
	 InputStreamReader isr = new InputStreamReader(ins);
	 BufferedReader whiteHouse = new BufferedReader(isr);
	 System.out.println(whiteHouse.readLine());
	 }
	
}
