package org.experts.bayes.guesser.bayes;

import java.util.List;

public interface GuessWhoNetwork {

    List<Fact> getAllFacts();

    List<Actor> getAllActors();

    void setFactForTrue(Fact fact);

    void setFactForFalse(Fact fact);

    void setFactForUnknown(Fact fact);

    void clearAllFacts();

}
