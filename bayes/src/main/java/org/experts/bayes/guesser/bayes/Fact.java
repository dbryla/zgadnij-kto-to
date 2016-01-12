package org.experts.bayes.guesser.bayes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Fact {
    private final String nodeId;
    private final String name;
}
