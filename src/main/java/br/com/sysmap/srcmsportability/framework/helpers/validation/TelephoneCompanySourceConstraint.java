package br.com.sysmap.srcmsportability.framework.helpers.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TelephoneCompanySourceConstraintImpl.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TelephoneCompanySourceConstraint {

    String message() default "Source must be VIVO";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
}
