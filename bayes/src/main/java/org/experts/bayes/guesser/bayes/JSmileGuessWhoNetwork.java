package org.experts.bayes.guesser.bayes;

import smile.Network;

import java.util.LinkedList;
import java.util.List;

public class JSmileGuessWhoNetwork implements GuessWhoNetwork{

    private static final String FACT_PREFIX = "FACT";
    private static final String TRUE = "Tak";
    private static final int TRUE_INDEX = 0;
    private static final String FALSE = "Nie";
    private Network net;
    private List<Fact> facts;
    private List<Actor> actors;

    public JSmileGuessWhoNetwork(String networkPath) {
        net = new Network();
        net.readFile(networkPath);
        createFactsAndActors();
    }

    private void createFactsAndActors() {
        facts = new LinkedList<>();
        actors = new LinkedList<>();
        for (String nodeId : net.getAllNodeIds()) {
            String nodeName = net.getNodeName(nodeId);
            if(nodeId.startsWith(FACT_PREFIX)) {
                facts.add(new Fact(nodeId, nodeName));
            } else {
                actors.add(new Actor(nodeId, nodeName));
            }
        }
    }

    @Override
    public List<Fact> getAllFacts() {
        return facts;
    }

    @Override
    public List<Actor> getAllActors() {
        net.updateBeliefs();
        for (Actor actor : actors) {
            updateActor(actor);
        }
        return actors;
    }

    private void updateActor(Actor actor) {
        actor.setProbability(net.getNodeValue(actor.getNodeId())[TRUE_INDEX]);
    }

    @Override
    public void setFactForTrue(Fact fact) {
        net.setEvidence(fact.getNodeId(), TRUE);
        net.updateBeliefs();
    }

    @Override
    public void setFactForFalse(Fact fact) {
        net.setEvidence(fact.getNodeId(), FALSE);
        net.updateBeliefs();
    }

    @Override
    public void setFactForUnknown(Fact fact) {
    }

    @Override
    public void clearAllFacts() {
        net.clearAllEvidence();
    }
}
