package co.petermcguire.spotherotest.spotherotest.model

import java.io.Serializable
import java.time.LocalDate
import javax.persistence.*

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
    val hours: Double,
)

// GET model
data class AddedWorkedHourPeriod(
    val date: String,
    val hours: Double
)