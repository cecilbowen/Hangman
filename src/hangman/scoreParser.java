/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * XML parser for the high score leaderboard.
 * @author Cecil Bowen/Will McMurran
 */
public class scoreParser {
    
    String pathName = System.getProperty("user.home") + File.separator + "Documents" + File.separator + "Hangman";
    String[][] highScores;
    
    /**
     * Checks if the high score file exists, and creates it if needed.
     */
    public void checkScoreFile(){
                
        try {
            File theFile = new File(pathName, "highscores.xml");
            
            if (new File(pathName).isDirectory()) {
                            
                if(!new File(pathName, "highscores.xml").isFile()){ //if file doesn't exist, create it
                    
                    theFile.createNewFile();
                    
                } else return;
                
            } else { //create directory and file if don't exist
                
                new File(pathName).mkdirs();
                theFile.createNewFile();
                
            }
            
            //complete default word lists
            FileWriter theFileWriter = new FileWriter(theFile);
            
            theFileWriter.write("<?xml version=\"1.0\"?>" + System.getProperty("line.separator"));
            theFileWriter.write("<highscores>" + System.getProperty("line.separator"));
            theFileWriter.write("<player name = \"No entry\">" + System.getProperty("line.separator"));
            theFileWriter.write("<score>0</score>" + System.getProperty("line.separator"));
            theFileWriter.write("</player>" + System.getProperty("line.separator"));
            theFileWriter.write("<player name = \"No entry\">" + System.getProperty("line.separator"));
            theFileWriter.write("<score>0</score>" + System.getProperty("line.separator"));
            theFileWriter.write("</player>" + System.getProperty("line.separator"));
            theFileWriter.write("<player name = \"No entry\">" + System.getProperty("line.separator"));
            theFileWriter.write("<score>0</score>" + System.getProperty("line.separator"));
            theFileWriter.write("</player>" + System.getProperty("line.separator"));
            theFileWriter.write("<player name = \"No entry\">" + System.getProperty("line.separator"));
            theFileWriter.write("<score>0</score>" + System.getProperty("line.separator"));
            theFileWriter.write("</player>" + System.getProperty("line.separator"));
            theFileWriter.write("<player name = \"No entry\">" + System.getProperty("line.separator"));
            theFileWriter.write("<score>0</score>" + System.getProperty("line.separator"));
            theFileWriter.write("</player>" + System.getProperty("line.separator"));
            theFileWriter.write("<player name = \"No entry\">" + System.getProperty("line.separator"));
            theFileWriter.write("<score>0</score>" + System.getProperty("line.separator"));
            theFileWriter.write("</player>" + System.getProperty("line.separator"));
            theFileWriter.write("<player name = \"No entry\">" + System.getProperty("line.separator"));
            theFileWriter.write("<score>0</score>" + System.getProperty("line.separator"));
            theFileWriter.write("</player>" + System.getProperty("line.separator"));
            theFileWriter.write("<player name = \"No entry\">" + System.getProperty("line.separator"));
            theFileWriter.write("<score>0</score>" + System.getProperty("line.separator"));
            theFileWriter.write("</player>" + System.getProperty("line.separator"));
            theFileWriter.write("<player name = \"No entry\">" + System.getProperty("line.separator"));
            theFileWriter.write("<score>0</score>" + System.getProperty("line.separator"));
            theFileWriter.write("</player>" + System.getProperty("line.separator"));
            theFileWriter.write("<player name = \"No entry\">" + System.getProperty("line.separator"));
            theFileWriter.write("<score>0</score>" + System.getProperty("line.separator"));
            theFileWriter.write("</player>" + System.getProperty("line.separator"));
            theFileWriter.write("</highscores>" + System.getProperty("line.separator"));
            theFileWriter.flush();
            theFileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(scoreParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Reads the high score file.
     * @return 2D array of strings that represents the names on the leader board and their scores.
     */
    public String[][] readScoreFile() {
        
        try {
            File theFile = new File(pathName, "highscores.xml");
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(theFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("player");
            NodeList wList;
            
            highScores = new String[nList.getLength()][];
            
            for(int index = 0; index < nList.getLength(); index++){
                
                Element eElement = (Element) nList.item(index);
                wList = eElement.getElementsByTagName("score");
                highScores[index] = new String[(wList.getLength()+ 1)];
                highScores[index][0] = eElement.getAttribute("name");
                
                for(int index2 = 1; index2 < (wList.getLength() + 1); index2++){
                    
                    highScores[index][index2] = wList.item(index2 - 1).getTextContent();
                    
                }
                
            }
            
            return highScores;
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            Logger.getLogger(scoreParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return highScores;
    }
    
    /**
     * Writes the leader board list to the file.
     * @param newScoreList 2D array of strings that represents the name and scores on the leader board.
     */
    public void writeScoreFile(String[][] newScoreList){
        
        FileWriter theFileWriter = null;
        try {
            File theFile = new File(pathName, "highscores.xml");
            theFileWriter = new FileWriter(theFile);
            theFileWriter.write("<?xml version=\"1.0\"?>" + System.getProperty("line.separator"));
            theFileWriter.write("<highscores>" + System.getProperty("line.separator"));
            for(int index = 0; index < newScoreList.length; index++){
                
                theFileWriter.write("<player name = \"" + newScoreList[index][0] +"\">" + System.getProperty("line.separator"));
                theFileWriter.write("<score>" + newScoreList[index][1] +"</score>" + System.getProperty("line.separator"));
                theFileWriter.write("</player>" + System.getProperty("line.separator"));
                
            }   theFileWriter.write("</highscores>" + System.getProperty("line.separator"));
            theFileWriter.flush();
            theFileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(scoreParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            theFileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(scoreParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
