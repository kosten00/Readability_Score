package readability.scorer;

import readability.formulas.Formula;

import java.util.regex.Pattern;

public class ReadabilityScorer {
    private final String text;

    private long words;
    private long sentences;
    private long letters;
    private long syllables;
    private long polysyllables;
    private double avgAge;

    private static final int[] ages = {6, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 24};

    private static final String wordsPattern = "(^|\\s)[\\w]+";
    private static final String sentencePattern = "\\s+[^.!?]*([.!?]|\\z)";

    public ReadabilityScorer(String text) {
        this.text = text;

        getTextStatistics();
    }

    public String getTextStats() {
        return "Words: " + words + System.lineSeparator()
                + "Sentences: " + sentences + System.lineSeparator()
                + "Characters: " + letters + System.lineSeparator()
                + "Syllables: " + syllables + System.lineSeparator()
                + "Polysyllables: " + polysyllables;
    }

    public void printScore(Formula... formulas) {
        System.out.println();
        for (Formula formula : formulas) {
            formula.setParams(letters, words, sentences, syllables, polysyllables);

            double score = formula.getScore();
            int index = (int) Math.floor(score);
            int age = index >= ages.length ? 24 : ages[index - 1];

            System.out.printf("%s: %.2f (about %s year olds).", formula.getName(), score, age);
            System.out.println();

            avgAge += age;
        }
        avgAge = avgAge / formulas.length;
        System.out.println();
        System.out.println("This text should be understood in average by " + avgAge + " years olds");
    }

    private long countWords() {
        return Pattern.compile(wordsPattern)
                .matcher(text)
                .results()
                .count();
    }

    private long countSentences() {
        return Pattern.compile(sentencePattern)
                .matcher(text)
                .results()
                .count();

    }

    private long countCharacters() {
        return text.replaceAll("\\s", "").length();
    }

    private void countSyllables() {
        for (String s : text.split("\\s")) {
            s = s.toLowerCase().replaceAll("[!?.,;]", "");
            if (s.matches("\\d+")) {
                continue;
            }
            if (s.matches(".+e")) {
                s = s.substring(0, s.length() - 1);
            }
            long vowels = Pattern.compile("[aeiouy]").matcher(s).results().count();
            long doubleVowels = Pattern.compile("[aeiouy][aeiouy]").matcher(s).results().count();

            vowels = vowels - doubleVowels;
            if (vowels == 0) {
                vowels++;
            }
            if (vowels > 2) {
                polysyllables++;
            }
            syllables += vowels;
        }
    }

    private void getTextStatistics() {
        words = countWords();
        sentences = countSentences();
        letters = countCharacters();
        countSyllables();
    }
}
