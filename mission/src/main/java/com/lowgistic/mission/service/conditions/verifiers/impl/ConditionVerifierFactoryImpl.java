package com.lowgistic.mission.service.conditions.verifiers.impl;

import com.lowgistic.mission.service.conditions.verifiers.ConditionVerifier;
import com.lowgistic.mission.service.conditions.verifiers.ConditionVerifierFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ConditionVerifierFactoryImpl implements ConditionVerifierFactory {

    private final Map<Class<?>, ConditionVerifier<?>> verifierMap;

    public ConditionVerifierFactoryImpl(List<ConditionVerifier<?>> verifiers) {
        verifierMap = new HashMap<>();
        for (ConditionVerifier<?> verifier : verifiers) {
            verifierMap.put(verifier.getClass(), verifier);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> ConditionVerifier<T> getVerifier(Class<? extends ConditionVerifier<T>> verifierClass) {
        ConditionVerifier<?> verifier = verifierMap.get(verifierClass);
        if (verifier == null) {
            throw new IllegalArgumentException("No verifier found for class: " + verifierClass.getName());
        }
        return (ConditionVerifier<T>) verifier;
    }
}
