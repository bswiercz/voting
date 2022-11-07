package io.bs.voting.candidate.domain;

import org.springframework.context.annotation.Configuration;

@Configuration
class CandidateConfiguration {
    CandidateFacade candidateFacade() {
        return candidateFacade(new InMemoryCandidateRepository());
    }

    CandidateFacade candidateFacade(CandidateRepository candidateRepository) {
        CandidateCreator candidateCreator = new CandidateCreator();
        return new CandidateFacade(candidateRepository, candidateCreator);
    }
}
