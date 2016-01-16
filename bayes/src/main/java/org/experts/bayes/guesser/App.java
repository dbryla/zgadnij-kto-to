package org.experts.bayes.guesser;

import org.experts.bayes.guesser.bayes.GuessWhoNetwork;
import org.experts.bayes.guesser.bayes.JSmileGuessWhoNetwork;
import org.experts.bayes.guesser.gui.MainWindow;

import java.io.File;

public class App {

    public static final String NETWORK_FILE = "bayes_network.xdsl";
    public static final String NETWORK_PATH = String.format("%s%sbayes%s%s",
                                                    System.getProperty("user.dir"),
                                                    File.separator,
                                                    File.separator,
                                                    NETWORK_FILE);

    public static void main(String[] args) {
        GuessWhoNetwork network = new JSmileGuessWhoNetwork(NETWORK_PATH);
        new MainWindow(network);
    }
}
