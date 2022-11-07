package io.bs.voting.candidate;

import io.bs.voting.candidate.domain.CandidateFacade;
import io.bs.voting.candidate.dto.AddCandidateDto;
import io.bs.voting.candidate.dto.CandidateDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class CandidateController {
    private final CandidateFacade candidateFacade;

    public CandidateController(CandidateFacade candidateFacade) {
        this.candidateFacade = candidateFacade;
    }

    @PostMapping("candidate")
    CandidateDto addCandidate(AddCandidateDto addCandidateDto) {
        return candidateFacade.add(addCandidateDto.name());
    }
}
