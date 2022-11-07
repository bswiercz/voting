package io.bs.voting.voter.domain;


class VoterConfiguration {
    VoterFacade voterFacade() {
        return voterFacade(new InMemoryVoterRepository());
    }

    VoterFacade voterFacade(VoterRepository voterRepository) {
        return new VoterFacade(voterRepository);
    }
}
