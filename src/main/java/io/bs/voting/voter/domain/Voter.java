package io.bs.voting.voter.domain;

import io.bs.voting.candidate.dto.CandidateDto;
import io.bs.voting.voter.dto.VoterAlreadyVotedException;
import io.bs.voting.voter.dto.VoterDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
class Voter {
    @Id
    private String name;
    private Boolean hasVoted;

    VoterDto toDto() {
        return new VoterDto(name, hasVoted);
    }

    Boolean voteOrElseThrow() {
        if(hasVoted) throw new VoterAlreadyVotedException(name);
        else {
            hasVoted = Boolean.TRUE;
            return hasVoted;
        }
    }
}
