import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Math;
public class SoulmateFinder{
	public static Scanner s = new Scanner(System.in);
	//Question 1
	public static boolean overlappingJourneys(int sOne, int eOne, int sTwo, int eTwo){
		//Checking that each trip is one way (smaller -> bigger)
		if((eOne < sOne) || (eTwo < sTwo)){
			System.out.println("erroneous output detected!");
			System.out.println("please only enter one way journeys");
			return false;
		}
		else if ((sOne < sTwo && sTwo < eOne)||(sOne > sTwo && sOne < eTwo)){ //checking for encapsulated journeys
			return true;
		}
		else if (sOne == sTwo && eOne == eTwo){ //checking for equivalent journeys
			return true;
		}
		else if (sOne == sTwo && (eOne > eTwo||eTwo > eOne)) //checking for encapsulated journeys with one head matching
			return true;
		else { //fail condition
			return false;
		}

	}
	//Question 2
	public static int getTravellers(int start, int end){
		System.out.println("Enter the overall number of travellers on the train: "); //prompting for iteration
		int tNum = s.nextInt();
		int soulMate = 0;
		while(tNum > 0) { //passenger creation
			System.out.println("Enter the traveller's name: ");
			String tName = s.next();
			System.out.println("Enter the boarding station: ");
			int tBoarding = s.nextInt();
			System.out.println("Enter the exit station: ");
			int tExit = s.nextInt();

			if (overlappingJourneys(start, end, tBoarding, tExit)){ //check for compatibility
				System.out.println(tName + " might be the soulmate.");
				soulMate++;
			}
			else { //fail condition
				System.out.println(tName + " is not the soulmate.");
			}
			tNum--;
		}
		return soulMate;
	}

	//Question 5
	public static int getTravellers(int start, int end, String fName){
		File file = new File("./"+fName); //File object creation
		int potentialSoulmates = 0; //accumulator
		try { //main function execution
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()){ //file parsing
				String name;
				int tStart, tEnd;
				name = sc.next();
				tStart = sc.nextInt();
				tEnd = sc.nextInt();
				if(overlappingJourneys(start, end, tStart, tEnd)){ //overlap check (no distance needed)
					System.out.println(name + " might be the soulmate.");	
					potentialSoulmates++;
				}
				sc.nextLine(); //iterand
			}
			sc.close(); //close Scanner
		}
		catch (FileNotFoundException e){
			System.out.println(e + " - Cannot find File!");
			return getTravellers(start, end);
		}
		catch (InputMismatchException e){
			System.out.println(e + " - Mismatching Input! Please enter correct datatype!");
			return getTravellers(start, end);
		}
		return potentialSoulmates;
	}

	//Question 4
	public static boolean overlappingLongJourneys(int sOne, int eOne, int sTwo, int eTwo, int n){
		int overlapVal = Math.min(eOne, eTwo) - Math.max(sOne, sTwo); //Overlap distance calculation
		if (n<=1) { //default condition (distance of 1 or higher)
			return overlappingJourneys(sOne, eOne, sTwo, eTwo); 
		}
		else if(overlappingJourneys(sOne, eOne, sTwo, eTwo) && overlapVal >= n){ //Condition of if overlap AND distance > n
			return true;
		}	
		else { //fail condition
			return false;
		}
	}

	//Question 3
	public static void main(String[] args) throws InputMismatchException{
		System.out.println("Where did your journey start?"); //prompt for start/end
		int pBoarded = s.nextInt();
		System.out.println("Where did your journey end?");
		int pEnd = s.nextInt();
		if (args.length > 0){ //file detection
			int potSoulmates = 0;
			for (String arg: args){ //file name iteration
				potSoulmates += getTravellers(pBoarded, pEnd, arg); //accumulator
			}
			System.out.println("Number of potential soulmates: " + potSoulmates); //program output
		}
		else{
			System.out.println("Number of potential soulmates: " + getTravellers(pBoarded, pEnd)); //default output
		}
	}
}
