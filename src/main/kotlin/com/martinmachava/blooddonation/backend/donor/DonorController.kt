package com.martinmachava.blooddonation.backend.donor

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/donor")
class DonorController {
    @Autowired
    lateinit var donorService: DonorService

    @GetMapping
    fun getDonor(@RequestParam("email") email: String) = donorService.getDonorByEmail(email)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addNewDonor(@RequestBody newDonor: Donor): Donor = donorService.addNewDonor(newDonor)
}