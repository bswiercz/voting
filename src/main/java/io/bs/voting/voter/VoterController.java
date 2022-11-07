package io.bs.voting.voter;

import io.bs.voting.voter.domain.VoterFacade;
import io.bs.voting.voter.dto.AddVoterDto;
import io.bs.voting.voter.dto.VoterDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class VoterController {
    private final VoterFacade voterFacade;

    public VoterController(VoterFacade voterFacade) {
        this.voterFacade = voterFacade;
    }

    @PostMapping("voter")
    VoterDto addVoter(AddVoterDto voterDto) {
        return voterFacade.add(voterDto.name());
    }
}
