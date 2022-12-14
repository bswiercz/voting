package io.bs.voting.candidate.domain;

import io.bs.voting.candidate.dto.CandidateDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
class Candidate {
    @Id
    private String name;
    private Integer votes;

    CandidateDto toDto() {
        return new CandidateDto(name, votes);
    }

    void vote() {
        votes++;
    }
}
