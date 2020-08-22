package readability.formulas;

public class FKFormula extends Formula {
    public FKFormula() {
        name = "Flesch–kincaid readability tests";

        K_1 = 0.39;
        K_2 = 11.8;
        K_3 = 15.59;
    }

    @Override
    public void setParams(long characters, long words, long sentences, long syllables, long polysyllables) {
        super.words = words;
        super.sentences = sentences;
        super.syllables = syllables;
    }

    @Override
    public double getScore() {
        return K_1 * words / sentences + K_2 * syllables / words - K_3;
    }
}