package org.experts.guesser.gui;

import org.experts.guesser.App;

import javax.swing.*;
import java.awt.*;

/**
 * Created by anna on 25.11.15.
 */
public class MainWindow extends JFrame {

    private static final String YES = "Tak";
    private static final String NO = "Nie";
    private static final String TITLE = "Zgadnij kto to";

    private JLabel displayLabel;
    private JButton yesButton;
    private JButton noButton;
    private String answer;

    public MainWindow(){
        init();
        initComponents();
        addButtonListeners();
    }

    private void init() {
        setTitle(TITLE);
        setSize(350, 150);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void initComponents() {
        Box mainContainer = new Box(BoxLayout.Y_AXIS);
        mainContainer.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        mainContainer.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        JPanel panel  = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        yesButton = new JButton(YES);
        noButton = new JButton(NO);

        JPanel buttonPanel  = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(yesButton);
        buttonPanel.add(Box.createGlue());
        buttonPanel.add(noButton);

        JPanel questionPanel  = new JPanel();
        displayLabel = new JLabel("");
        questionPanel.add(displayLabel);

        this.add(mainContainer);
        mainContainer.add(Box.createVerticalGlue());
        mainContainer.add(panel);
        mainContainer.add(Box.createVerticalGlue());
        panel.add(questionPanel);
        panel.add(Box.createGlue());
        panel.add(buttonPanel);
        panel.setVisible(true);
    }

    private void addButtonListeners() {
        yesButton.addActionListener(actionEvent -> answer = "t");
        noButton.addActionListener(actionEvent -> answer = "n");
    }

    public void updateLabel(String string) {
        answer = null;
        displayLabel.setText(App.changeFirstLetterToUpperCase(string.replace("'", "").replace("_", " ")));
    }

    public String getAnswer() {
        while(answer == null){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return answer;
    }
}
