package com.artem.projects.internshiptesttask.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class FrequencyResponse {
    private Map<Character, Integer> frequencyOfCharacters;
}
