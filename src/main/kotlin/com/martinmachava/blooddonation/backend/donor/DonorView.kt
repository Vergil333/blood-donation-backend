package com.martinmachava.blooddonation.backend.donor

data class DonorView(
        var email: String,
        var firstName: String,
        var lastName: String,
        var address: Address? = null)

fun Donor.toDonorView() = DonorView(
        email, firstName, lastName, address
)
