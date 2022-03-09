package br.com.sysmap.srcmsportability.framework.exceptions;

public class FieldMessage {
    // nome do campo  -> name
    private String fieldName;
    //  Precisa ser entre 5 e 60 digitos
    private String message;

    public FieldMessage() {

    }

    public FieldMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
