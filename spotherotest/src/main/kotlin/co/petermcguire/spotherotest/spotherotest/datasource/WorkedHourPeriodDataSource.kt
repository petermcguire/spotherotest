package co.petermcguire.spotherotest.spotherotest.datasource

import co.petermcguire.spotherotest.spotherotest.model.AddWorkedHourPeriod
import co.petermcguire.spotherotest.spotherotest.model.AddWorkedHourPeriodKey
import co.petermcguire.spotherotest.spotherotest.model.WorkedHourPeriod
import co.petermcguire.spotherotest.spotherotest.model.WorkedHourPeriodKey
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

// GET data source
@Repository
interface WorkedHourPeriodDataSource: JpaRepository<WorkedHourPeriod, WorkedHourPeriodKey> {
    fun findAllById(id: Long): Collection<WorkedHourPeriod>
}

// POST data source
@Repository
interface AddWorkedPeriodDataSource: JpaRepository<AddWorkedHourPeriod, AddWorkedHourPeriodKey> {
}