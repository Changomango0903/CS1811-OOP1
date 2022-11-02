import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Math;
public class SoulmateFinder{
	public static Scanner s = new Scanner(System.in);
	public static boolean overlappingJourneys(int sOne, int eOne, int sTwo, int eTwo){
		if ((sOne < sTwo && sTwo < eOne)||(sOne > sTwo && sOne < eTwo)){
			return true;
		}
		else if (sOne == sTwo && eOne == eTwo){
			return true;
		}
		else if (sOne == sTwo && (eOne > eTwo||eTwo > eOne))
			return true;
		else {
			return false;
		}

	}

	public static int getTravellers(int start, int end){
		System.out.println("Enter the overall number of travellers on the train: ");
		int tNum = s.nextInt();
		int soulMate = 0;
		while(tNum > 0) {
			System.out.println("Enter the traveller's name: ");
			String tName = s.next();
			System.out.println("Enter the boarding station: ");
			int tBoarding = s.nextInt();
			System.out.println("Enter the exit station: ");
			int tExit = s.nextInt();

			if (overlappingJourneys(start, end, tBoarding, tExit)){
				System.out.println(tName + " might be the soulmate.");
				soulMate++;
			}
			else {
				System.out.println(tName + " is not the soulmate.");
			}
			tNum--;
		}
		return soulMate;
	}

	public static int getTravellers(int start, int end, String fName){
		File file = new File("./"+fName);
		int potentialSoulmates = 0;
		try {
			Scanner sc = new Scanner(file);
			System.out.println("retrieved file");
			while(sc.hasNextLine()){
				String name;
				int tStart, tEnd;
				name = sc.next();
				tStart = sc.nextInt();
				tEnd = sc.nextInt();
				if(overlappingJourneys(start, end, tStart, tEnd)){
					System.out.println(name + " might be the soulmate.");	
					potentialSoulmates++;
				}
				else {
					System.out.println(name + " is no the soulmate.");
				}
				sc.nextLine();
			}
			sc.close();
		}
		catch (Exception e){
			System.out.println(e + " - Cannot find File!");
			return getTravellers(start, end);
		}
		return potentialSoulmates;
	}

	public static boolean overlappingLongJourneys(int sOne, int eOne, int sTwo, int eTwo, int n){
		int overlapVal = Math.min(eOne, eTwo) - Math.max(sOne, sTwo);
		if (n>=1) {
			return overlappingJourneys(sOne, eOne, sTwo, eTwo);
		}
		else if(overlappingJourneys(sOne, eOne, sTwo, eTwo) && overlapVal >= n){
			return true;
		}	
		else {
			return false;
		}
	}

	public static void main(String[] args){
		System.out.println("Where did your journey start?");
		int pBoarded = s.nextInt();
		System.out.println("Where did your journey end?");
		int pEnd = s.nextInt();
		if (args.length > 0){
			int potSoulmates = 0;
			for (String arg: args){
				potSoulmates += getTravellers(pBoarded, pEnd, arg);
			}
			System.out.println("Number of potential soulmates: " + potSoulmates);
		}
		else{
			System.out.println("Number of potential soulmates: " + getTravellers(pBoarded, pEnd));
		}
	}
}
