package co.petermcguire.spotherotest.spotherotest.controller

import co.petermcguire.spotherotest.spotherotest.model.AddWorkedHourPeriod
import co.petermcguire.spotherotest.spotherotest.model.AddedWorkedHourPeriod
import co.petermcguire.spotherotest.spotherotest.model.WorkedHourPeriod
import co.petermcguire.spotherotest.spotherotest.service.WorkedHourPeriodService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.ConstraintViolationException
import javax.validation.Valid

data class ApiError(
    var status: HttpStatus,
    var clientMessage: String,
    var errors: List<String>,
    var developerMessage: String? = null
){
    constructor(status: HttpStatus, clientMessage: String, error: String, developerMessage: String? = null) :
            this(status, clientMessage, arrayListOf<String>(error), developerMessage)
}

@RestController
@RequestMapping("/v1/users")
class WorkedHourPeriodController {

    @ExceptionHandler(ConstraintViolationException::class)
    fun handleConstraintViolation(ex: ConstraintViolationException): ResponseEntity<Any> {
        val errors = mutableListOf<String>()
        ex.constraintViolations.forEach { errors.add("$it.rootBeanClass.name $it.propertyPath: $it.message") }
        val apiError = ApiError(HttpStatus.BAD_REQUEST, ex.localizedMessage, errors)
        return ResponseEntity(apiError, HttpHeaders(), apiError.status)
    }

    @Autowired
    lateinit var workedHourPeriodService: WorkedHourPeriodService

    @GetMapping("/{id}/worked_hours")
    fun getWorkedHourPeriods(@PathVariable id: Long): Collection<WorkedHourPeriod> =
        workedHourPeriodService.getWorkedHourPeriods(id)

    @PostMapping("/{id}/worked_hours")
    @ResponseStatus(HttpStatus.CREATED)
    fun postWorkedHourPeriod(
        @PathVariable id: Long,
        @Valid @RequestBody addedWorkedHourPeriod: AddedWorkedHourPeriod
    ): AddWorkedHourPeriod = workedHourPeriodService.postWorkedHourPeriod(id, addedWorkedHourPeriod)

}


