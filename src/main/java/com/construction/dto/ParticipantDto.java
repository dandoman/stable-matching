package com.construction.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString(of = {"id", "name", "gender"})
@EqualsAndHashCode(of = "id")
public class ParticipantDto {
    private UUID id;
    private String name;
    private Gender gender;
    private List<ParticipantDto> preferences;
}
