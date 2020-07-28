package com.martinmachava.blooddonation.backend.donors

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

const val ADDRESS_COUNTRY_CODE: String = "CZ"
const val ADDRESS_POSTAL_CODE: String = "98700"
const val ADDRESS_TOWN: String = "Prague"
const val ADDRESS_HOUSE_NUMBER: String = "01"

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
class AddressTest {

    @Nested
    inner class AddAddressToDonor {
        val address: Address = ADDRESS

        @Nested
        inner class FieldsAreCreated {
            @Test
            fun `test Donor`() {
                Assertions.assertThat(address.donor).isEqualTo(DONOR)
            }
            @Test
            fun `test Country Code`() {
                Assertions.assertThat(address.countryCode).isEqualTo(ADDRESS_COUNTRY_CODE)
            }
            @Test
            fun `test Postal Code`() {
                Assertions.assertThat(address.postCode).isEqualTo(ADDRESS_POSTAL_CODE)
            }
            @Test
            fun `test Town`() {
                Assertions.assertThat(address.town).isEqualTo(ADDRESS_TOWN)
            }
            @Test
            fun `test House Number`() {
                Assertions.assertThat(address.houseNumber).isEqualTo(ADDRESS_HOUSE_NUMBER)
            }
            @Test
            fun `test null fields`() {
                Assertions.assertThat(address.street).isNull()
                Assertions.assertThat(address.streetNumber).isNull()
            }

        }
    }
}