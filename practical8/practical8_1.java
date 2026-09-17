import java.util.*;

class DivideByZeroException extends Exception {
    DivideByZeroException(String message) {
        super(message);
    }
}

public class practical8_1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter first number: ");
                double a = Double.parseDouble(sc.nextLine());

                System.out.print("Enter operator (+, -, *, /): ");
                char op = sc.nextLine().charAt(0);

                System.out.print("Enter second number: ");
                double b = Double.parseDouble(sc.nextLine());

                double result;

                switch (op) {
                    case '+':
                        result = a + b;
                        break;

                    case '-':
                        result = a - b;
                        break;

                    case '*':
                        result = a * b;
                        break;

                    case '/':
                        if (b == 0)
                            throw new DivideByZeroException("Cannot divide by zero.");
                        result = a / b;
                        break;

                    default:
                        throw new IllegalArgumentException("Invalid operator.");
                }

                System.out.println("Result = " + result);
                break;

            } catch (NumberFormatException e) {
                System.out.println("Invalid number input. Please enter valid numbers.");

            } catch (DivideByZeroException e) {
                System.out.println(e.getMessage());

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());

            } finally {
                System.out.println("Calculation attempt logged.\n");
            }
        }

        sc.close();
    }
}