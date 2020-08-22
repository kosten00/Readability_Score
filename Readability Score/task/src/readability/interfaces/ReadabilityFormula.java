package readability.interfaces;

public interface ReadabilityFormula {
    void setParams(long letters, long words, long sentences, long syllables, long polysyllables);

    double getScore();

    String getName();
}