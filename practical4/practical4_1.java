public class practical4_1 {
    public static void main(String[] args) {

        String[] passwords = {
            "abc",
            "abcdefghi",
            "Abcdefgh",
            "Abcd1234",
            "Abcd1234!"
        };

        for (String pw : passwords) {

            System.out.println("Password: " + pw);

            if (PasswordChecker.lengthCheck(pw))
                System.out.println("Length >= 8: Passed");
            else
                System.out.println("Length >= 8: Failed");

            if (PasswordChecker.uppercaseCheck(pw))
                System.out.println("Uppercase letter: Passed");
            else
                System.out.println("Uppercase letter: Failed");

            if (PasswordChecker.digitCheck(pw))
                System.out.println("Digit: Passed");
            else
                System.out.println("Digit: Failed");

            if (PasswordChecker.specialCheck(pw))
                System.out.println("Special character: Passed");
            else
                System.out.println("Special character: Failed");

            System.out.println("Strength: " + PasswordChecker.strength(pw));
            System.out.println();
        }
    }
}