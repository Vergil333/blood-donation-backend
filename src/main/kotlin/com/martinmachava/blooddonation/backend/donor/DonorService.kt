package com.martinmachava.blooddonation.backend.donor

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

interface DonorService {
    var repository: DonorRepository

    fun addDonor(donor: Donor): DonorView

    fun getDonorByEmail(email: String): DonorView

    fun deleteDonor(donor: Donor)
}

@Service
class DonorServiceImpl: DonorService {
    @Autowired
    override lateinit var repository: DonorRepository

    override fun addDonor(donor: Donor): DonorView = repository.save(donor).toDonorView()

    override fun getDonorByEmail(email: String): DonorView = repository.getDonorByEmail(email).toDonorView()

    override fun deleteDonor(donor: Donor) = repository.delete(donor)
}