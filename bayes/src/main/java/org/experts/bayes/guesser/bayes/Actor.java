package org.experts.bayes.guesser.bayes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class Actor {
    private final String nodeId;
    private final String name;
    @Setter
    private double probability;
}
