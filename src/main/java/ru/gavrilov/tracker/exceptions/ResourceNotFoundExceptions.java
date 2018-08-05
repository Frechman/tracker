package ru.gavrilov.tracker.exceptions;

import lombok.Getter;

@Getter
public class ResourceNotFoundExceptions extends RuntimeException {

    private String resourceName;

    private String fieldName;

    private Object fieldValue;

    public ResourceNotFoundExceptions(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
