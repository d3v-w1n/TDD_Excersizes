
import java.util.Scanner;
import java.util.Arrays;


public class primeFinished {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
	int setRange;
	Scanner input = new Scanner(System.in);
	System.out.println("Please select a positive Range for Prime Number Display: ");
	setRange = input.nextInt();
	input.close();
	
	System.out.print(primeCount(setRange));
	
}

	public static boolean isPrime(int num) { if (num <= 1) {
		return false; }
		for (int i = 2; i <= Math. sqrt(num); i++) { if (num % i == 0) {
		return false; }
		} return true;
		}
	
public static String primeCount(int Range) {
	int[] prime = new int[Range];
	Arrays.fill(prime, 1);
	int tuple = 0;
	String total; 
	for(int i=1; i < Range; i++)
	{

		if(isPrime(i))
		{
			++tuple;
			prime[tuple]=i;
		}
	}

	total = "Total Prime Numbers: "+tuple;
	
	for(int number=0; number<tuple; number++) {
		System.out.printf("%d%n", prime[number]);}
	return total;
	}
}	
