/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hangman;

import java.util.Random;

/**
 * Class that runs the Hangman game logic.
 * @author Cecil Bowen/Will McMurran
 */
public class Hangman {
    
    private String[][] wordLists;
    private String currentWord;
    private int wordLength;
    private String revealedWord;
    private int startIndex;
    private boolean letterHit;
    private int hitIndex;
    private char[] revealedCharWord;
    private char choiceChar[];
    private int numberOfMisses;
    private int missesUsed;
    private int hits;
    private boolean gameOver = false;
    private int score = 0; //amount of words completed
    private int difficulty = 0; //1 - easy(<=4 letters), 2 - normal(<=8 letters), 3 - hard(>8 letters), 0 - any
    public static final int EASY_LIMIT = 4;
    public static final int NORMAL_LIMIT = 8;
    private String[][] scoreList;
    
    
    public boolean usingAllLists = true;
    
    public Hangman() {
        
        setUp();
        
    }
    
    /**
     * Initiate the game.
     */
    public void initGame() {
        
        XMLParser theParser = new XMLParser();
        
        wordLists = theParser.readHangmanFile();
        
        pickRandomWord();
        
        gameOver = false;
        wordLength = currentWord.length();
        revealedWord = "";
        numberOfMisses = 6;
        missesUsed = 0;
        hits = 0;
        score = 0;
        
        for(int i = 0; i<wordLength;i++){
            
            revealedWord = revealedWord.concat("_"); //changed to underscore to see unknown letters on gui
            
        }
        
        System.out.println("[]Random word is: "+currentWord);
        gameOver = false;
        
    }
    
    /**
     * Picks a random word to use.
     */
    public void pickRandomWord() {
        Random randomNumberGenerator = new Random();
        
        if (usingAllLists) { //pick random word from ANY list
            int randomInt1 = randomNumberGenerator.nextInt(wordLists.length);
            int randomInt2 = randomNumberGenerator.nextInt(wordLists[randomInt1].length - 1);
            currentWord = wordLists[randomInt1][(randomInt2 + 1)];
        } else { //pick random word from default lists
            int randomNum = randomNumberGenerator.nextInt((2 - 0) + 1) + 0;
            int randomInt = randomNumberGenerator.nextInt(wordLists[0].length - 1);
            currentWord = wordLists[randomNum][(randomInt + 1)];
        }
        System.out.println(">>"+currentWord);
        if (difficulty == 0) return; //return word if "any" difficulty selected
        
        if (difficulty == 1) {
            if (currentWord.length() > EASY_LIMIT) pickRandomWord();
        } else if (difficulty == 2) {
            if ((currentWord.length() > NORMAL_LIMIT) || (currentWord.length() < EASY_LIMIT+1)) pickRandomWord();
        } else if (difficulty == 3) {
            if (currentWord.length() < NORMAL_LIMIT+1) pickRandomWord();
        }
        
    }
    
    /**
     * Sets up a new word for a game.
     */
    public void newWord() {
        pickRandomWord();
        
        wordLength = currentWord.length();
        revealedWord = "";
        numberOfMisses = 6;
        missesUsed = 0;
        hits = 0;
        
        for(int i = 0; i<wordLength;i++) {
            revealedWord = revealedWord.concat("_"); //changed to underscore to see unknown letters on gui
        }
        
        System.out.println("[]Random word is: "+currentWord);   
        gameOver = false;
    }
    
    /**
     * Returns the revealed word.
     * @return The string that represents the letters uncovered so far.
     */
    public String getRevealedWord() {
        return revealedWord; //returns word (so far)
    }
    
    /**
     * Returns the current word.
     * @return The string that represents the currently selected word.
     */
    public String getWord() {
        return currentWord; //returns full word
    }
    
    /**
     * Takes the turn of Hangman
     * @param Choice String of the letter that was chosen.
     * @return A boolean that represents whether or not the letter is in the current word
     */
    public boolean takeTurn(String Choice){
        
        startIndex = 0;
        letterHit = false;
        Choice = Choice.toLowerCase(); //just in case something wonky happens
        
        //while letter exists in the word, loop through word counting correct letters
        while(currentWord.indexOf(Choice,startIndex) >= 0){
            
            letterHit = true;
            hits = hits + 1;
            hitIndex = currentWord.indexOf(Choice,startIndex);
            revealedCharWord = revealedWord.toCharArray();
            choiceChar = Choice.toCharArray();
            revealedCharWord[hitIndex] = choiceChar[0];
            revealedWord = new String(revealedCharWord);
            startIndex = hitIndex + 1;
                        
        }
        
        //if letter not in word, add a miss!
        if(currentWord.indexOf(Choice,0) == -1){
            missesUsed = missesUsed + 1;
        }
        
        return letterHit;
        
    }
    
    /**
     * Returns the status of the game.
     * @return A string that says the game is either won, lost, or in progress.
     */
    public String gameStatus() {
        
        if(hits >= wordLength){
            if (!gameOver) score++;
            gameOver = true;
            return "won";
        } else {
            
            if(missesUsed < numberOfMisses){
                return "in progress";
            } else {
                gameOver = true;
                return "lost";
            }
            
        }
        
    }
    
    /**
     * Returns whether the game is over or not.
     * @return A boolean that represents whether the game is over or not.
     */
    public boolean isGameOver() {
        return gameOver;
    }
    
    /**
     * Returns the current score.
     * @return The integer score.
     */
    public int getScore() {
        return score;
    }
    
    /**
     * Returns the number of misses in the current game.
     * @return The integer of the number of misses.
     */
    public int getMissesUsed() {
        return missesUsed;
    }
    
    /**
     * Set the game's difficulty.
     * @param level The integer that represents the difficulty chosen.
     */
    public void setDifficulty(int level) {
        difficulty = level;
    }
    
    /**
     * Returns the names of the available word lists.
     * @return Array of strings that represents the names of the word lists available
     */
    public String[] getListNames(){
        
        String[] result = new String[wordLists.length];
        
        for(int i = 0; i < wordLists.length; i++){
            
            result[i] = wordLists[i][0];
            
        }
        
        return result;
        
    }
    
    /**
     * Returns the words of the selected word list.
     * @param tag String of the name of the chosen word list.
     * @return Array of strings that represents the words in the list selected.
     */
    public String[] getAList(String tag){
        
        int listSelection = -1;
        
        for(int i = 0; i < wordLists.length; i++){
            
            if(wordLists[i][0].equals(tag)){
                
                listSelection = i;
                
            }
            
        }
        
        if(listSelection == -1){
            
            String[] result = {"null"};
            return result;
            
        } else{
            
            String[] result = new String[wordLists[listSelection].length];
            
            for(int i = 1; i < wordLists[listSelection].length; i++){
                
                result[i-1] = wordLists[listSelection][(i)];
                
            }
            
            return result;
            
        }        
        
    }
    
    /**
     * Returns the scores on the leader board.
     * @return 2D array of strings that list the names and scores on the leader board
     */
    public String[][] getScores(){
        
        return scoreList;
        
    }
    
    /**
     * Sets up and runs the word list and leader board parsers.
     */
    public void setUp(){
        
        XMLParser theParser = new XMLParser();
        
        theParser.checkHangmanFile();
        
        wordLists = theParser.readHangmanFile();
        
        scoreParser scoreparse = new scoreParser();
        scoreparse.checkScoreFile();
        
        scoreList = scoreparse.readScoreFile();
        
    }
    
    /**
     * Checks if the current score is worthy of the leader board.
     * @return Boolean indicating whether to put the score on the leader board.
     */
    boolean checkScore(){
        
        int scoreIndex = -1;
        
        for(int i = 0; i < scoreList.length;i++){
            
            if(score > Integer.parseInt(scoreList[i][1])){
                
                scoreIndex = i;
                
            }
            
        }
        
        return scoreIndex != -1;
        
    }
    
    /**
     * Adds the current score and inputted name onto the leader board.
     * @param name String of the name to add to the leader board
     * @return Boolean of whether or not the score was added to the leader board.
     */
    boolean submitScore(String name){
        
        scoreParser newScoreParser = new scoreParser();
        int scoreIndex = -1;
        
        for(int i = 0; i < scoreList.length;i++){
            
            if(score > Integer.parseInt(scoreList[i][1])){
                
                scoreIndex = i;
                break;
                
            }
            
        }
        
        if(scoreIndex == -1){
            return false;
        }
        
        for(int i = 9; i > scoreIndex; i--){
            
            scoreList[i][0] = scoreList[i-1][0];
            scoreList[i][1] = scoreList[i-1][1];
            
        }
        
        scoreList[scoreIndex][0] = name;
        scoreList[scoreIndex][1] = String.valueOf(score);
        
        newScoreParser.writeScoreFile(scoreList);
        
        return true;
        
    }
    
}
