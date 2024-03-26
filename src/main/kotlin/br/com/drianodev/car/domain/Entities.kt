package br.com.drianodev.car.domain

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.LocalDate

@Entity
data class Driver(
    @Id
    var id: Long? = null,
    val name: String,
    val birthDate: LocalDate
)
