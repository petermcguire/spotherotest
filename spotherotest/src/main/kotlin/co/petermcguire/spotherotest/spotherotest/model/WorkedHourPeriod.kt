package co.petermcguire.spotherotest.spotherotest.model

import java.io.Serializable
import javax.persistence.*

// Class to accommodate composite primary key
class WorkedHourPeriodKey (
    @Column(name = "user_id")
    val id: Long = -1,
    val date: String = "",
): Serializable

@Entity
@IdClass(WorkedHourPeriodKey::class)
@Table(name = "worked_hours")
data class WorkedHourPeriod (
    @Id
    val id: Long,
    @Id
    val date: String,
    val hours: String,
)
