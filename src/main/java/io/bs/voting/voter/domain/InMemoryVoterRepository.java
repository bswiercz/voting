package io.bs.voting.voter.domain;

import io.bs.voting.voter.domain.Voter;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

class InMemoryVoterRepository implements VoterRepository{
    private ConcurrentHashMap<String, Voter> map = new ConcurrentHashMap<>();

    @Override
    public Voter save(Voter voter) {
        map.put(voter.toDto().name(), voter);
        return voter;
    }

    @Override
    public Optional<Voter> findByName(String name) {
        return Optional.ofNullable(map.get(name));
    }
}
