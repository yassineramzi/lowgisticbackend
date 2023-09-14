package com.lowgistic.mission.service.conditions.verifiers.impl;

import com.lowgistic.mission.service.conditions.verifiers.ConditionVerifier;
import com.lowgistic.mission.service.conditions.verifiers.ConditionVerifierFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MissionVerifierFactoryImpl implements ConditionVerifierFactory {

    private final Map<Class<?>, ConditionVerifier<?>> verifierMap;

    @Autowired
    public MissionVerifierFactoryImpl() {
        verifierMap = new HashMap<>();
        verifierMap.put(FreightDateVerifier.class, new FreightDateVerifier());
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
