/*
 Printer class - made for outputting to file
 wraps class printwriter with better constructor (constructs with BufferedWriter)
 does not append, automatic flushing
 
 
*/

package gameutils;

import java.io.*;
import java.util.*;

public class Printer {

	//attribute
	protected PrintWriter out;

	//constructor
	public Printer(File file) throws IOException {
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		} catch( IOException e ) {
			System.err.println("Error! "  + e);
			//print e.printStackTrace();
		}
	}
	
	public Printer(String filename) throws IOException {
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(filename)), true);
		catch( IOException e ) {
			System.err.println("Error! "  + e);
			
		}
	}
	
	//methods
	public void print(String s) {
		out.print( s.toCharArray() );	
	}
	
	public void println(String s) {
		out.println( s.toCharArray() );
	}
	
	public void flush() {
		out.flush();
	}
	
	public void close() {
		out.flush();
		out.close();
	}

}

