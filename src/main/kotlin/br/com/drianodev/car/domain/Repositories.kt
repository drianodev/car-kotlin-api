package br.com.drianodev.car.domain

import org.springframework.data.jpa.repository.JpaRepository

interface DriverRepository: JpaRepository<Driver, Long>