package com.lowgistic.mission.service.conditions.verifiers;

public interface ConditionVerifierFactory {
    <T> ConditionVerifier<T> getVerifier(Class<? extends ConditionVerifier<T>> verifierClass);
}

