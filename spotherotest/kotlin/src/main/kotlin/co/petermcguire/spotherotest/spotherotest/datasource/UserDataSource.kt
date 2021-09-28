package co.petermcguire.spotherotest.spotherotest.datasource

import co.petermcguire.spotherotest.spotherotest.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UserDataSource: JpaRepository<User, Long> {

    // Use of a direct query to table here to avoid adding active to model
    @Query(
        value = "SELECT * FROM users WHERE users.active = true",
        nativeQuery = true
    )
    fun getActiveUsers(): MutableIterable<User>
}