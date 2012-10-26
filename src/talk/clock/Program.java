package talk.clock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {
	
	public static void main(String [] args) throws IOException
	{
		String line = "";		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Press 'T' on your keyboard to tell the time and 'Q' to quit application");
		while (!line.equals("Q")){			
			line = br.readLine().toUpperCase();			
			switch (line) {
				case ("Q"):
					System.out.println("Quitting clock application");
					break;
				case ("T"):
					ConverseClock clock = new ConverseClock();
					System.out.println(clock.theTimeIs());
					continue;
				default:
					System.out.println("Please Select a valid option 'T' or 'Q'");
					continue;					
			}
		}
		
	}

}
