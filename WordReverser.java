import java.util.*;
public class WordReverser {
	//This program will analyse and manipulate a string defined by the user.
	//WillAY998 2017
		//A method for the word reversing segment of the program is defined.
		static boolean reverseWord (String NthChar,int BeginReverse, int Counter) {
			boolean Palindrome = true;

				for (int i = BeginReverse;i < Counter;i++) {
					 System.out.print(NthChar.charAt(BeginReverse + Counter -1 - i));
					 //The following 'if' statement checks if the word being reversed is a palindrome.
					 if(NthChar.charAt(i) != NthChar.charAt(BeginReverse + Counter -1 - i)) {
						 Palindrome = false;
					 }
				}
				
				
				return Palindrome;
		}
		

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int UserChoice = 0;
		boolean Manipulator = true;
		boolean Palindrome = true;
		boolean Pangram = true;
		boolean[] Alphabet;
		Alphabet = new boolean[26];
		
		
		//This loop provides full control of program functionality.
		while(Manipulator == true) {
			//The user is presented with a series of options.
			System.out.println("String Manipulator by Will Akinsanya - 2937067." +"\n" + "Program Menu" +"\n" + "1. Rules & Information (1)" +"\n" + "2. Begin (2)" +"\n" + "3. Quit (3)");
			UserChoice = scan.nextInt();
			scan.nextLine();
			System.out.println(""); //The purpose of this command is to improve presentation & readability.

			//The user opts to quit the program, the boolean Manipulator becomes false.
			if(UserChoice == 3) {
				System.out.println("Goodbye, thank you for using this program");
				Manipulator = false;
			}

			//The user requests the rules that govern the program.
			if (UserChoice == 1) {
				System.out.println("Rules & Information");
				System.out.println("1. The 'nth term' you provide cannot exceed the number of words that exists in your string.");
				System.out.println("Note that the 'nth term' must be a natural number, e.g 1,2,3,4.");
				System.out.println("2. This program checks for the presence of both a palindrome and pangram.");
				System.out.println("3. Only lowercase letters are considered for the pangram and duplicity of letters is not accepted.");
				System.out.println("");
			}

			if(UserChoice == 2 && Manipulator == true) {
				//Variables required for program functionality are established.
				int WordCount = 1;  //Set at 1 because this value cannot be less than 1.
				int BeginReverse = -1;
				int Counter = 0;
				int CheckCounter = 0;
				int SpaceCount = 0;
				String s = "";
				

				System.out.println("Enter a string, i.e word(s).");
				s = scan.nextLine();
				int StringLength = s.length();

				//The next batch of user-provided information is collected.
				System.out.println("Define the nth term (natural number only) at which word reversal(s) will occur.");
				int FixedNthTerm = scan.nextInt();
				scan.nextLine();
				int VariableNthTerm =  FixedNthTerm;
				Pangram = true;
				for (int i = 0; i < 26; i++) {
					Alphabet[i] = false;
				}
				while(CheckCounter < StringLength) {
					if(s.charAt(CheckCounter) == ' ') {
						SpaceCount++;
					}
				
		
					int Index = (int)(s.charAt(CheckCounter));
					
					if(97 <= Index && Index <= 122) {
						Alphabet[Index - 97] = true;
					}
					CheckCounter++;
				}
				
				for(int i = 0; i < 26; i++) {
					if(Alphabet[i] == false) {
						Pangram = false;
					}
				}
				
				if((SpaceCount + 1) < FixedNthTerm) {
					System.out.println("The nth term does not exist within the defined string, please restart the program.");
					System.out.println("");
					break;
				}
				while(Counter < StringLength) {
					//This if statement will determine if the reverseWord method will be called.
					if(WordCount == VariableNthTerm) {
						//This while loop allows for the position of a word in a string to be identified.
						BeginReverse = Counter;
						while (Counter < StringLength && s.charAt(Counter) != ' ' && s.charAt(Counter) != ',' && s.charAt(Counter) != '.') {
							Counter++;
						}
						
						Palindrome = reverseWord(s, BeginReverse, Counter);
						if(Palindrome == true) {
							System.out.print(" [palindrome] ");
						}

						//A sequence is created to identify when another word reversal is needed.
						VariableNthTerm = VariableNthTerm + FixedNthTerm;
						WordCount++;

					}

					if(Counter < StringLength) {
						System.out.print(s.charAt(Counter));
					}
					Counter++;

					if(Counter < StringLength && s.charAt(Counter) == ' ') {
						System.out.print(s.charAt(Counter));
						WordCount++;
						Counter++;
					}
					
					
				}
				System.out.println("");
				if(Pangram == true) {
					System.out.println("The defined string is a pangram.");
				} else {
					System.out.println("The defined string is not a pangram.");
				}
				
			}

		}

	}

}
