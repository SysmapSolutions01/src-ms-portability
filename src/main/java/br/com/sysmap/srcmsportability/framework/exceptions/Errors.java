package br.com.sysmap.srcmsportability.framework.exceptions;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class Errors {

    @Getter
    private List<String> errorList;

    public Errors(String msg) {
        this.errorList = Arrays.asList(msg);
    }

    public Errors(List<String> errorList){
        this.errorList = errorList;
    }

}
