import java.util.Scanner;


class QuadRoot {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("ax^2 + bx + c");
		System.out.println("Please enter a");
		int a = scan.nextInt();
		System.out.println("Please enter b");
		int b = scan.nextInt();
		System.out.println("Please enter c");
		int c = scan.nextInt();

		double determinate = Math.sqrt(Math.pow(b, 2)-(4*a*c));
		double rootOne = ((-1*b) + determinate)/(2*a);
		double rootTwo = ((-1*b) - determinate)/(2*a);
		System.out.println("First root = " + rootOne + ", Second root = " + rootTwo);
	}
}
