package com;


import com.construction.dto.Gender;
import com.construction.dto.ParticipantDto;
import com.construction.logic.MatchingLogic;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MatchLogicTest {

    private MatchingLogic matchLogic = new MatchingLogic();
    private List<ParticipantDto> participants;

    @Before
    public void before() {
        ParticipantDto man1 = new ParticipantDto(){{
            setName("Dave");
            setGender(Gender.MALE);
            setId(UUID.randomUUID());
        }};

        ParticipantDto man2 = new ParticipantDto(){{
            setName("Richard");
            setGender(Gender.MALE);
            setId(UUID.randomUUID());
        }};

        ParticipantDto man3 = new ParticipantDto(){{
            setName("Kevin");
            setGender(Gender.MALE);
            setId(UUID.randomUUID());
        }};

        ParticipantDto man4 = new ParticipantDto(){{
            setName("Tim");
            setGender(Gender.MALE);
            setId(UUID.randomUUID());
        }};

        ParticipantDto woman1 = new ParticipantDto(){{
            setName("Leonora");
            setGender(Gender.FEMALE);
            setId(UUID.randomUUID());
        }};

        ParticipantDto woman2 = new ParticipantDto(){{
            setName("Lily");
            setGender(Gender.FEMALE);
            setId(UUID.randomUUID());
        }};

        ParticipantDto woman3 = new ParticipantDto(){{
            setName("Nora");
            setGender(Gender.FEMALE);
            setId(UUID.randomUUID());
        }};

        ParticipantDto woman4 = new ParticipantDto(){{
            setName("Michelle");
            setGender(Gender.FEMALE);
            setId(UUID.randomUUID());
        }};

        man1.setPreferences(new ArrayList<ParticipantDto>(){{
            add(woman1);
            add(woman2);
            add(woman4);
            add(woman3);
        }});

        man2.setPreferences(new ArrayList<ParticipantDto>(){{
            add(woman3);
            add(woman2);
            add(woman4);
            add(woman1);
        }});

        man3.setPreferences(new ArrayList<ParticipantDto>(){{
            add(woman4);
            add(woman2);
            add(woman3);
            add(woman1);
        }});

        man4.setPreferences(new ArrayList<ParticipantDto>(){{
            add(woman1);
            add(woman2);
            add(woman4);
            add(woman3);
        }});

        woman1.setPreferences(new ArrayList<ParticipantDto>(){{
            add(man1);
            add(man2);
            add(man3);
            add(man4);
        }});

        woman2.setPreferences(new ArrayList<ParticipantDto>(){{
            add(man3);
            add(man4);
            add(man2);
            add(man1);
        }});

        woman3.setPreferences(new ArrayList<ParticipantDto>(){{
            add(man1);
            add(man4);
            add(man3);
            add(man2);
        }});

        woman4.setPreferences(new ArrayList<ParticipantDto>(){{
            add(man3);
            add(man1);
            add(man4);
            add(man2);
        }});

        participants = new ArrayList<ParticipantDto>() {{
            add(man1);
            add(man2);
            add(man3);
            add(man4);
            add(woman1);
            add(woman2);
            add(woman3);
            add(woman4);
        }};
    }

    @Test
    public void test() {
        matchLogic.executeMatching(participants);
    }
}
