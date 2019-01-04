/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;


import java.awt.Color;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.ListCellRenderer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Preference menu GUI
 * @author Cecil Bowen/Will McMurran
 */
public class HangmanPreferencesGUI extends javax.swing.JFrame {

    /**
     * Creates new form HangmanPreferencesGUI
     */
    public HangmanPreferencesGUI() {
        initComponents();
    }
    
    public HangmanPreferencesGUI(HangmanMainGUI g) {
        initComponents();
        this.gui = g;
        try {
            // TODO add your handling code here:
            readPreferences(prefFile);
        } catch (IOException ex) {
            Logger.getLogger(HangmanPreferencesGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private HangmanMainGUI gui;
    private int theRed = 0;
    private int theGreen = 0;
    private int theBlue = 0;
    String pathName = System.getProperty("user.home") + File.separator + "Documents" + File.separator + "Hangman";
    String prefFile = "pref.txt";

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelColorTheme = new javax.swing.JLabel();
        jButtonResetWordLists = new javax.swing.JButton();
        jCheckBoxUseCustomLists = new javax.swing.JCheckBox();
        Color[] colors = {Color.black, Color.blue, Color.red, Color.orange, Color.cyan, Color.magenta};
        jComboBoxColor = new JComboBox(colors);
        jSliderRed = new javax.swing.JSlider();
        jSliderGreen = new javax.swing.JSlider();
        jSliderBlue = new javax.swing.JSlider();
        jLabelRed = new javax.swing.JLabel();
        jLabelGreen = new javax.swing.JLabel();
        jLabelBlue = new javax.swing.JLabel();
        jPanelRGB = new javax.swing.JPanel();
        jLabelRGB = new javax.swing.JLabel();
        jButtonSetColor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Hangman");
        setAlwaysOnTop(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Preferences"));

        jLabelColorTheme.setText("Hangman Color:");

        jButtonResetWordLists.setText("Reset Word Lists");
        jButtonResetWordLists.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetWordListsActionPerformed(evt);
            }
        });

        jCheckBoxUseCustomLists.setSelected(true);
        jCheckBoxUseCustomLists.setText("Use Custom Lists");
        jCheckBoxUseCustomLists.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxUseCustomListsActionPerformed(evt);
            }
        });

        jComboBoxColor.setRenderer(new MyCellRenderer());
        jComboBoxColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxColorActionPerformed(evt);
            }
        });

        jSliderRed.setMaximum(255);
        jSliderRed.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider)e.getSource();
                theRed = source.getValue();
                jPanelRGB.setBackground(new Color(theRed, theGreen, theBlue));
                jLabelRGB.setText("["+theRed+", "+theGreen+", "+theBlue+"]");
            }
        });

        jSliderGreen.setMaximum(255);
        jSliderGreen.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider)e.getSource();
                theGreen = source.getValue();
                jPanelRGB.setBackground(new Color(theRed, theGreen, theBlue));
                jLabelRGB.setText("["+theRed+", "+theGreen+", "+theBlue+"]");
            }
        });

        jSliderBlue.setMaximum(255);
        jSliderBlue.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider)e.getSource();
                theBlue = source.getValue();
                jPanelRGB.setBackground(new Color(theRed, theGreen, theBlue));
                jLabelRGB.setText("["+theRed+", "+theGreen+", "+theBlue+"]");
            }
        });

        jLabelRed.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelRed.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelRed.setText("Red:");

        jLabelGreen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelGreen.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelGreen.setText("Green:");

        jLabelBlue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelBlue.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelBlue.setText("Blue:");

        jPanelRGB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelRGB.setBackground(new Color(jSliderRed.getValue(), jSliderGreen.getValue(), jSliderBlue.getValue()));

        javax.swing.GroupLayout jPanelRGBLayout = new javax.swing.GroupLayout(jPanelRGB);
        jPanelRGB.setLayout(jPanelRGBLayout);
        jPanelRGBLayout.setHorizontalGroup(
            jPanelRGBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelRGBLayout.setVerticalGroup(
            jPanelRGBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );

        jLabelRGB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRGB.setText("[0, 0, 0]");

        jButtonSetColor.setText("Set Color");
        jButtonSetColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSetColorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxColor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabelRed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabelGreen, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jSliderGreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jSliderRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabelBlue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSliderBlue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBoxUseCustomLists)
                                    .addComponent(jLabelColorTheme)
                                    .addComponent(jButtonResetWordLists))
                                .addGap(140, 140, 140)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelRGB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelRGB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonSetColor, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonSetColor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelColorTheme)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxColor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelRed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSliderRed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelGreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSliderGreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSliderBlue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelBlue, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanelRGB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelRGB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonResetWordLists, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxUseCustomLists)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxColorActionPerformed
        // TODO add your handling code here:
        //getContentPane().setBackground( Color.RED );
        //static but whatever AM I RIGHT -- NOT STATIC ANYMORE!! I GAVE IN!!
        Color paintIt = (Color)this.jComboBoxColor.getSelectedItem();
        gui.hangmanColor = paintIt;
        
        jSliderRed.setValue(paintIt.getRed());
        jSliderGreen.setValue(paintIt.getGreen());
        jSliderBlue.setValue(paintIt.getBlue());
        jPanelRGB.setBackground(paintIt);
        jLabelRGB.setText("["+theRed+", "+theGreen+", "+theBlue+"]");
        gui.redrawBody();
        try {
            // TODO add your handling code here:
            savePreferences(prefFile);
        } catch (IOException ex) {
            Logger.getLogger(HangmanPreferencesGUI.class.getName()).log(Level.SEVERE, null, ex);
        }        
        System.out.println("[Combobox]Hangman color set to: ["+paintIt.getRed()+", "+paintIt.getGreen()+", "+paintIt.getBlue()+"]");
    }//GEN-LAST:event_jComboBoxColorActionPerformed

    private void jButtonSetColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSetColorActionPerformed
        // TODO add your handling code here:
        Color paintIt = new Color(theRed, theGreen, theBlue);
        gui.hangmanColor = paintIt;
        gui.redrawBody();
        try {
            // TODO add your handling code here:
            savePreferences(prefFile);
        } catch (IOException ex) {
            Logger.getLogger(HangmanPreferencesGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("[Slider]Hangman color set to: ["+theRed+", "+theGreen+", "+theBlue+"]");
    }//GEN-LAST:event_jButtonSetColorActionPerformed

    private void jCheckBoxUseCustomListsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxUseCustomListsActionPerformed
        // TODO add your handling code here:
        gui.game.usingAllLists = jCheckBoxUseCustomLists.isSelected();
        try {
            savePreferences(prefFile);
        } catch (IOException ex) {
            Logger.getLogger(HangmanPreferencesGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jCheckBoxUseCustomListsActionPerformed

    private void jButtonResetWordListsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetWordListsActionPerformed
        int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to reset the word lists to default?", "Reset Word Lists", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            XMLParser hangmanFile = new XMLParser();
            hangmanFile.deleteHangmanFile();
            hangmanFile.checkHangmanFile();
            JOptionPane.showMessageDialog(null, "Lists reset.");
        }
    }//GEN-LAST:event_jButtonResetWordListsActionPerformed

    
    
    private void readPreferences(String filename) throws IOException {
        //ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(pathName, prefFile);
        if(file.exists() && !file.isDirectory()) {} else {savePreferences(filename);} //create file if it doesn't exist
        
	FileInputStream fis = new FileInputStream(file);
	BufferedReader br = new BufferedReader(new InputStreamReader(fis));
 
	//String line = null;
        theRed = Integer.parseInt(br.readLine());
        theGreen = Integer.parseInt(br.readLine());
        theBlue = Integer.parseInt(br.readLine());
        gui.game.usingAllLists = Boolean.parseBoolean(br.readLine());
        /*
	while ((line = br.readLine()) != null) {
		System.out.println(line);
	}*/
 
	br.close();
        
        updateColors();
        //System.out.println("red: "+theRed+", green: "+theGreen+", blue: "+theBlue+" lists? "+gui.game.usingAllLists);
    }
    
    public void savePreferences(String filename) throws IOException {
        //ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(pathName, prefFile);
	FileOutputStream fos = new FileOutputStream(file);
        System.out.println(theRed+", "+theGreen+", "+theBlue);
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
 
        bw.write(""+theRed);
        bw.newLine();
        bw.write(""+theGreen);
        bw.newLine();
        bw.write(""+theBlue);
        bw.newLine();
        bw.write((gui.game.usingAllLists) ? "true" : "false");
        
        /*
	for (int i = 0; i < 10; i++) {
		bw.write("something");
		bw.newLine();
	}*/
 
	bw.close();
    }
    
    public void updateColors() {
        Color paintIt = new Color(theRed, theGreen, theBlue);
        gui.hangmanColor = paintIt;
        jSliderRed.setValue(paintIt.getRed());
        jSliderGreen.setValue(paintIt.getGreen());
        jSliderBlue.setValue(paintIt.getBlue());
        jPanelRGB.setBackground(paintIt);
        jLabelRGB.setText("["+theRed+", "+theGreen+", "+theBlue+"]");
        jCheckBoxUseCustomLists.setSelected(gui.game.usingAllLists);
        gui.redrawBody();
    }
    
    //renders color selector
    class MyCellRenderer extends JButton implements ListCellRenderer {
        public MyCellRenderer() {  
            setOpaque(true); 
        }
        
        boolean b = false;
        
        @Override
        public void setBackground(Color bg) {
            // TODO Auto-generated method stub
             if(!b) {
                 return;
             }

            super.setBackground(bg);
        }
        
        @Override
        public Component getListCellRendererComponent(  
            JList list,  
            Object value,  
            int index,  

            boolean isSelected,  
            boolean cellHasFocus)  
        {  

            b = true;
            //setText("Color Theme");           
            //System.out.println(value);
            setBackground((Color)value);        
            b = false;
            return this;  
        }  
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonResetWordLists;
    private javax.swing.JButton jButtonSetColor;
    private javax.swing.JCheckBox jCheckBoxUseCustomLists;
    private javax.swing.JComboBox<String> jComboBoxColor;
    private javax.swing.JLabel jLabelBlue;
    private javax.swing.JLabel jLabelColorTheme;
    private javax.swing.JLabel jLabelGreen;
    private javax.swing.JLabel jLabelRGB;
    private javax.swing.JLabel jLabelRed;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelRGB;
    private javax.swing.JSlider jSliderBlue;
    private javax.swing.JSlider jSliderGreen;
    private javax.swing.JSlider jSliderRed;
    // End of variables declaration//GEN-END:variables
}