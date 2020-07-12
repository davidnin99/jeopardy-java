/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author usuario
 */
public class VentanaEmpate extends JFrame {
    
    private JLabel text;
    private JButton button;
    
    public VentanaEmpate(){
        this.setTitle("Ha habido un Empate");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        addComponentsToPanel(this.getContentPane());
        this.setResizable(false);
        //this.pack();
        this.setVisible(true);
        this.setSize(300,200);
    }
    
    public void addComponentsToPanel(Container pane){
          pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
          
          text = new JLabel();
          text.setText("Ha habido un empate. El ganador de este juego se disputira en la Gran Ronda Final, <br>en la cual consiste enn 10 preguntas , el primero que falle pierde. Si los dos acertais todas , quedais empate otra vez (esta vez indefinido)");
          pane.add(text );
          
          button = new JButton();
          button.setText("Boton");
          pane.add(button); 
    }

    public JLabel getText() {
        return text;
    }

    public void setText(JLabel text) {
        this.text = text;
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }
    
}
