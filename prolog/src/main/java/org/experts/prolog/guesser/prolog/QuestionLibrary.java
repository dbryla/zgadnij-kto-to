package org.experts.prolog.guesser.prolog;

import alice.tuprolog.Library;
import alice.tuprolog.Retriever;
import alice.tuprolog.Term;
import alice.tuprolog.Var;
import org.experts.prolog.guesser.App;

import javax.swing.*;

public class QuestionLibrary extends Library {

    public boolean ask_3(Var x, Var y, Var reply) {
        App.mainWindow.updateLabel(String.format("%s ta osoba %s?", x.getTerm(), y.getTerm()));
        Retriever.setLink(reply, Term.createTerm(App.mainWindow.getAnswer()));
        return true;
    }

    public boolean debug_1(Term string) {
        System.out.println(string);
        return true;
    }

    public boolean printLose_0() {
        App.mainWindow.dispose();
        JOptionPane.showMessageDialog(null, "Nie jestem w stanie odgadnać co to za osoba.");
        return true;
    }

    public boolean announcePerson_1(Var var) {
        App.mainWindow.dispose();
        String person = var.getTerm().toString().replace("_", " ");
        JOptionPane.showMessageDialog(null,
                String.format("Twoją osobą może być %s",
                        App.changeFirstLettersToUpperCase(person)));
        System.exit(0);
        return true;
    }

}
