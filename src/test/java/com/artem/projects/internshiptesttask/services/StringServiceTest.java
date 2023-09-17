package com.artem.projects.internshiptesttask.services;


import com.artem.projects.internshiptesttask.dtos.FrequencyResponse;
import com.artem.projects.internshiptesttask.exceptions.InputStringEmptyException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StringServiceTest {
    private StringService stringService;

    @BeforeAll
    void setUp() {
        stringService = new StringService();
    }

    @Test
    void shouldReturnFrequencyResponse_AfterEnterString() {
        String inputString = "aaaaabcccchhjjad";

        Map<Character, Integer> frequencyOfCharacters = new HashMap<>();
        frequencyOfCharacters.put('a', 6);
        frequencyOfCharacters.put('c', 4);
        frequencyOfCharacters.put('h', 2);
        frequencyOfCharacters.put('j', 2);
        frequencyOfCharacters.put('b', 1);
        frequencyOfCharacters.put('d', 1);

        FrequencyResponse resultResponse = new FrequencyResponse(frequencyOfCharacters);
        FrequencyResponse frequencyResponse =
                stringService.calculateFrequencyOfCharacterOccurrenceByGivenString(inputString);

        assertNotNull(frequencyResponse);
        assertEquals(frequencyResponse, resultResponse);
    }

    @Test
    void shouldThrowInputStringEmptyException_IfStringIsNullOrEmpty_AfterGettingFrequencyOfCharacterOccurrence() {
        String emptyString = "";
        String nullString = null;

        RuntimeException e = assertThrows(InputStringEmptyException.class,
                () -> stringService.calculateFrequencyOfCharacterOccurrenceByGivenString(emptyString));
        assertEquals(e.getMessage(), "The entered string cannot be empty");

        RuntimeException e2 = assertThrows(InputStringEmptyException.class,
                () -> stringService.calculateFrequencyOfCharacterOccurrenceByGivenString(nullString));
        assertEquals(e2.getMessage(), "The entered string cannot be empty");
    }
}