package io.bs.gitlist

import io.bs.voting.IntegrationSpec
import io.bs.voting.candidate.domain.CandidateFacade
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.ResultActions

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class AcceptanceSpec extends IntegrationSpec {
    @Autowired
    CandidateFacade candidateFacade

    def "successful add candidate"() {
        when:
        ResultActions getRepositories = mockMvc.perform(get("/users/torvalds/repos"))

        then:
        getRepositories.andExpect( status().isOk() )
                .andExpect(jsonPath("\$[*].name").value(["linux","pesconvert","test-tlb","uemacs"]))
    }

    def "github user not exist scenario"() {
        when: 'I go to /users/thispersondoesnotexist/repos'
        ResultActions getRepositories = mockMvc.perform(get("/users/qdnownfwovcnviueavibunajnnborqdnownfwovcnviueavibunajnnbor/repos"))

        then: 'I get error message'
        getRepositories.andExpect( status().isNotFound() )
    }
}
