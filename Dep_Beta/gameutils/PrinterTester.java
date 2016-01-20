//PrinterTester - test Printer for file output

package gameutils;

//import gameutils.Printer;

import java.io.*;
import java.util.*;

public class PrinterTester {

    private static Printer out = new Printer("PrinterTest.txt");

    public static void main(String[] args) {

	out.print("Hello World!\n");
	out.close();

    }

}
