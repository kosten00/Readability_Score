package readability;

import readability.formulas.ARIFormula;
import readability.formulas.CLFormula;
import readability.formulas.FKFormula;
import readability.formulas.SMOGFormula;
import readability.scorer.ReadabilityScorer;

public class ReadabilityAnalyzer {
    private final ReadabilityScorer rs;

    public ReadabilityAnalyzer(String text) {
        rs = new ReadabilityScorer(text);
    }

    public void printTextStats() {
        System.out.println(rs.getTextStats());
        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
    }

    public void printScore(String formula) {
        switch (formula) {
            case "ARI":
                rs.printScore(new ARIFormula());
                break;
            case "FK":
                rs.printScore(new FKFormula());
                break;
            case "SMOG":
                rs.printScore(new SMOGFormula());
                break;
            case "CL":
                rs.printScore(new CLFormula());
                break;
            case "all":
                rs.printScore(new ARIFormula(), new FKFormula(), new SMOGFormula(), new CLFormula());
                break;
            default:
                System.out.println("Incorrect input!");
                break;
        }
    }
}
