package src.main.java.controller;

public class PasswordEncrypter {

    private static final String DIVIDER = " ";

    public static String encryptPassword(String password) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            int encryptedChar = c * 2 + 6;
            sb.append(encryptedChar)
                    .append(DIVIDER);
        }
        return sb.toString();
    }

    public static String decryptPassword(String encryptedPass) {
        StringBuilder sb = new StringBuilder();
        String[] sChars = encryptedPass.split(DIVIDER);
        for (String sChar : sChars) {
            char c = (char)((Integer.parseInt(sChar) - 6) / 2);
            sb.append(c);
        }
        return sb.toString();
    }

}
