package com.lowgistic.mission.service.conditions.verifiers.impl;

import com.lowgistic.mission.service.conditions.verifiers.ConditionVerifier;
import com.lowgistic.mission.service.conditions.verifiers.ConditionVerifierFactory;
import com.lowgistic.mission.service.dto.MissionDto;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Stream;

@Component
public class MissionVerifiers {
    private final ConditionVerifierFactory verifierFactory;
    private final ConditionVerifier<MissionDto>[] createVerifiers;
    private final ConditionVerifier<MissionDto>[] updateVerifiers;
    private final ConditionVerifier<MissionDto>[] commonVerifiers;

    public MissionVerifiers(final ConditionVerifierFactory verifierFactory) {
        this.verifierFactory = verifierFactory;
        // Initialize the common conditions
        this.commonVerifiers = new ConditionVerifier[] {
                this.verifierFactory.getVerifier(FreightDateVerifier.class)
        };
        this.createVerifiers = new ConditionVerifier[] {
                this.verifierFactory.getVerifier(FreightDateVerifier.class)
        };
        this.updateVerifiers = new ConditionVerifier[] {
                this.verifierFactory.getVerifier(FreightDateVerifier.class)
        };
    }

    public ConditionVerifier<MissionDto>[] getCreateVerifiers() {
        return mergeVerifiers(createVerifiers,commonVerifiers);
    }

    public ConditionVerifier<MissionDto>[] getUpdateVerifiers() {
        return mergeVerifiers(updateVerifiers,commonVerifiers);
    }

    private static ConditionVerifier<MissionDto>[] apply(int size) {
        return (ConditionVerifier<MissionDto>[]) new ConditionVerifier<?>[size];
    }

    private ConditionVerifier<MissionDto>[] mergeVerifiers(ConditionVerifier<MissionDto>[] verifiers1,
                                                           ConditionVerifier<MissionDto>[] verifiers2) {
        return Stream.concat(Arrays.stream(verifiers1), Arrays.stream(verifiers2)).toArray(MissionVerifiers::apply);
    }
}

