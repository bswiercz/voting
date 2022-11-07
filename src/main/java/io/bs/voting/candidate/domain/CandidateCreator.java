package io.bs.voting.candidate.domain;

import io.bs.voting.candidate.dto.CandidateDto;

import static java.util.Objects.requireNonNull;

class CandidateCreator {
    Candidate fromDto(CandidateDto candidateDto) {
        requireNonNull(candidateDto);
        return new Candidate(candidateDto.name(), candidateDto.votes());
    }
}
