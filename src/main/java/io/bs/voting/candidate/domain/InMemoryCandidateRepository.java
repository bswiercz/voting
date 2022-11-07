package io.bs.voting.candidate.domain;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

class InMemoryCandidateRepository implements CandidateRepository {
    private ConcurrentHashMap<String, Candidate> map = new ConcurrentHashMap<>();

    @Override
    public Candidate save(Candidate candidate) {
        map.put(candidate.toDto().name(), candidate);
        return candidate;
    }

    @Override
    public Optional<Candidate> findByName(String name) {
        return Optional.ofNullable(map.get(name));
    }
}
