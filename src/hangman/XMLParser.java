/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hangman;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import org.xml.sax.SAXException;

/**
 * XML parser for the word lists.
 * @author Cecil Bowen/Will McMurran
 */

public class XMLParser {
    
    String pathName = System.getProperty("user.home") + File.separator + "Documents" + File.separator + "Hangman";
    String[][] wordLists;
    
    /**
     * Checks for the word list file, and creates it if needed.
     */
    public void checkHangmanFile(){
        
        FileWriter theFileWriter = null;
        try {
            File theFile = new File(pathName, "hangman.xml");
            if (new File(pathName).isDirectory()) {
                
                if(!new File(pathName, "hangman.xml").isFile()){ //if file doesn't exist, create it
                    
                    theFile.createNewFile();
                                
                } else return;
                
            } else { //create directory and file if don't exist
                
                new File(pathName).mkdirs();
                theFile.createNewFile();
                
            }   //complete default word lists
            theFileWriter = new FileWriter(theFile);
            theFileWriter.write("<?xml version=\"1.0\"?>" + System.getProperty("line.separator"));
            theFileWriter.write("<wordlists>" + System.getProperty("line.separator"));
            theFileWriter.write("<list difficulty = \"easy\">" + System.getProperty("line.separator"));
            theFileWriter.write("<word>talk</word>" + System.getProperty("line.separator"));
            theFileWriter.write("<word>wide</word>" + System.getProperty("line.separator"));
            theFileWriter.write("<word>box</word>" + System.getProperty("line.separator"));
            theFileWriter.write("<word>dig</word>" + System.getProperty("line.separator"));
            theFileWriter.write("<word>race</word>" + System.getProperty("line.separator"));
            theFileWriter.write("<word>look</word>" + System.getProperty("line.separator"));
            theFileWriter.write("<word>boom</word>" + System.getProperty("line.separator"));
            theFileWriter.write("</list>" + System.getProperty("line.separator"));
            theFileWriter.write("<list difficulty = \"medium\">" + System.getProperty("line.separator"));
            theFileWriter.write("<word>coconut</word>" + System.getProperty("line.separator"));
            theFileWriter.write("<word>bicycle</word>" + System.getProperty("line.separator"));
            theFileWriter.write("<word>triceps</word>" + System.getProperty("line.separator"));
            theFileWriter.write("<word>average</word>" + System.getProperty("line.separator"));
            theFileWriter.write("<word>biceps</word>" + System.getProperty("line.separator"));
            theFileWriter.write("<word>battery</word>" + System.getProperty("line.separator"));
            theFileWriter.write("<word>stitches</word>" + System.getProperty("line.separator"));
            theFileWriter.write("</list>" + System.getProperty("line.separator"));
            theFileWriter.write("<list difficulty = \"hard\">" + System.getProperty("line.separator"));
            theFileWriter.write("<word>explosion</word>" + System.getProperty("line.separator"));
            theFileWriter.write("<word>microphone</word>" + System.getProperty("line.separator"));
            theFileWriter.write("<word>cardboard</word>" + System.getProperty("line.separator"));
            theFileWriter.write("<word>successful</word>" + System.getProperty("line.separator"));
            theFileWriter.write("<word>civilization</word>" + System.getProperty("line.separator"));
            theFileWriter.write("<word>processor</word>" + System.getProperty("line.separator"));
            theFileWriter.write("<word>terrestrial</word>" + System.getProperty("line.separator"));
            theFileWriter.write("<word>impressive</word>" + System.getProperty("line.separator"));
            theFileWriter.write("<word>distinguish</word>" + System.getProperty("line.separator"));
            theFileWriter.write("</list>" + System.getProperty("line.separator"));
            theFileWriter.write("</wordlists>" + System.getProperty("line.separator"));
            theFileWriter.flush();
            theFileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, ex);
        } 
        try {
            theFileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Writes a word list to the file.
     * @param newWordList Array of strings of words to be added
     * @param tag String of the name of the list
     */
    public void writeHangmanFile(String[] newWordList, String tag){
        
        try {
            File theFile = new File(pathName, "hangman.xml");
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(theFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("list");
            NodeList wList;
            boolean found = false;
            FileWriter theFileWriter = new FileWriter(theFile);
            
            wordLists = new String[nList.getLength()][];
            
            for(int index = 0; index < nList.getLength(); index++){
                
                Element eElement = (Element) nList.item(index);
                wList = eElement.getElementsByTagName("word");
                wordLists[index] = new String[(wList.getLength() + 1)];
                wordLists[index][0] = eElement.getAttribute("difficulty");
                
                for(int index2 = 1; index2 < (wList.getLength() + 1); index2++){
                    
                    wordLists[index][index2] = wList.item(index2 - 1).getTextContent();
                    
                }
                
            }
            
            for(int index = 0; index < nList.getLength(); index++){
                
                if(wordLists[index][0].equals(tag)){
                    
                    wordLists[index] = newWordList;
                    found = true;
                    
                }
                
            }
            
            theFileWriter.write("<?xml version=\"1.0\"?>" + System.getProperty("line.separator"));
            theFileWriter.write("<wordlists>" + System.getProperty("line.separator"));
            
            for(int index = 0; index < wordLists.length; index++){
                
                theFileWriter.write("<list difficulty = \"" + wordLists[index][0] +"\">" + System.getProperty("line.separator"));
                
                for(int index2 = 1; index2 < wordLists[index].length; index2++){
                    
                    theFileWriter.write("<word>" + wordLists[index][(index2)] +"</word>" + System.getProperty("line.separator"));
                    
                }
                
                theFileWriter.write("</list>" + System.getProperty("line.separator"));
                
            }
            
            if(found == false){
                
                theFileWriter.write("<list difficulty = \"" + tag +"\">" + System.getProperty("line.separator"));
                
                for(int index = 0; index < newWordList.length; index++){
                    
                    theFileWriter.write("<word>" + newWordList[index] +"</word>" + System.getProperty("line.separator"));
                    
                }
                
                theFileWriter.write("</list>" + System.getProperty("line.separator"));
                
            }
            
            theFileWriter.write("</wordlists>" + System.getProperty("line.separator"));
            theFileWriter.flush();
            theFileWriter.close();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Erases one list from the file.
     * @param tag String of the name of the list to be deleted
     */
    public void eraseHangmanFile(String tag){
        
        try {
            File theFile = new File(pathName, "hangman.xml");
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(theFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("list");
            NodeList wList;
            boolean found = false;
            FileWriter theFileWriter = new FileWriter(theFile);
            
            wordLists = new String[nList.getLength()][];
            
            for(int index = 0; index < nList.getLength(); index++){
                
                Element eElement = (Element) nList.item(index);
                wList = eElement.getElementsByTagName("word");
                wordLists[index] = new String[(wList.getLength() + 1)];
                wordLists[index][0] = eElement.getAttribute("difficulty");
                
                for(int index2 = 1; index2 < (wList.getLength() + 1); index2++){
                    
                    wordLists[index][index2] = wList.item(index2 - 1).getTextContent();
                    
                }
                
            }
            
            theFileWriter.write("<?xml version=\"1.0\"?>" + System.getProperty("line.separator"));
            theFileWriter.write("<wordlists>" + System.getProperty("line.separator"));
            
            for(int index = 0; index < wordLists.length; index++){
                
                if(!wordLists[index][0].equals(tag)){
                    
                    theFileWriter.write("<list difficulty = \"" + wordLists[index][0] +"\">" + System.getProperty("line.separator"));
                    
                    for(int index2 = 1; index2 < wordLists[index].length; index2++){
                        
                        theFileWriter.write("<word>" + wordLists[index][(index2)] +"</word>" + System.getProperty("line.separator"));
                        
                    }
                    
                    theFileWriter.write("</list>" + System.getProperty("line.separator"));
                    
                }
                
            }
                        
            theFileWriter.write("</wordlists>" + System.getProperty("line.separator"));
            theFileWriter.flush();
            theFileWriter.close();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Reads the word list file.
     * @return 2D array of strings that represents all of the word lists
     */
    public String[][] readHangmanFile(){
        
        try {
            File theFile = new File(pathName, "hangman.xml");
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(theFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("list");
            NodeList wList;
            
            wordLists = new String[nList.getLength()][];
            
            for(int index = 0; index < nList.getLength(); index++){
                
                Element eElement = (Element) nList.item(index);
                wList = eElement.getElementsByTagName("word");
                wordLists[index] = new String[(wList.getLength() + 1)];
                wordLists[index][0] = eElement.getAttribute("difficulty");
                
                for(int index2 = 1; index2 < (wList.getLength() + 1); index2++){
                    
                    wordLists[index][index2] = wList.item(index2 - 1).getTextContent();
                    
                }
                
            }
            
            return wordLists;
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return wordLists;
        
    }
    
    /**
     * Deletes the word list file.
     */
    public void deleteHangmanFile(){
        File theFile = new File(pathName, "hangman.xml");
        if (theFile.delete()) System.out.println("Hangman file deleted."); else System.out.println("Hangman file failed to delete itself.");
    }
    
}
