package org.experts.guesser;

import alice.tuprolog.*;
import org.experts.guesser.gui.MainWindow;
import org.experts.guesser.prolog.QuestionLibrary;

import java.io.FileInputStream;
import java.io.IOException;

public class App {

    public static MainWindow mainWindow;

    private static final String FILE_NAME = "zgadnij_kto_to_integrated.pl";
    private static final String GOAL_NAME = "wykonaj.";

    public static void main(String[] args) throws InvalidLibraryException, IOException,
            InvalidTheoryException, MalformedGoalException {
        mainWindow = new MainWindow();
        Prolog engine = new Prolog();
        engine.loadLibrary(QuestionLibrary.class.getName());
        Theory theory = new Theory(new FileInputStream(FILE_NAME));
        engine.setTheory(theory);
        engine.solve(GOAL_NAME);
    }

    public static String changeFirstLettersToUpperCase(String string) {
        String[] strings = string.split(" ");
        StringBuilder resultString = new StringBuilder();
        for (String s : strings) {
            resultString.append(changeFirstLetterToUpperCase(s));
            resultString.append(" ");
        }
        return resultString.toString();
    }

    public static String changeFirstLetterToUpperCase(String string) {
        return String.valueOf(string.charAt(0)).toUpperCase().concat(string.substring(1));
    }
}
