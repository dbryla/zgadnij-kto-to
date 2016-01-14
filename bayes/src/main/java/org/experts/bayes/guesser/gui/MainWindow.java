package org.experts.bayes.guesser.gui;

import org.experts.bayes.guesser.bayes.Actor;
import org.experts.bayes.guesser.bayes.Fact;
import org.experts.bayes.guesser.bayes.GuessWhoNetwork;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

/**
 * Created by anna on 14.01.16.
 */
public class MainWindow extends JFrame {

    private static final String TITLE = "Zgadnij kto to";
    private static final String YES = "Tak";
    private static final String DONT_KNOW = "Nie wiem";
    private static final String NO = "Nie";
    private static final String OK = "OK";

    private JButton okButton;
    private JLabel questionLabel;
    private ButtonGroup buttonGroup;
    private JRadioButton yesRadioButton;
    private JRadioButton dontKnowRadioButton;
    private JRadioButton noRadioButton;

    private GuessWhoNetwork network;
    private Fact currentFact;
    private Iterator<Fact> iterator;

    public MainWindow(GuessWhoNetwork network){
        this.network = network;
        this.iterator = network.getAllFacts().iterator();
        this.currentFact = iterator.hasNext() ? iterator.next() : null;
        init();
        initComponents();
        addButtonListeners();
        setVisible(true);
    }

    private void init() {
        setTitle(TITLE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void initComponents() {
        okButton = new JButton(OK);
        questionLabel = new JLabel(currentFact != null ? currentFact.getName() : "Brak faktów");

        yesRadioButton = new JRadioButton(YES);
        yesRadioButton.setSelected(true);
        yesRadioButton.setActionCommand(YES);
        dontKnowRadioButton = new JRadioButton(DONT_KNOW);
        dontKnowRadioButton.setActionCommand(DONT_KNOW);
        noRadioButton = new JRadioButton(NO);
        noRadioButton.setActionCommand(NO);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(yesRadioButton);
        buttonGroup.add(dontKnowRadioButton);
        buttonGroup.add(noRadioButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(2, 2, 2, 2);

        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 1;
        mainPanel.add(questionLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        mainPanel.add(yesRadioButton, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        mainPanel.add(dontKnowRadioButton, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        mainPanel.add(noRadioButton, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 1;
        mainPanel.add(okButton, gbc);

        add(mainPanel);
    }

    private void addButtonListeners() {
        okButton.addActionListener(event -> {
            switch (buttonGroup.getSelection().getActionCommand()){
                case YES:
                    network.setFactForTrue(currentFact);
                    break;
                case NO:
                    network.setFactForTrue(currentFact);
                    break;
                case DONT_KNOW:
                    network.setFactForUnknown(currentFact);
                    break;
                default:
                    break;

            }
            if(iterator.hasNext()){
                currentFact = iterator.next();
                questionLabel.setText(currentFact.getName());
            }
            else{
                double maxProbability = -0.1f;
                Actor mostSuitableActor = null;
                for (Actor actor : network.getAllActors()) {
                    if(actor.getProbability() > maxProbability){
                        maxProbability = actor.getProbability();
                        mostSuitableActor = actor;
                    }
                }

                String label = mostSuitableActor != null ? mostSuitableActor.getName() : "Brak odpowiedniej osoby";
                questionLabel.setText(label);
                okButton.setVisible(false);
                yesRadioButton.setVisible(false);
                dontKnowRadioButton.setVisible(false);
                noRadioButton.setVisible(false);

                network.clearAllFacts();
            }
        });
    }
}
