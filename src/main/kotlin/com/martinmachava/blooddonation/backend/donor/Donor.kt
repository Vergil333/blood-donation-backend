package com.martinmachava.blooddonation.backend.donor

import com.martinmachava.blooddonation.backend.persistence.entities.IdBasedEntity
import javax.persistence.*

@Entity
data class Donor(
        @Column(nullable = false) var email: String,
        @Column(nullable = false) var password: String,
        @Column(nullable = false) var firstName: String,
        @Column(nullable = false) var lastName: String): IdBasedEntity() {

    @OneToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY, mappedBy = "donor")
    var address: Address? = null
}

@Entity
data class Address(
        @OneToOne val donor: Donor,
        @Column(nullable = false) var country: String,
        @Column(nullable = false) var postCode: String,
        @Column(nullable = false) var town: String,
        @Column(nullable = false) var houseNumber: String): IdBasedEntity() {

    var street: String? = null
    var streetNumber: String? = null
}