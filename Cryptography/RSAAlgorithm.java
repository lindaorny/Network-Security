import java.util.Scanner;

public class RSAAlgorithm {
	public static void main(String[] args) {
		System.out
				.println("----RSA Algorithm - Generating the Encrypted Message----\n");

		Scanner in = new Scanner(System.in);
		System.out.print("Enter the Message(An Integer): ");
		int m = in.nextInt();

		System.out.print("Enter the public key(e, n): ");
		int e = in.nextInt();
		int n = in.nextInt();

		System.out.print("The encrypted message is: " + encrypt(m, e, n));

	}

	public static int encrypt(int m, int e, int n) {
		int EMessage;
		int exponents = (int)Math.pow(m, e);
		EMessage = exponents % n;
		return EMessage;
	}
}
