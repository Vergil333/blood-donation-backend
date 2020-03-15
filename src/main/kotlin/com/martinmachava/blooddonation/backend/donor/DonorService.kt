package com.martinmachava.blooddonation.backend.donor

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

interface DonorService {
    var donorRepository: DonorRepository

    fun addNewDonor(newDonor: Donor): Donor

    fun getDonorByEmail(email: String): Donor

    fun deleteDonor(donor: Donor)
}

@Service
class DonorServiceImpl: DonorService {
    @Autowired
    override lateinit var donorRepository: DonorRepository

    override fun addNewDonor(newDonor: Donor): Donor = donorRepository.save(newDonor)

    override fun getDonorByEmail(email: String): Donor = donorRepository.getDonorByEmail(email)

    override fun deleteDonor(donor: Donor) = donorRepository.delete(donor)
}