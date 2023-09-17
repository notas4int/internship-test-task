package com.artem.projects.internshiptesttask.services;

import com.artem.projects.internshiptesttask.dtos.FrequencyResponse;
import com.artem.projects.internshiptesttask.exceptions.InputStringEmptyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StringService {

    public FrequencyResponse calculateFrequencyOfCharacterOccurrenceByGivenString(String string) {
        if (string == null || string.isEmpty())
            throw new InputStringEmptyException("The entered string cannot be empty");

        Map<Character, Integer> frequencyOfCharacters = new HashMap<>();
        for (char sym : string.toCharArray()) {
            if (frequencyOfCharacters.computeIfPresent(sym, (key, value) -> value + 1) == null) {
                frequencyOfCharacters.put(sym, 1);
            }
        }

        if (frequencyOfCharacters.size() > 1) {
            frequencyOfCharacters = frequencyOfCharacters.entrySet().stream()
                    .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (e1, e2) -> e1, LinkedHashMap::new));
        }

        return new FrequencyResponse(frequencyOfCharacters);
    }
}
