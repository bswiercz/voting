package io.bs.voting.voter.dto;

public class VoterNotFoundException extends RuntimeException{
    public VoterNotFoundException(String name) {
        super("Not found voter with name: " + name);
    }
}
