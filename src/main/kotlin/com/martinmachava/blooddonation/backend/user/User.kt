package com.martinmachava.blooddonation.backend.user

import com.martinmachava.blooddonation.backend.persistance.IdBasedEntity
import javax.persistence.Entity
import javax.persistence.OneToOne

@Entity
open class User(var name: String,
                var surname: String,
                var email: String) : IdBasedEntity<Long>() {
    @OneToOne
    var address: Address? = null
}

@Entity
open class Address(@OneToOne val user: User) : IdBasedEntity<Long>() {

    lateinit var country: String

    lateinit var postCode: String

    lateinit var town: String

    lateinit var houseNumber: String

    var street: String? = null

    var streetNumber: String? = null

}
