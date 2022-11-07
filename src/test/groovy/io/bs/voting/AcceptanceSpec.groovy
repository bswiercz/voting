package io.bs.gitlist

import io.bs.voting.IntegrationSpec
import io.bs.voting.candidate.domain.CandidateFacade
import io.bs.voting.voter.domain.VoterFacade
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.ResultActions

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class AcceptanceSpec extends IntegrationSpec {
    @Autowired
    CandidateFacade candidateFacade
    @Autowired
    VoterFacade voterFacade

    def "successful add candidate"() {
        when:
        ResultActions addCandidate = mockMvc.perform(post("/candidate")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))

        then:
        addCandidate.andExpect( status().is2xxSuccessful() )
    }

    def "successful cast vote"() {
        given:
        candidateFacade.add("kandydat")
        voterFacade.add("glosujacy")

        when:
        ResultActions castVote = mockMvc.perform(post("/vote")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"whoAmI\":\"glosujacy\",\"whoIVoteFor\":\"kandydat\"}"))

        then:
        castVote.andExpect( status().is2xxSuccessful() )
    }
}
