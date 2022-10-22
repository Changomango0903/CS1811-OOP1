import java.util.Scanner;
public class Power{
	public static double powRec(double base, int exponent){
		if(exponent == 0) {
			return 1;
		}
		else {
			return base*powRec(base, exponent-1);
		}
	}

	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		double b = k.nextDouble();
		int e = k.nextInt();
		System.out.println(powRec(b, e));
	}
}
