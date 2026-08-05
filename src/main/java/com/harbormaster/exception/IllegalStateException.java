package com.harbormaster.exception;

public IllegalStateException extends BusinessException {

    public IllegalStateException(String entity, String operation ) {
        super(  "ILLEGAL_STATE",
                entity,
                operation,
                "Illegal state on " + entity + " signaled during operation " + operation );
                );
    }
}