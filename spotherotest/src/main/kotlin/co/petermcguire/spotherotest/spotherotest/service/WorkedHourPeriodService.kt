package co.petermcguire.spotherotest.spotherotest.service

import co.petermcguire.spotherotest.spotherotest.datasource.AddWorkedPeriodDataSource
import co.petermcguire.spotherotest.spotherotest.datasource.WorkedHourPeriodDataSource
import co.petermcguire.spotherotest.spotherotest.model.AddWorkedHourPeriod
import co.petermcguire.spotherotest.spotherotest.model.AddedWorkedHourPeriod
import co.petermcguire.spotherotest.spotherotest.model.WorkedHourPeriod
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class WorkedHourPeriodService {

    @Autowired
    lateinit var workedHourPeriodDataSource: WorkedHourPeriodDataSource

    @Autowired
    lateinit var addWorkedPeriodDataSource: AddWorkedPeriodDataSource
    fun getWorkedHourPeriods(id: Long): Collection<WorkedHourPeriod> = workedHourPeriodDataSource.findAllById(id)
    // NOTE:  It's not clear from the requirements whether an attempted POST with key already existing should
    // update or not, assuming update which is the default save functionality.
    fun postWorkedHourPeriod(id: Long, addedWorkedHourPeriod: AddedWorkedHourPeriod): AddWorkedHourPeriod =
        addWorkedPeriodDataSource.save(AddWorkedHourPeriod(id, LocalDate.parse(addedWorkedHourPeriod.date), addedWorkedHourPeriod.hours))
}