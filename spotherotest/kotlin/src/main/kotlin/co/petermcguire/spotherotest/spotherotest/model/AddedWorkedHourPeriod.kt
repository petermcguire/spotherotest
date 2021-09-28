package co.petermcguire.spotherotest.spotherotest.model

import java.io.Serializable
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.Max
import javax.validation.constraints.Positive

// Class to accommodate composite primary key
class AddWorkedHourPeriodKey (
    @Column(name = "user_id")
    val id: Long = -1,
    val date: LocalDate = LocalDate.now(),
): Serializable

// POST model
@Entity
@IdClass(AddWorkedHourPeriodKey::class)
@Table(name = "worked_hours")
data class AddWorkedHourPeriod(
    @Id
    val id: Long,
    @Id
    val date: LocalDate,
    @field:Positive
    @field:Max(24)
    val hours: Double,
)

// GET model
data class AddedWorkedHourPeriod(
    val date: String,
    val hours: Double
)