package io.bs.voting.voter.domain;

import io.bs.voting.voter.dto.VoterDto;

import javax.transaction.Transactional;

import static java.util.Objects.requireNonNull;

@Transactional
public class VoterFacade {
    private final VoterRepository voterRepository;

    public VoterFacade(VoterRepository voterRepository) {
        this.voterRepository = voterRepository;
    }

    public VoterDto add(String name) {
        requireNonNull(name);
        Voter candidate = new Voter(name, Boolean.FALSE);
        candidate = voterRepository.save(candidate);
        return candidate.toDto();
    }

    public VoterDto vote(String name) {
        requireNonNull(name);
        Voter voter = voterRepository.getByName(name);
        voter.voteOrElseThrow();
        voter = voterRepository.save(voter);
        return voter.toDto();
    }
}
