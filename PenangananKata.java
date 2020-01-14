package com.GUI;

public interface PenangananKata {
    /**
     * Splits the chosen word into letters.
     */
    public void splitWord();

    /**
     * Gets the updated word with the correctly guessed word.
     *
     * @return A array with the word.
     */
    public String getGuessedLetters();

    /**
     * Gets the updated word with the correctly guessed word.
     *
     * @return A array with the word.
     */
    public String getCorrectWord();

    /**
     * Checks if the guessed letter exists in the word.
     *
     * @param guessedLetter
     * @return True if the word contains the guessed letter, else it returns false.
     */
    public boolean guessLetter(String guessedLetter);

    /**
     * Checks if the guessed word matches the correct word.
     * @return True iff the words matches.
     */
    public boolean matchingWords();

}