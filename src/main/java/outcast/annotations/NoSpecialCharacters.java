package outcast.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.Pattern;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author outcast c-cute hột me 😳
 */

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {})
@Documented
@Pattern(regexp = "[a-zA-Z0-9]*")
@ReportAsSingleViolation
public @interface NoSpecialCharacters {
    String message() default "Cannot contain special characters!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}