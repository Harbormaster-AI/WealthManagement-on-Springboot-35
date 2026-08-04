package com.harbormaster.entity;

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.Instant

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class AuditableEntity(

    version: Long? = null

) : BaseEntity(version) {

    @CreatedBy
    @Column(updatable = false)
    open var createdBy: String? = null

    @CreatedDate
    @Column(updatable = false)
    open var createdDate: Instant? = null

    @LastModifiedBy
    open var modifiedBy: String? = null

    @LastModifiedDate
    open var modifiedDate: Instant? = null
}