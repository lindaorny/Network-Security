import java.util.Scanner;

public class CaeserCipher {

	final static char alphabet[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
			'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
			'v', 'w', 'x', 'y', 'z' };

	public static void main(String[] args) {

		System.out.println("----Caeser Cipher Calculator----\n");

		Scanner in = new Scanner(System.in);

		System.out
				.println("- Press 1 to encrypt a message / Press 2 to decrypt a message - ");

		int input = in.nextInt();

		if (input == 1) {
			System.out.print("Enter the Key Value: ");
			int key = in.nextInt();
			System.out
					.print("Enter the message that would like to be encrypted by Caeser Cipher: ");
			String EMessage = in.next();
			String encryptMessage = encrypt(EMessage, key);
			System.out.println("The encrypted message is: " + encryptMessage);
		}

		else if (input == 2) {
			System.out.print("Enter the Key Value: ");
			int key = in.nextInt();
			System.out
					.print("Enter the message that would like to be decrypted by Caeser Cipher: ");
			String DMessage = in.next();
			String decryptMessage = decrypt(DMessage, key);
			System.out.println("The decrypted message is: " + decryptMessage);
		}
		else {
			System.out.println("Wrong Input!");
		}
		in.close();
	}

	public static String encrypt(String Message, int Key) {
		String EMessage = "";
		int textpos = 0;
		Message = Message.toLowerCase();
		for (int i = 0; i < Message.length(); i++) {
			textpos = 0;
			for (int j = 0; j < 26; j++) {
				if (Message.charAt(i) == alphabet[j]) {
					textpos = j;
				}
			}
			int keyVal = (Key + textpos) % 26;
			EMessage += alphabet[keyVal];
		}
		return EMessage;
	}

	public static String decrypt(String Message, int Key) {
		String EMessage = "";
		int textpos = 0;
		Message = Message.toLowerCase();
		for (int i = 0; i < Message.length(); i++) {
			textpos = 0;
			for (int j = 0; j < 26; j++) {
				if (Message.charAt(i) == alphabet[j]) {
					textpos = j;
				}
			}
			int keyVal = (textpos - Key) % 26;
			EMessage += alphabet[keyVal];
		}
		return EMessage;
	}
}
