/*
 * frmMain.java
 *
 * Created on 9 de febrero de 2009, 20:55
 */

package gui;

import java.io.File;
import javax.swing.JFileChooser;
import parsers.dom.*;

/**
 *
 * @author  gabriel
 */
public class frmMain extends javax.swing.JFrame 
{        
    static private String newline = "\n";
    private JFileChooser fc;
    private File file;
    /** Creates new form frmMain */
    public frmMain() 
    {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        checkBoxWhitespace = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Parsermente 1.0.1");
        setResizable(false);

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        jButton1.setText("Select XML file");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        checkBoxWhitespace.setText("Preserve Whitespace");
        checkBoxWhitespace.setToolTipText("Gets or sets a value indicating whether to preserve white space in element content.");
        checkBoxWhitespace.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(checkBoxWhitespace)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(checkBoxWhitespace)
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Set up the file chooser.
        if (fc == null) 
        {
            fc = new JFileChooser();

	    //Add a custom file filter and disable the default
	    //(Accept All) file filter.
            fc.addChoosableFileFilter(new XMLFilter());
            fc.setAcceptAllFileFilterUsed(false);
        }
        
        //Show it.
        int returnVal = fc.showDialog(this, "Attach");

        textArea.setText("");
        //Process the results.
        if (returnVal == JFileChooser.APPROVE_OPTION) 
        {
            file = fc.getSelectedFile();
            textArea.append("Attaching file: " + file.getName() + "." + newline + newline);
            runParsermente();
        } 
        else 
        {
            textArea.append("Attachment cancelled by user." + newline);
        }        

        //Reset the file chooser for the next time it's shown.
        fc.setSelectedFile(null);                
    }//GEN-LAST:event_jButton1ActionPerformed
           
    private void runParsermente()
    {
        try
        {
            DOMParser domParser = new DOMParser(checkBoxWhitespace.isSelected());
            Document doc = domParser.parse(file);
            
            IteratorDOM iterator = doc.getIteratorDOM();       
        
            while(iterator.hasMoreElements())
            {                
                iterator.next();
                textArea.append(iterator.getCurrentElement().toString() + newline);                        
            }
            
            textArea.append(newline + "Success...");        
        }
        catch(Exception ex)
        {
            textArea.append(ex.getMessage());
        }
    }
            
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() 
            {
                new frmMain().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkBoxWhitespace;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
    
}
