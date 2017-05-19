package com.construction.logic;

import com.construction.dto.Gender;
import com.construction.dto.ParticipantDto;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class MatchingLogic {

    public void executeMatching(List<ParticipantDto> participants) {
        Random rng = new Random();
        Map<Gender, List<ParticipantDto>> genderMap = participants.stream().collect(Collectors.groupingBy(x -> x.getGender()));
        List<ParticipantDto> men = genderMap.get(Gender.MALE);
        List<UUID> remainingMen = men.stream().map(m -> m.getId()).collect(Collectors.toList()); //copy the list
        remainingMen = remainingMen.stream().sorted((x,y) -> rng.nextInt(1000) < 500 ? -1 : 1).collect(Collectors.toList()); //randomize
        List<ParticipantDto> women = genderMap.get(Gender.FEMALE);
        Map<UUID, List<UUID>> proposals = new HashMap<>();
        Map<UUID, UUID> menToWomenMatching = new HashMap<>();
        while(!remainingMen.isEmpty()) {
            UUID man = remainingMen.get(0); //top of the list
            UUID woman = getHighestRankedNotProposed(man, proposals);
            Optional<Map.Entry<UUID, UUID>> match = menToWomenMatching.entrySet().stream().filter(e -> e.getValue().equals(woman)).findAny();
            if(match.isPresent()) {

            } else {
                //Shes free
                menToWomenMatching.put(man, woman);
                addProposal(man, woman, proposals);
            }
        }

    }

    private void addProposal(UUID man, UUID woman, Map<UUID, List<UUID>> proposals) {
        
    }

    private UUID getHighestRankedNotProposed(UUID man, Map<UUID, List<UUID>> proposals) {
        return null;
    }


}
