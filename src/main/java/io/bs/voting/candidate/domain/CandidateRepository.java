package io.bs.voting.candidate.domain;

import io.bs.voting.candidate.dto.CandidateNotFoundException;
import org.springframework.data.repository.Repository;

import java.util.Optional;

interface CandidateRepository extends Repository<Candidate,String> {
    Optional<Candidate> findByName(String name);
    Candidate save(Candidate candidate);

    default Candidate getByName(String name) {
        return findByName(name).orElseThrow(
                () -> new CandidateNotFoundException(name)
        );
    }
}
