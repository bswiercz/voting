package io.bs.voting.candidate.dto;

public class CandidateNotFoundException extends RuntimeException{
    public CandidateNotFoundException(String name) {
        super("No candidate of name " + name + " found");
    }
}
