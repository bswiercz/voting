package io.bs.voting

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc

import spock.lang.Specification

@SpringBootTest(classes = [Voting])
@AutoConfigureMockMvc
abstract class IntegrationSpec extends Specification {
    @Autowired
    MockMvc mockMvc
}
