package readability.formulas;

public class CLFormula extends Formula {
    public CLFormula() {
        name = "Coleman–liau index";

        K_1 = 0.0588;
        K_2 = 0.296;
        K_3 = 15.8;
    }

    @Override
    public void setParams(long letters, long words, long sentences, long syllables, long polysyllables) {
        super.letters = letters;
        super.words = words;
        super.sentences = sentences;
    }

    @Override
    public double getScore() {
        return K_1 * letters / words * 100.0 - K_2 * sentences / words * 100.0 - 15.8;
    }
}