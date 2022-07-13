
import java.util.Scanner;
import java.util.Arrays;

public class primeMain {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
	int setRange;
	Scanner input = new Scanner(System.in);
	System.out.println("Please select a positive Range for Prime Number Display: ");
	setRange = input.nextInt();
	
	System.out.print(primeCount(setRange));
		
}
	
public static String primeCount(int Range) {
	int[] prime = new int[Range];
	Arrays.fill(prime, 1);
	int tuple = 0;
	String total; 
	for(int i=1; i < Range; i++)
	{
		long fact = 1;
		for(int j=1; j<(i); ++j)
		{
			fact = fact*j;
		}
		if((fact+1) % i == 0 && tuple<Range)
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
