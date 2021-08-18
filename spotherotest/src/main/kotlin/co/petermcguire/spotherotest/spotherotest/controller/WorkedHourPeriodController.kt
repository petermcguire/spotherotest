package co.petermcguire.spotherotest.spotherotest.controller

import co.petermcguire.spotherotest.spotherotest.model.AddWorkedHourPeriod
import co.petermcguire.spotherotest.spotherotest.model.AddedWorkedHourPeriod
import co.petermcguire.spotherotest.spotherotest.model.WorkedHourPeriod
import co.petermcguire.spotherotest.spotherotest.service.WorkedHourPeriodService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/users")
class WorkedHourPeriodController {

    @Autowired
    lateinit var workedHourPeriodService: WorkedHourPeriodService

    @GetMapping("/{id}/worked_hours")
    fun getWorkedHourPeriods(@PathVariable id: Long): Collection<WorkedHourPeriod> =
        workedHourPeriodService.getWorkedHourPeriods(id)

    @PostMapping("/{id}/worked_hours")
    @ResponseStatus(HttpStatus.CREATED)
    fun postWorkedHourPeriod(
        @PathVariable id: Long,
        @RequestBody addedWorkedHourPeriod: AddedWorkedHourPeriod
    ): AddWorkedHourPeriod = workedHourPeriodService.postWorkedHourPeriod(id, addedWorkedHourPeriod)
}


