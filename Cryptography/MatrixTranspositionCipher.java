import java.util.Scanner;

public class MatrixTranspositionCipher {
	public static void main(String[] args) {
		System.out.println("----Matrix Transposition Cipher Calculator----\n");

		Scanner in = new Scanner(System.in);

		// Allow the user to choose if they want to encrypt or decrypt a message
		System.out
				.println("- Press 1 to encrypt a message / Press 2 to decrypt a message - ");

		int input = in.nextInt();

		if (input == 1) {
			int key;
			System.out.print("Enter the key: ");
			key = in.nextInt();
			int keyLength = (int) (Math.log10(key) + 1);
			System.out
					.print("Enter the message that would like to be encrypted by Matrix Transposition Cipher: ");
			String EMessage = in.next();
			int messageLength = EMessage.length();
			String encryptMessage = encrypt(EMessage, messageLength, key,
					keyLength);
			System.out.println("The encrypted message is: " + encryptMessage);
		}

		else if (input == 2) {
			int key;
			System.out.print("Enter the key: ");
			key = in.nextInt();
			int keyLength = (int) (Math.log10(key) + 1);
			System.out
					.print("Enter the message that would like to be decrypted by Matrix Transposition Cipher: ");
			String DMessage = in.next();
			int messageLength = DMessage.length();
			String decryptMessage = decrypt(DMessage, messageLength, key,
					keyLength);
			System.out.println("The decrypted message is: " + decryptMessage);
		} else {
			System.out.println("Wrong Input!");
		}
		in.close();
	}
	
	//	Encryption
	public static String encrypt(String Message, int Mlength, int Key,
			int Klength) {
		String EMessage = "";
		int numRow = Mlength / Klength;
		int numColumn = Klength;
		char[][] matrix = new char[numRow][numColumn];
		int count = 0;
		for (int i = 0; i < numRow; i++) {
			for (int j = 0; j < numColumn; j++) {
				matrix[i][j] = Message.charAt(count);
				count++;
			}
		}
		
		for (int i = 0; i < Klength; i++) {
			int x = Integer.parseInt(Integer.toString(Key).substring(i, i + 1));
			for (int j = 0; j < numRow; j++) {
				EMessage += matrix[j][x - 1];
			}
		}
		return EMessage;
	}

	//	Decryption
	public static String decrypt(String Message, int Mlength, int Key,
			int Klength) {

		String DMessage = "";
		int numRow = Mlength / Klength;
		int numColumn = Klength;
		char[][] matrix = new char[numRow][numColumn];
		int count = 0;
		for (int i = 0; i < Klength; i++) {
			int x = Integer.parseInt(Integer.toString(Key).substring(i, i + 1));
			for (int j = 0; j < numRow; j++) {
				matrix[j][x - 1] = Message.charAt(count);
				if (count < Mlength) {
					count++;
				} else {
					break;
				}
			}
		}
		for (int i = 0; i < numRow; i++) {
			for (int j = 0; j < numColumn; j++) {
				DMessage += matrix[i][j];
			}
		}
		return DMessage;
	}
}
