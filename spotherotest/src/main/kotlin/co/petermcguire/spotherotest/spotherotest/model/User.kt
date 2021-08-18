package co.petermcguire.spotherotest.spotherotest.model

import javax.persistence.*

@Entity
@Table(name = "users")
data class User (
    @Id
    val id: Int,
    val first_name: String,
    val last_name: String,
    val email: String,
)