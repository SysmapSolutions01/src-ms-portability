package br.com.sysmap.srcmsportability.framework.helpers.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TelephoneCompanyTargetConstraintImpl.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TelephoneCompanyTargetConstraint {

    String message() default "Can't make portability from the same SOURCE and TARGET Telephone Company.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
}
