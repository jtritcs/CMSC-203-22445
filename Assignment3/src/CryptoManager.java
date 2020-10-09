/**
 * Class: CMSC203
 * Instructor: Grinberg
 * Description: Runs a guessing game where the user is tasked with giving a number
 * and is told whether the number is above or below the answer.
 * Due: 10/11/2020
 * I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
 I have not given my code to any student.
 Print your Name here: Justin Tritinger
 * @author Justin Tritinger
 */
public class CryptoManager {

    private static final char LOWER_BOUND = ' ';
    private static final char UPPER_BOUND = '_';
    private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

    /**
     * This method determines if a string is within the allowable bounds of ASCII codes
     * according to the LOWER_BOUND and UPPER_BOUND characters
     *
     * @param plainText a string to be encrypted, if it is within the allowable bounds
     * @return true if all characters are within the allowable bounds, false if any character is outside
     */
    public static boolean stringInBounds(String plainText) {
        for (char c : plainText.toCharArray()) {
            if (c < LOWER_BOUND || c > UPPER_BOUND) return false;
        }
        return true;
    }

    /**
     * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
     * and each character in plainText is replaced by the character \"offset\" away from it
     *
     * @param plainText an uppercase string to be encrypted.
     * @param key       an integer that specifies the offset of each character
     * @return the encrypted string
     */
    public static String encryptCaesar(String plainText, int key) {
        // Check plain text is within bounds
        if (stringInBounds(plainText)) {
            StringBuilder out = new StringBuilder();
            // loop through string
            for (char c : plainText.toCharArray()) {
                // append character plus key
                out.append((char) (c + key));
            }
            return out.toString();
        } else {
            return "Outside Bounds";
        }
    }

    /**
     * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset
     * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
     * to correspond to the length of plainText
     *
     * @param plainText  an uppercase string to be encrypted.
     * @param bellasoStr an uppercase string that specifies the offsets, character by character.
     * @return the encrypted string
     */
    public static String encryptBellaso(String plainText, String bellasoStr) {
        // Check plain text is within bounds
        if (stringInBounds(plainText)) {
            StringBuilder out = new StringBuilder();
            // loop through string
            for (int i = 0; i < plainText.length(); i++) {
                char indexedChar = plainText.charAt(i);
                char keyChar = bellasoStr.charAt(i);
                // add corresponding key
                char totalChar = (char) (indexedChar + keyChar);
                // subtract 64
                totalChar -= 64;
                // keep within range
                if (totalChar > 95) totalChar -= 64;
                out.append(totalChar);
            }
            return out.toString();
        } else {
            return "Outside Bounds";
        }
    }

    /**
     * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
     * and each character in encryptedText is replaced by the character \"offset\" characters before it.
     * This is the inverse of the encryptCaesar method.
     *
     * @param encryptedText an encrypted string to be decrypted.
     * @param key           an integer that specifies the offset of each character
     * @return the plain text string
     */
    public static String decryptCaesar(String encryptedText, int key) {
        StringBuilder out = new StringBuilder();
        // loop through string
        for (char c : encryptedText.toCharArray()) {
            // append character minus key
            out.append((char) (c - key));
        }
        return out.toString();
    }

    /**
     * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
     * the character corresponding to the character in bellasoStr, which is repeated
     * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
     *
     * @param encryptedText an uppercase string to be encrypted.
     * @param bellasoStr    an uppercase string that specifies the offsets, character by character.
     * @return the decrypted string
     */
    public static String decryptBellaso(String encryptedText, String bellasoStr) {
        StringBuilder out = new StringBuilder();
        // loop through string
        for (int i = 0; i < encryptedText.length(); i++) {
            char indexedChar = encryptedText.charAt(i);
            char keyChar = bellasoStr.charAt(i);
			// subtract corresponding key
            char resultChar = (char) (indexedChar - keyChar);
            resultChar += 64;
			// undo any range checks
            if (resultChar + 64 <= 95) resultChar += 64;

            out.append(resultChar);
        }
        return out.toString();
    }
}
