package br.com.sysmap.srcmsportability.framework.exceptions;


import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    private List<FieldMessage> erros = new ArrayList<>();

    public List<FieldMessage> getErros() {
        return erros;
    }

    public void addError(String fieldName, String msg) {
        erros.add(new FieldMessage(fieldName, msg));
    }
}
