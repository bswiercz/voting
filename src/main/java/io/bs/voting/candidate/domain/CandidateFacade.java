package io.bs.voting.candidate.domain;

import io.bs.voting.candidate.dto.CandidateDto;


import javax.transaction.Transactional;

import static java.util.Objects.requireNonNull;

@Transactional
public class CandidateFacade {

    private final CandidateRepository candidateRepository;

    private final CandidateCreator candidateCreator;

    public CandidateFacade(CandidateRepository candidateRepository, CandidateCreator candidateCreator) {
        this.candidateRepository = candidateRepository;
        this.candidateCreator = candidateCreator;
    }

    public CandidateDto add(String name) {
        requireNonNull(name);
        Candidate candidate = new Candidate(name, 0);
        candidate = candidateRepository.save(candidate);
        return candidate.toDto();
    }

    public CandidateDto vote(String name) {
        requireNonNull(name);
        Candidate candidate = candidateRepository.getByName(name);
        candidate.vote();
        candidate = candidateRepository.save(candidate);
        return candidate.toDto();
    }

}
