package co.petermcguire.spotherotest.spotherotest.service

import co.petermcguire.spotherotest.spotherotest.datasource.UserDataSource
import co.petermcguire.spotherotest.spotherotest.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var dataSource: UserDataSource
    fun getActiveUsers(): MutableIterable<User> = dataSource.getActiveUsers()
}