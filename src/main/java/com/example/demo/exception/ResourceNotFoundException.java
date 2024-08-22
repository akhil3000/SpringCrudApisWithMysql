package com.example.demo.exception;

public class ResourceNotFoundException extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private long fieldValue;
    public ResourceNotFoundException(String resourceName,String fieldName, long fieldValue) {
        super(String.format("%s not found with '%s'",resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldValue = fieldValue;
        this.fieldName = fieldName;
    }

    public String getResourceName(){
        return resourceName;
    }

    public String getFieldName(){
        return fieldName;
    }

    public long fieldValue(){
        return fieldValue;
    }


}
