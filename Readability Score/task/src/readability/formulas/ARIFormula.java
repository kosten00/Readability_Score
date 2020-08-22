package readability.formulas;

public class ARIFormula extends Formula {
    public ARIFormula() {
        name = "Automated Readability Index";

        K_1 = 4.71;
        K_2 = 0.5;
        K_3 = 21.43;
    }

    @Override
    public void setParams(long characters, long words, long sentences, long syllables, long polysyllables) {
        super.letters = characters;
        super.words = words;
        super.sentences = sentences;
    }

    @Override
    public double getScore() {
        return K_1 * ((double) letters / words) + K_2 * ((double) words / sentences) - K_3;
    }
}
