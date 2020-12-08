// William Rice
// Tally Program
// This program takes in a file and counts how many of
// each letter there are, it then outputs the amount
// in the form of a percent in the terminal

// Importing classes
import java.io.*;

// Start of the Tally Class
public class TallyLetters {
	
	// Defining private data
	private int[] tally = new int[26];
	private int totalLetters = 0;
	
	// Constructor for the class
	public TallyLetters() {
		
	}
	
	// This method returns the tally of a specific letter and an integer
	public int getTally(int x) {
		
		return tally[x];
	
	}
	
	// This method returns the total number of letters as an integer
	public int getLetters() {
	
		return totalLetters;
	
	}
	
	// This method returns the percent of a letter as a double
	public double getPercent(int x) {
		
		double percent = (double) getTally(x) / getLetters();
		
		percent = ((int) ((1000 * percent) + 0.5)) / 10.0;
		
		if(getTally(x) == 0) {
			return 0;
		}
		
		return percent;
	
	}
	
	// This method allows the user to input the name of a file, it also calls the method that reads the file
	public void setFile() throws IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Input File Name");
		
		readFile(input.readLine());
		
	}
	
	// This method adds a letter to the tally and increases the total letters
	private void addLetters(String lineValue) {
		
		for(int i=0; i<lineValue.length(); i++) {
			
			if((int) lineValue.charAt(i)-97 >= 0 && (int) lineValue.charAt(i)-97 <= 25) {
			
				tally[(int) lineValue.charAt(i)-97]++;
				totalLetters++;
			
			}
			
		}
		
	}
	
	// This method reads a given file line by line then calls the add letters method to increase letters
	private void readFile(String fileName) throws IOException {
		
		FileReader readFile = new FileReader(fileName);
		BufferedReader inFile = new BufferedReader(readFile);

		String inputString = inFile.readLine(); // try to read one line and store it in a string

		System.out.println("\nFile - " + fileName);
		System.out.println("File Start ---");
		while (inputString != null){
			
			System.out.println(inputString);
			
			addLetters(inputString.toLowerCase());

			inputString = inFile.readLine(); // try to read one line and store it in a string
			
		}

		System.out.println("File End ---");
		
		inFile.close(); //ALWAYS CLOSE FILE
		
	}
	
	// This method outputs the tally, total letters, and percent of each letter to the terminal
	public void output() {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		System.out.println("\n\n--- Letter Tallys ---\n" + "Total Letters = " + getLetters() + "\nLetter\t\t# of Letters\t\tPercent");
		
		for(int i=0; i<26; i++) {
			
			System.out.println(alphabet.charAt(i) + "\t\t" + getTally(i) + "\t\t\t" + getPercent(i) + "%");
					
		}
	}

	// This is the main method, it calls the other methods+*1-1
	public static void main(String[] args) throws IOException {
		
		TallyLetters letters = new TallyLetters();
		
		letters.setFile();
		
		letters.output();
				
	}
			
}

/*
Input File Name
paragraph.txt

File - paragraph.txt
File Start ---
	An array is a data structure made up of a group of locations having the 
same type and given a common name.  Each individual location is accessed by 
its name and position (index) in the group.  The position numbering starts at 
zero.

	Described below are some typical types of processing that occur when 
using arrays:  searching, sorting, and parallel arrays.

	Searching is looking systematically through the elements of an array for a 
specific value.  You may need to know only if the value is in the array, or you 
may need to know its position in the array.  There are two algorithms for 
searching:  linear and binary.

	Arranging values in ascending, descending, or alphabetical order is 
called sorting.  There are many different algorithms for sorting.  The ones we will 
study include selection, bubble, insertion, merge, and quick.  Which of these do 
you already know? 

	In many problems there are several pieces which go together.  For 
example, you might have student id numbers, gender codes (M or F), and qpas.  
You could use an integer array for the id numbers, a character array for the 
gender codes, and a double array for the qpas.  A particular id number goes
with a particular gender code and a particular qpa because they have the same 
position in their respective arrays, that is, they have the same index!  Such
arrays are called parallel arrays.
File End ---


--- Letter Tallys ---
Total Letters = 1075
Letter		# of Letters		Percent
A		115			10.7%
B		15			1.4%
C		41			3.8%
D		42			3.9%
E		125			11.6%
F		17			1.6%
G		30			2.8%
H		45			4.2%
I		76			7.1%
J		0			0.0%
K		5			0.5%
L		42			3.9%
M		26			2.4%
N		74			6.9%
O		70			6.5%
P		25			2.3%
Q		4			0.4%
R		93			8.7%
S		67			6.2%
T		70			6.5%
U		34			3.2%
V		11			1.0%
W		11			1.0%
X		3			0.3%
Y		33			3.1%
Z		1			0.1%
*/

// The tabs are a bit messed up here but they look fine in my terminal