package test_taschenrechner;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Fenster extends JFrame implements ActionListener {
    
    //Button-Array wird deklariert und initialisiert (speichert die Zahlen-Buttons)
    JButton[] zahlenButtons = new JButton[10]; 
    
    //Button-Array wird deklariert und initialisiert (speichert die Operator-Buttons)
    JButton[] operatorButtons = new JButton[7]; 
    
    //Ausgabe wird deklariert und initialisiert
    JTextField textfeld = new JTextField();
    
    //Container für die Buttons wird deklariert und initialisiert (enthält die Zahlen und Operatoren)
    JPanel panel = new JPanel();        
    
    //Operator-Buttons werden deklariert und initialisiert
    JButton plusButton = new JButton("+");          
    JButton minusButton = new JButton("-");        
    JButton malButton = new JButton("·");    
    JButton kommaButton = new JButton(",");   
    JButton gleichButton = new JButton("=");  
    JButton geteiltButton = new JButton("÷");                     
    JButton löschenButton = new JButton("Löschen"); 
    
    double nummer1 = 0, nummer2 = 0, ergebnis = 0;  
    char operator;
    
    public Fenster () {
        this.setSize(250, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("Taschenrechner");
        
        //Textfeld wird initialisiert, positioniert und für den Benutzer unmöglich zu bearbeiten
        textfeld.setBounds(25, 25, 200, 50);
        textfeld.setEditable(false);
        
        //Das Panel wird initialisiert, positioniert und mit einem Grid-Layout für die Buttons versehen                 
        panel.setBounds(25, 100, 200, 200);             
        panel.setLayout(new GridLayout(4, 4, 0, 0));

        //Löschen-Button wird positioniert    
        löschenButton.setBounds(75, 310, 100, 50);
        
        //Jedes Objekt im Array für die Zahlen wird initialisiert und erhält anschließend einen ActionListener
        for (int i = 0; i < zahlenButtons.length; i++) {
            zahlenButtons[i] = new JButton(String.valueOf(i));
            zahlenButtons[i].addActionListener(this);
            panel.add(zahlenButtons[i]);
        }
        
        //Operator-Buttons werden dem entsprechenden Array hinzugefügt
        operatorButtons[0] = plusButton;        
        operatorButtons[1] = minusButton;       
        operatorButtons[2] = malButton;    
        operatorButtons[3] = kommaButton;
        operatorButtons[4] = gleichButton; 
        operatorButtons[5] = geteiltButton;              
        operatorButtons[6] = löschenButton;     
        
        //Jeder Operator-Button im Array erhält einen ActionListener
        for (int i = 0; i < operatorButtons.length; i++) {
            operatorButtons[i].addActionListener(this);
        } 
     
        //4x4-Matrix beginnt/////////////////////////////////////////////////////////////////////////////////////////////////
        panel.add(zahlenButtons[1]); //Die Buttons mit den Werte 1 bis 3 werden nebeneinander auf dem Panel eingefügt
        panel.add(zahlenButtons[2]); //
        panel.add(zahlenButtons[3]); //
        panel.add(plusButton);       //Rechts neben den Werten 1 bis 3 wird der Plus-Button eingefügt
        
        panel.add(zahlenButtons[4]); //Die Buttons mit den Werte 4 bis 6 werden nebeneinander auf dem Panel eingefügt
        panel.add(zahlenButtons[5]); //
        panel.add(zahlenButtons[6]); //
        panel.add(minusButton);      //Rechts neben den Werten 4 bis 6 wird der Minus-Button eingefügt
        
        panel.add(zahlenButtons[7]); //Die Buttons mit den Werte 7 bis 9 werden nebeneinander auf dem Panel eingefügt
        panel.add(zahlenButtons[8]); //
        panel.add(zahlenButtons[9]); //
        panel.add(malButton);        //Rechts neben den Werten 7 bis 9 wird der Mal-Button eingefügt
        
        panel.add(kommaButton);      //Nebeneinander werden die restlichen Operator-Buttons un der Null-Button eingefügt
        panel.add(zahlenButtons[0]); //
        panel.add(gleichButton);     //
        panel.add(geteiltButton);    //
        //4x4-matrix endet///////////////////////////////////////////////////////////////////////////////////////////////////
        
        //Löschen-Button wird auf dem JFrame hinzugefüg
        this.add(löschenButton);     
        
        //Textfeld der Ausgabe wird auf dem JFrame hinzugefügt
        this.add(textfeld);  
        
        //Panel wird auf dem JFrame hinzugefügt
        this.add(panel);  
    }
     
    //Wenn irgendein ActionListener einen Klick wahrnimmt, wird die folgende Methode ausgeführt
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < zahlenButtons.length; i++) {                                              
            if (e.getSource() == zahlenButtons[i]) {                                //Sofern das ActionEvent e von einem Button-Klick ausgelöst wurde,
                textfeld.setText(textfeld.getText().concat(String.valueOf(i)));     //wird an den bestehenden Text der neue Text (hier die Zahl) angehängt
            }
        }
        
        if (e.getSource() == plusButton) {                            //Sofern eine bestimmte Rechenoperation gefordert wird://///////////////////////
            nummer1 = Double.parseDouble(textfeld.getText());         //Der String-Text wird in einen Double umgewandelt und in "nummer1" gespeichert
            operator = '+';                                           //Die variable "operator" wird aktualisiert mit dem entsprechenden Operator
            textfeld.setText("");                                     //Das Ausgabefeld wird geleert
        }
        
        if (e.getSource() == minusButton) {
            nummer1 = Double.parseDouble(textfeld.getText());                       
            operator = '-';
            textfeld.setText("");
        }
        
        if (e.getSource() == malButton) {
            nummer1 = Double.parseDouble(textfeld.getText());
            operator = '*';
            textfeld.setText("");
        }
        
        if (e.getSource() == geteiltButton) {
            nummer1 = Double.parseDouble(textfeld.getText());
            operator = '/';
            textfeld.setText("");
        }                                                             ////////////////////////////////////////////////////////////////////////////////
        
        
        if (e.getSource() == kommaButton) {                           //Sofern das ActionEvent e von einem Button-Klick ausgelöst wurde,
            textfeld.setText(textfeld.getText().concat("."));         //wird an den bestehenden Text der neue Text (hier das Komma) angehängt
        }
        
        if (e.getSource() == löschenButton) {                         //Wird der "Löschen"-Button gedrückt,
            textfeld.setText("");                                     //wird das Ausgabefeld geleert
        }
        
        if (e.getSource() == gleichButton) {                          //Sobald der Gleich-Button gedrückt wird,
            nummer2 = Double.parseDouble(textfeld.getText());         //wird der zuvor eingegebene Wert in "nummer2" gespeichert
                
            switch(operator) {                                        //Der Operator entscheidet, wie mit "nummer1" und "nummer" verfahren wird
                case '+': ergebnis = nummer1 + nummer2;
                break;
                
                case '-': ergebnis = nummer1 - nummer2;
                break;
                
                case '*': ergebnis = nummer1 * nummer2;
                break;
                
                case '/': ergebnis = nummer1 / nummer2;
                break;
            }
            
            textfeld.setText(String.valueOf(ergebnis));               //Dem Textfeld wird das Ergebnis hinzugefügt
        }
    }
}
