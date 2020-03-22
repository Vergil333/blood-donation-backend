package com.martinmachava.blooddonation.backend.donor

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

const val DONOR_EMAIL: String = "jozko.furik@email.com"
const val DONOR_PASSWORD: String = "testPASSWORD"
const val DONOR_FIRST_NAME: String = "Jožko"
const val DONOR_LAST_NAME: String = "Fúrik"

private val DONOR: Donor = Donor(
        DONOR_EMAIL,
        DONOR_PASSWORD,
        DONOR_FIRST_NAME,
        DONOR_LAST_NAME
)

private val ADDRESS: Address = Address(
        DONOR,
        ADDRESS_COUNTRY_CODE,
        ADDRESS_POSTAL_CODE,
        ADDRESS_TOWN,
        ADDRESS_HOUSE_NUMBER
)

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DonorTest {

    @Nested
    inner class DonorCreation {
        val donor: Donor = DONOR

        @Nested
        inner class InitialFieldsAreCreated {
            @Test
            fun `test Email`() {
                assertThat(donor.email).isEqualTo(DONOR_EMAIL)
            }
            @Test
            fun `test Password`() {
                assertThat(donor.password).isEqualTo(DONOR_PASSWORD)
            }
            @Test
            fun `test First Name`() {
                assertThat(donor.firstName).isEqualTo(DONOR_FIRST_NAME)
            }
            @Test
            fun `test Last Name`() {
                assertThat(donor.lastName).isEqualTo(DONOR_LAST_NAME)
            }
            @Test
            fun `test Address`() {
                assertThat(donor.address).isNull()
            }
        }

        @Nested
        inner class AddressIsAdded {
            @Test
            fun `add and test Address`() {
                donor.address = ADDRESS
                assertThat(donor.address).isEqualTo(ADDRESS)
            }
        }

    }

}