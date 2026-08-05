package com.harbormaster.exception;

public AuthorizationException extends BusinessException {

    public AuthorizationException(String entity, String operation ) {
        super(  "AUTH_FAILED",
                entity,
                operation,
                "Authorization failure on " + entity + " signaled during operation " + operation );
                );
    }
}