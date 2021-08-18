package co.petermcguire.spotherotest.spotherotest.controller

import co.petermcguire.spotherotest.spotherotest.model.AddedWorkedHourPeriod
import co.petermcguire.spotherotest.spotherotest.model.WorkedHourPeriod
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post

@SpringBootTest
@AutoConfigureMockMvc
internal class WorkedHourPeriodControllerTest @Autowired constructor(
    val mockMvc: MockMvc,
    val objectMapper: ObjectMapper
) {
    val baseUrl = "/v1/users"

    @Nested
    @DisplayName("GET /v1/users/{id}/worked_hours")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetActiveUsers {
        private val id = 1

        @Test
        fun `should return all worked hour periods for id`() {
            mockMvc.get("$baseUrl/$id/worked_hours")
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$") { isArray() }
                    jsonPath("$[*].id") { exists() }
                    jsonPath("$[*].date") { exists() }
                    jsonPath("$[*].hours") { exists() }
                }
        }
    }

    @Nested
    @DisplayName("POST /v1/users/{id}/worked_hours")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class PostWorkedHourPeriod {

        @Test
        fun `should add a new worked hour period`() {
            val id = 1
            val newPeriod = AddedWorkedHourPeriod("2021-01-11", 5.21)

            val performPost = mockMvc.post("$baseUrl/$id/worked_hours") {
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(newPeriod)
            }

            performPost
                .andDo { print() }
                .andExpect {
                    status { isCreated() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                }

            mockMvc.get("$baseUrl/$id/worked_hours")
                .andDo { print() }
                .andExpect {
                    // When this assert fails, it's not at exists but at the JSON expression match.
                    // This isn't ideal but does function for the test.
                    jsonPath("$[?(@.id==$id && @.date==\"${newPeriod.date}\" && @.hours==\"${newPeriod.hours}\")]") {
                        exists()
                    }
                }
        }
    }
}



