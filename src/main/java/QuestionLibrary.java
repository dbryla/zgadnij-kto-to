import alice.tuprolog.InvalidLibraryException;
import alice.tuprolog.InvalidTheoryException;
import alice.tuprolog.Library;
import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.Prolog;
import alice.tuprolog.Term;
import alice.tuprolog.Theory;
import alice.tuprolog.Var;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class QuestionLibrary extends Library {

    public boolean ask_3(Var x, Var y, Term reply) {
        System.out.println(String.format("%s ta osoba %s? (t/n)", x.getTerm(), y.getTerm()));
        try {
            char c = (char) System.in.read();
            reply = Term.createTerm("t");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean println_1(Term string) {
        System.out.println(string);
        return true;
    }

    public boolean fancy_print_2(Term format, Term string) {
        System.out.println(String.format(String.valueOf(format), string.getTerm()));
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
