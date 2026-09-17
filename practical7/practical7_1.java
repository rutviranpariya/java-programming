import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotBlank {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class SignupForm {

    @NotBlank
    @MaxLength(20)
    String name;

    @NotBlank
    @MaxLength(30)
    String email;

    @MaxLength(10)
    String city;

    SignupForm(String name, String email, String city) {
        this.name = name;
        this.email = email;
        this.city = city;
    }
}

class FormChecker {

    public static List<String> validate(Object obj) {

        List<String> errors = new ArrayList<>();

        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {

            field.setAccessible(true);

            try {
                String value = (String) field.get(obj);

                if (field.isAnnotationPresent(NotBlank.class)) {
                    if (value == null || value.trim().isEmpty()) {
                        errors.add(field.getName() + " cannot be blank");
                    }
                }

                if (field.isAnnotationPresent(MaxLength.class)) {

                    MaxLength annotation =
                        field.getAnnotation(MaxLength.class);

                    int max = annotation.value();

                    if (value != null && value.length() > max) {
                        errors.add(field.getName()
                                + " exceeds maximum length " + max);
                    }
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return errors;
    }
}

public class practical7_1 {

    public static void main(String[] args) {

        SignupForm form = new SignupForm(
            "",
            "verylongemailaddress123456789@example.com",
            "Anand"
        );

        List<String> errors = FormChecker.validate(form);

        if (errors.isEmpty()) {
            System.out.println("Form is valid");
        } else {
            System.out.println("Validation Errors:");

            for (String error : errors) {
                System.out.println(error);
            }
        }
    }
}