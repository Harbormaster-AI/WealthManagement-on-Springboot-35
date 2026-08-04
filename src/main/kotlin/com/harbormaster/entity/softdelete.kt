package com.harbormaster.entity;

import java.time.Instant
import jakarta.persistence.MappedSuperclass

@MappedSuperclass
abstract class SoftDeleteEntity(

    version: Long? = null

) : AuditableEntity(version) {

    open var deleted: Boolean = false

    open var deletedBy: String? = null

    open var deletedDate: Instant? = null
}