package com.harbormaster.exception;

public class DuplicateEntityException extends BusinessException {

    public DuplicateEntityException(String entity, operation ) {
        super(  "DUPLICATE_ENTRY",
                entity,
                operation,
                "Duplicate entity " + entity + " found during operation " + operation );
                );
    }
}