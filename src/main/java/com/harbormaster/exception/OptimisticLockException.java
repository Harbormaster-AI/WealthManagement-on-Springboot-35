package com.harbormaster.exception;

public OptimisticLockException extends BusinessException {

    public OptimisticLockException(String entity, String operation ) {
        super(  "OPT_LOCK",
                entity,
                operation,
                "Optimistic lock on " + entity + " signaled during operation " + operation );
                );
    }
}