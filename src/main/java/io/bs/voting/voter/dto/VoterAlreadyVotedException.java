package io.bs.voting.voter.dto;

public class VoterAlreadyVotedException extends RuntimeException{
    public VoterAlreadyVotedException(String name) {
        super("Voter " + name + " has already voted");
    }
}
