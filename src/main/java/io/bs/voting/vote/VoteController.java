package io.bs.voting.vote;

import io.bs.voting.candidate.domain.CandidateFacade;
import io.bs.voting.vote.dto.CastVoteDto;
import io.bs.voting.voter.domain.VoterFacade;
import io.bs.voting.voter.dto.VoterDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class VoteController {

    private final CandidateFacade candidateFacade;
    private final VoterFacade voterFacade;

    public VoteController(CandidateFacade candidateFacade, VoterFacade voterFacade) {
        this.candidateFacade = candidateFacade;
        this.voterFacade = voterFacade;
    }

    @PostMapping("vote")
    void vote(CastVoteDto castVoteDto) {
        VoterDto canCastVote = voterFacade.vote(castVoteDto.whoAmI());
        candidateFacade.vote(castVoteDto.whoIVoteFor());
    }

}
