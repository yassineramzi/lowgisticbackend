package com.lowgistic.mission.service.conditions.verifiers;

public interface ConditionVerifier<T> {
    void verify(T value);
}
