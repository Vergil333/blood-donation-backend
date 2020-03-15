package com.martinmachava.blooddonation.backend.persistence.entities

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
open class IdBasedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = -1

    @CreationTimestamp
    lateinit var created: LocalDateTime

    @UpdateTimestamp
    lateinit var updated: LocalDateTime
}