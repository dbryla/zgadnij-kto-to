package org.experts.bayes.guesser;

import org.experts.bayes.guesser.bayes.Fact;
import org.experts.bayes.guesser.bayes.GuessWhoNetwork;
import org.experts.bayes.guesser.bayes.JSmileGuessWhoNetwork;

import java.io.File;
import java.util.List;

public class App {

    public static final String NETWORK_FILE = "bayes_network.xdsl";
    public static final String NETWORK_PATH = String.format("%s%sbayes%s%s",
                                                    System.getProperty("user.dir"),
                                                    File.separator,
                                                    File.separator,
                                                    NETWORK_FILE);

    private static GuessWhoNetwork network;

    public static void main(String[] args) {
        // Example usage
        GuessWhoNetwork network = new JSmileGuessWhoNetwork(NETWORK_PATH);
        List<Fact> allFacts = network.getAllFacts();
        for (Fact fact: allFacts) {
            if (fact.getName().equals("Gra w Komediach") || fact.getName().equals("Gra w Serialach")) {
                network.setFactForTrue(fact);
            }
            if (fact.getName().equals("Jest czarnym charakterem")) {
                network.setFactForFalse(fact);
            }
        }
        System.out.println(network.getAllActors()); // get the one with the biggest probability or whatever

    }
}
