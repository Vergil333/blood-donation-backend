package com.martinmachava.blooddonation.backend.donors

import com.martinmachava.blooddonation.backend.persistence.entities.IdBasedEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.OneToOne

@Entity
data class Address(
        @OneToOne val donor: Donor,
        @Column(nullable = false) var countryCode: String,
        @Column(nullable = false) var postCode: String,
        @Column(nullable = false) var town: String,
        @Column(nullable = false) var houseNumber: String): IdBasedEntity() {

    var street: String? = null
    var streetNumber: String? = null
}
