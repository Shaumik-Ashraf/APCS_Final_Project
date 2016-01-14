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
	public Printer(File file) {
		out = new PrintWriter(new BufferredWriter(new FileWriter(file)));
	}
	
	public Printer(String filename) {
		out = new PrintWriter(new BufferredWriter(new FileWriter(filename)), true);
	}
	
	//methods
	
	public void print(String s) {
		out.print( s.toCharArray() );	
	}
	
	public void println(String s) {
		out.print( s.toCharArray() );
	}
	
	public void flush() {
		out.flush();
	}
	
	public void close() {
		out.flush();
		out.close;
	}

}

