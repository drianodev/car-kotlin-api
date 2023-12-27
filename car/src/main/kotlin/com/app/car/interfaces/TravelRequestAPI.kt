package com.app.car.interfaces

import com.app.car.domain.TravelRequest
import com.app.car.domain.TravelService
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Service
@RestController
@RequestMapping(path = ["/travelRequest"], produces = [MediaType.APPLICATION_JSON_VALUE])
class TravelRequestAPI(
    travelService: TravelService
) {

    @PostMapping
    fun makeTravelRequest(@RequestBody travelRequest: TravelRequest) {
        travelService.saveTravelRequest(travelRequest)
    }
}