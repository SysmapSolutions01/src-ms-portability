package br.com.sysmap.srcmsportability.framework.helpers.validation;

import br.com.sysmap.srcmsportability.domain.enums.TelephoneCompany;
import java.util.Objects;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TelephoneCompanyTargetConstraintImpl implements ConstraintValidator<TelephoneCompanyTargetConstraint,Enum<?>> {


    @Override
    public void initialize(TelephoneCompanyTargetConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Enum value, ConstraintValidatorContext context) {
        return !Objects.equals(value.toString().toUpperCase(), TelephoneCompany.VIVO.toString());
    }
}
