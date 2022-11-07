package io.bs.voting.voter.domain;

import io.bs.voting.voter.dto.VoterNotFoundException;
import org.springframework.data.repository.Repository;

import java.util.Optional;

interface VoterRepository extends Repository<Voter,String> {
    Optional<Voter> findByName(String name);
    Voter save(Voter voter);

    default Voter getByName(String name) {
        return findByName(name).orElseThrow(
                () -> new VoterNotFoundException(name)
        );
    }
}
