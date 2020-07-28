package com.martinmachava.blooddonation.backend

import com.martinmachava.blooddonation.backend.donors.Donor
import com.martinmachava.blooddonation.backend.donors.DonorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.util.Collections

@Service
class UserDetailsServiceImpl: UserDetailsService {
    @Autowired
    lateinit var donorService: DonorService

    override fun loadUserByUsername(email: String): UserDetails {
        val user = donorService.getDonorByEmail(email)
        return MyUserPrincipal(user)
    }
}

class MyUserPrincipal(val user: Donor): UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = Collections.emptySet()

    override fun isEnabled(): Boolean = true

    override fun getUsername(): String = "${user.firstName} ${user.lastName}"

    override fun isCredentialsNonExpired(): Boolean = true

    override fun getPassword(): String = user.password

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true
}
