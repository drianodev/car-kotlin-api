package br.com.drianodev.car.interfaces

import br.com.drianodev.car.domain.TravelRequestInput
import br.com.drianodev.car.domain.TravelRequestOutput
import br.com.drianodev.car.service.TravelService
import br.com.drianodev.car.mapping.TravelRequestMapper
import org.springframework.hateoas.EntityModel
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Service
@RestController
@RequestMapping(path = ["/travelRequests"], produces = [MediaType.APPLICATION_JSON_VALUE])
class TravelRequestAPI(
    val travelService: TravelService,
    val mapper: TravelRequestMapper
) {

    @PostMapping
    fun makeTravelRequest(@RequestBody travelRequestInput: TravelRequestInput): EntityModel<TravelRequestOutput> {
        val travelRequest = travelService.saveTravelRequest(mapper.map(travelRequestInput))
        val output = mapper.map(travelRequest)
        return mapper.buildOutputModel(travelRequest, output)
    }
}