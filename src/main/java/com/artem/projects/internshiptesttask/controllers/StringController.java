package com.artem.projects.internshiptesttask.controllers;

import com.artem.projects.internshiptesttask.dtos.FrequencyResponse;
import com.artem.projects.internshiptesttask.services.StringService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v3")
public class StringController {
    private final StringService stringService;

    @GetMapping(value = {"/get-frequency/{string}", "/get-frequency"})
    public ResponseEntity<FrequencyResponse> getFrequencyOfCharacterOccurrenceByGivenString(@PathVariable(required = false) String string) {
        return ResponseEntity.ok(stringService.calculateFrequencyOfCharacterOccurrenceByGivenString(string));
    }
}
