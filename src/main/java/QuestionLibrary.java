import alice.tuprolog.*;
import alice.tuprolog.Number;

import java.io.FileInputStream;
import java.io.IOException;

public class QuestionLibrary extends Library {

    public boolean ask_3(Var x, Var y, Var reply) {
        System.out.println(String.format("%s ta osoba %s? (t/n)", x.getTerm(), y.getTerm()));
        try {
            Retriever.setLink(reply, Term.createTerm("\"n\""));
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean println_1(Var string) {
        System.out.println(string);
        return true;
    }

    public boolean debug_1(Term string) {
        System.out.println(string);
        return true;
    }

    public boolean fancy_print_1(Var string) {
        System.out.println(String.format("Twoja osoba moze byc %s", string));
        return true;
    }

    public static void main(String[] args) throws InvalidLibraryException, IOException, InvalidTheoryException, MalformedGoalException {
        Prolog engine = new Prolog();
        engine.loadLibrary("QuestionLibrary");
        Theory theory = new Theory(new FileInputStream("zgadnij_kto_to_integrated.pl"));
        engine.setTheory(theory);
        engine.solve("wykonaj.");
    }
}
