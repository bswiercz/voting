package io.bs.voting.voter.domain;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class VoterConfiguration {
    VoterFacade voterFacade() {
        return voterFacade(new InMemoryVoterRepository());
    }

    @Bean
    VoterFacade voterFacade(VoterRepository voterRepository) {
        return new VoterFacade(voterRepository);
    }
}
