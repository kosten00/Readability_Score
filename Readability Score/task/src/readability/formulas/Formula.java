package readability.formulas;

import readability.interfaces.ReadabilityFormula;

public abstract class Formula implements ReadabilityFormula {
    protected String name;

    protected long letters;
    protected long sentences;
    protected long words;
    protected long syllables;
    protected long polysyllables;

    protected double K_1;
    protected double K_2;
    protected double K_3;

    @Override
    public String getName() {
        return name;
    }
}
