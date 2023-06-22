package com.lowgistic.mission.service.conditions.utils;

import com.lowgistic.mission.service.conditions.verifiers.ConditionVerifier;

import java.util.List;

public class VerificationUtilsService<T> {
    public static <T> void verifyConditions(T value, ConditionVerifier<T>... verifiers) {
        for (ConditionVerifier<T> verifier : verifiers) {
            verifier.verify(value);
        }
    }
}

