/**
 * SO - wrapper class (sort of) for System.out
 * because I am too lazy to write System.out.println() every time.....
 * also, I want to make SOP a reality :)
 * 
 * NOTES: 
 * 	Only supports Object, String, int, float, double
 * 	Does not support other types (including arrays)
 *  Does not support format strings
 *  Added flush and clearScreen methods  
 *
 * Possible improvements:
 * 	Support all java types
 *  Catch and throw IO exceptions
 *  "Wrap" all System.out methods
 *  add Pln() or Pn() methods (so SOPn, SOPln)
 *  
 */
package gameutils;

/**
 * @author Shaumik Ashraf
 *
 */
 
public class SO {

	//print methods
	public static void print(Object O) {
		System.out.print(O);
	}
	
	public static void print(String s) {
		System.out.print(s);;
	}
	
	public static void print(int i) {
		System.out.print(i);
	}
	
	public static void print(float f) {
		System.out.print(f);
	}
	
	public static void print(double d) {
		System.out.print(d);
	}
	
	public static void print() { //why not?
		;
	}
	
	//println methods
	public static void println(Object O) {
		System.out.println(O);
	}
	
	public static void println(String s) {
		System.out.print(s + "\n");;
	}
	
	public static void println(int i) {
		System.out.print(i + "\n");
	}
	
	public static void println(float f) {
		System.out.print(f + "\n");
	}
	
	public static void println(double d) {
		System.out.print(d + "\n");
	}
	
	public static void println() {
		System.out.print("\n");
	}
	
	//P method!
	public static void P(Object O) {
		System.out.print(O);
	}
	
	public static void P(String s) {
		System.out.print(s);;
	}
	
	public static void P(int i) {
		System.out.print(i);
	}
	
	public static void P(float f) {
		System.out.print(f);
	}
	
	public static void P(double d) {
		System.out.print(d);
	}
	
	public static void P() { //why not?
		;
	}
	
	//maybe add Pn/Pln methods??
	
	//other methods
	public static void flush() {
		System.out.flush();
	}
	
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	
}
