import java.util.Scanner;
import java.lang.Math;

public class DiffieHellamnExchange {
	public static void main(String[] args) {
		System.out.println("----Diffie Hellamn Exchange----\n");

		Scanner in = new Scanner(System.in);
		//	Enter the common num p and the base g
		System.out.print("Enter the value of p and g respectively: ");
		int p = in.nextInt();
		int g = in.nextInt();

		//	Generate Random Number
		int SA = rand();
		int SB = rand();

		// Computation
		int TA = ((int) Math.pow(g, SA)) % p;
		int TB = ((int) Math.pow(g, SB)) % p;

		//	Key Exchange
		int key_A = ((int) Math.pow(TB, SA)) % p;
		int key_B = ((int) Math.pow(TA, SB)) % p;

		//	Checking
		if (key_A != key_B) {
			System.out.println("Something has gone wrong in the process");
		} else {
			int secret_key = key_A;
			System.out.println("The secret key between two hosts is " + secret_key);
			System.out.println("SAFE");
		}
		
		in.close();
	}

	// Method that Generate Random Secret Number for Alice and Bob
	public static int rand() {
		int i = 0;
		i = ((int) Math.random()) + 1;
		return i;
	}

}
