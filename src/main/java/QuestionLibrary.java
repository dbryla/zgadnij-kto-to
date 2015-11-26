import alice.tuprolog.*;

import java.io.*;

public class QuestionLibrary extends Library {

    private static MainWindow mainWindow;

    public boolean ask_3(Var x, Var y, Var reply) {
        mainWindow.updateLabel(String.format("<html>%s ta osoba<br> %s?", x.getTerm(), y.getTerm()));
        Retriever.setLink(reply, Term.createTerm(mainWindow.getAnswer()));
        return true;
    }

    public boolean println_1(Var var) {
        System.out.println(var.getTerm());
        mainWindow.updateLabel(String.format("%s", var.getTerm()));
        return true;
    }

    public boolean debug_1(Term string) {
        System.out.println(string);
        return true;
    }

    public boolean fancy_print_1(Var var) {
        System.out.println(String.format("Twoja osoba moze byc %s", var.getTerm()));
        mainWindow.updateLabel(String.format("<html>Twoja osoba moze byc<br> %s", var.getTerm()));
        return true;
    }

    public static void main(String[] args) throws InvalidLibraryException, IOException, InvalidTheoryException, MalformedGoalException {
        mainWindow = new MainWindow();
        Prolog engine = new Prolog();
        engine.loadLibrary("QuestionLibrary");
        Theory theory = new Theory(new FileInputStream("zgadnij_kto_to_integrated.pl"));
        engine.setTheory(theory);
        engine.solve("wykonaj.");
    }
}
