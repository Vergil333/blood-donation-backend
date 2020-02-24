package com.martinmachava.blooddonation.backend.persistance

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.domain.Persistable
import org.springframework.data.util.ProxyUtils
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*

@MappedSuperclass
abstract class IdBasedEntity<T : Serializable> : Persistable<T> {

    companion object {
        private val serialVersionUID = -5554308939380869754L
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: T? = null

    override fun getId(): T? {
        return id
    }

    @CreationTimestamp
    lateinit var created: LocalDateTime

    @UpdateTimestamp
    lateinit var updated: LocalDateTime

    /**
     * Must be [Transient] in order to ensure that no JPA provider complains because of a missing setter.
     *
     * @see org.springframework.data.domain.Persistable.isNew
     */
    @Transient
    override fun isNew(): Boolean = null == getId()

    override fun toString(): String = "Entity of type ${this.javaClass.name} with id: $id"

    override fun equals(other: Any?): Boolean {
        other ?: return false

        if (this === other) return true

        if (javaClass != ProxyUtils.getUserClass(other)) return false

        other as IdBasedEntity<*>

        return if (null == this.getId()) false else this.getId() == other.getId()
    }

    override fun hashCode(): Int {
        return 31
    }
}