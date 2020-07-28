package com.martinmachava.blooddonation.backend.donors

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/donor")
class DonorController {
    @Autowired
    lateinit var donorService: DonorService

    @GetMapping
    fun getDonor(@RequestParam("email") email: String): DonorView = donorService.getDonorViewByEmail(email)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addDonor(@RequestBody donor: Donor): DonorView = donorService.addDonor(donor)
}
