package br.com.drianodev.car.service

import br.com.drianodev.car.domain.TravelRequest
import br.com.drianodev.car.domain.TravelRequestRepository
import org.springframework.stereotype.Component

@Component
class TravelService(
    val travelRequestRepository: TravelRequestRepository
) {

    fun saveTravelRequest(travelRequest: TravelRequest) = travelRequestRepository.save(travelRequest)
}