/* Printer class
 * 
 * File output class in java
 * 
 * To Use: 
 * 
 * 	Printer p = new Printer(<file_name>);
 *	p.print(<string_to_write>);
 *	p.close();
 *  
 * OR:
 * 
 * 	Printer.filePrint(<file_name>, <string_to_write>);
 * 
 * NOTES:
 * 
 * 	ASSUMES UTF-8 ENCODING
 *  Does its own exception handling and prints to error stream, but doesn't throw exceptions and may later cause problems if unchecked
 *  No appending option
 *  
 * */

//package myFileIO;

import java.io.*;

public class Printer {

	protected PrintWriter out;
	protected String filename;
	
	public Printer(String filenam) /*throws Exception*/ {
		try {
			filename = filenam;
			out = new PrintWriter(
					new BufferedWriter(
							new OutputStreamWriter(
									new FileOutputStream(filenam),
									"utf-8")/*Close OutputStreamWriter constr*/
							)/*Close BufferedWriter constr*/
					); /*Close Writer constr*/
		}
		catch(Exception e) {
			System.err.println(out + ": Error! " + e);
			out = null;
			filenam = null;
			//throw e;
		}
	}
	
	//overload
	public String toString() {
		return( "Printer for " + filename );
	}
	
	public void print(String s) /*throws Exception*/ {
		try {
			out.print(s);
		} catch(Exception e) {
			System.err.println( out + ": Error! " + e);
			//throw e;
			e.printStackTrace();
		}
	}
	
	public void flush() {
		out.flush();
	}
	
	public void close() {
		out.close();
	}
	
	//writes s to file filenam in current directory, creates file filenam if non-existant
	//returns true if successful, false otherwise
	public static boolean filePrint(String filenam, String s) {

		try {
			PrintWriter static_out = new PrintWriter(
					new BufferedWriter(
							new OutputStreamWriter(
									new FileOutputStream(filenam),
									"utf-8")/*Close OutputStreamWriter constr*/
							)/*Close BufferedWriter constr*/
					); /*Close Writer constr*/
		
			
			static_out.write(s);
			
			static_out.close();
			//System.out.print("Wrote to file\n");
		} catch( Exception e ) {
			System.err.println("Printer Error! " + e);
			e.printStackTrace();
			return(false);
		}
		return(true);
	}
	
	public static void main(String[] args) {
		
		Printer.filePrint("printertest1.txt", "Hello again! I can write!\n");
				
		Printer p = new Printer("printertest2.txt");
		p.print("pt2.write/print!\n");
		p.close();

		System.out.print("Done.\n");
		
	}
		
	

}
