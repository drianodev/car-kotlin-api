package br.com.drianodev.car.domain

import br.com.drianodev.car.enumeration.TravelRequestStatus
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
data class Driver(
    @Id
    @GeneratedValue
    var id: Long? = null,
    val name: String,
    val birthDate: LocalDate
)

data class PatchDriver(
    val name: String?,
    val birthDate: LocalDate?
)

@Entity
data class Passenger(
    @Id
    @GeneratedValue
    var id: Long? = null,
    val name: String
)

data class PatchPassenger(
    val name: String?
)

@Entity
data class TravelRequest (
    @Id
    @GeneratedValue
    var id: Long? = null,

    @ManyToOne
    val passenger: Passenger,
    val origin: String,
    val destination: String,
    val status: TravelRequestStatus = TravelRequestStatus.CREATED,
    val creationDate: LocalDateTime = LocalDateTime.now()
)

data class TravelRequestInput(
    val passengerId: Long,
    val origin: String,
    val destination: String
)

data class TravelRequestOutput (
    var id: Long,
    val origin: String,
    val destination: String,
    val status: TravelRequestStatus,
    val creationDate: LocalDateTime
)