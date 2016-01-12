package alice.tuprolog;

public abstract class Retriever {

    public static void setLink(Var var, Term term) {
        var.setLink(term);
    }
}
