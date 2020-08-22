package readability.formulas;

public class SMOGFormula extends Formula {
    public SMOGFormula() {
        name = "Simple Measure of Gobbledygook";

        K_1 = 1.043;
        K_2 = 30.0;
        K_3 = 3.1291;
    }

    @Override
    public void setParams(long characters, long words, long sentences, long syllables, long polysyllables) {
        this.sentences = sentences;
        this.polysyllables = polysyllables;
    }

    @Override
    public double getScore() {
        return K_1 * Math.sqrt(polysyllables * (K_2 / sentences)) + K_3;
    }
}
