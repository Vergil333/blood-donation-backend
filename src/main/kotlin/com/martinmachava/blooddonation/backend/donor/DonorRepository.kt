package com.martinmachava.blooddonation.backend.donor

import org.springframework.data.jpa.repository.JpaRepository

interface DonorRepository: JpaRepository<Donor, Long> {
    fun getDonorByEmail(email: String): Donor
}