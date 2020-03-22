package com.martinmachava.blooddonation.backend.donor

import com.neovisionaries.i18n.CountryCode
import org.springframework.stereotype.Service

interface AddressService {
    fun getCountryEnumByAlpha2(code: String): CountryCode

    fun getCountryEnumByAlpha3(code: String): CountryCode
}

@Service
class AddressServiceImpl: AddressService {

    override fun getCountryEnumByAlpha2(code: String): CountryCode = CountryCode.getByAlpha2Code(code)

    override fun getCountryEnumByAlpha3(code: String): CountryCode = CountryCode.getByAlpha3Code(code)
}