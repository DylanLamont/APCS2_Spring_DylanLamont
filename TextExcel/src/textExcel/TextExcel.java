package textExcel;
import java.util.*;
import java.io.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
	    Spreadsheet sprdsheet = new Spreadsheet();
	    Scanner input = new Scanner(System.in);
	    String command = input.next();
	    while (!command.equalsIgnoreCase("quit")){
	    	System.out.println(sprdsheet.processCommand(command));
	    	command = input.next();
	    }
	}
}
