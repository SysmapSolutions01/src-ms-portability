package br.com.sysmap.srcmsportability.framework.helpers.validation;

import br.com.sysmap.srcmsportability.domain.enums.TelephoneCompany;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TelephoneCompanySourceConstraintImpl implements ConstraintValidator<TelephoneCompanySourceConstraint,Enum> {
    @Override
    public void initialize(TelephoneCompanySourceConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Enum value, ConstraintValidatorContext context) {
        return TelephoneCompany.VIVO.toString().equals(value.toString().toUpperCase()) ? true : false;
    }
}
