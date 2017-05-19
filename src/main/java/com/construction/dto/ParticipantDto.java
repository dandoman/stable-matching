package com.construction.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ParticipantDto {
    private UUID id;
    private String name;
    private Gender gender;
    private List<ParticipantDto> preferences;
}
