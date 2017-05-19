package com.construction.logic;

import com.construction.dto.Gender;
import com.construction.dto.ParticipantDto;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class MatchingLogic {

    public void executeMatching(List<ParticipantDto> participants) {
        Map<Gender, List<ParticipantDto>> genderMap = participants.stream().collect(Collectors.toMap());
    }


}
