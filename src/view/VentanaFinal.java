/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author usuario
 */
public class VentanaFinal extends JFrame{
  public JButton button;
  private JLabel textoJ1, textoJ2, textoNumPreguntaJ1, textoNumPreguntaJ2, numPreguntaJ1, numPreguntaJ2;

  
  public VentanaFinal(){
        this.setTitle("Nueva pregunta");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        addComponentsToPane(this.getContentPane());
        this.setResizable(false); // no se puede hacer pequeño ni grande la pamtala
        this.setSize(new Dimension(400,100));
        //this.pack(); //el tamaño de la pantalla se adecua al tamaño de los conmponentes, contra mas cosas tenga dentro la pantalla mas grande sera
        this.setVisible(true);
        
    }
  
  private void addComponentsToPane(Container pane) {
        pane.setLayout(new BorderLayout());
        
        JPanel pane2 = new JPanel(new BorderLayout());
        JPanel pane3 = new JPanel(new BorderLayout());
        
        textoJ1 = new JLabel();
        textoJ1.setText("jugador1");        
        textoJ1.setHorizontalAlignment(SwingConstants.CENTER);
        pane2.add(textoJ1, BorderLayout.NORTH);
        
        textoJ2 = new JLabel();
        textoJ2.setText("jugador2");
        textoJ2.setForeground(Color.green);
        textoJ2.setHorizontalAlignment(SwingConstants.CENTER);
        pane3.add(textoJ2, BorderLayout.NORTH);
        
        textoNumPreguntaJ1 = new JLabel();
        textoNumPreguntaJ1.setText("Preguntas respondidas:");
        pane2.add(textoNumPreguntaJ1, BorderLayout.CENTER);
        
        textoNumPreguntaJ2 = new JLabel();
        textoNumPreguntaJ2.setText("Preguntas respondidas:");
        textoNumPreguntaJ2.setForeground(Color.green);
        pane3.add(textoNumPreguntaJ2, BorderLayout.CENTER);
        
        numPreguntaJ1 = new JLabel();
        numPreguntaJ1.setText(" de 5");
        numPreguntaJ1.setHorizontalAlignment(SwingConstants.CENTER);
        pane2.add(numPreguntaJ1, BorderLayout.SOUTH);
        
        numPreguntaJ2 = new JLabel();
        numPreguntaJ2.setText(" de 5");
        numPreguntaJ2.setForeground(Color.green);
        numPreguntaJ2.setHorizontalAlignment(SwingConstants.CENTER);
        pane3.add(numPreguntaJ2, BorderLayout.SOUTH);
        
        pane.add(pane2, BorderLayout.WEST);
        pane.add(pane3, BorderLayout.EAST);
        
        button = new JButton("Continuar");
        pane.add(button, BorderLayout.SOUTH);
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public JLabel getTextoJ1() {
        return textoJ1;
    }

    public void setTextoJ1(JLabel textoJ1) {
        this.textoJ1 = textoJ1;
    }

    public JLabel getTextoJ2() {
        return textoJ2;
    }

    public void setTextoJ2(JLabel textoJ2) {
        this.textoJ2 = textoJ2;
    }

    public JLabel getTextoNumPreguntaJ1() {
        return textoNumPreguntaJ1;
    }

    public void setTextoNumPreguntaJ1(JLabel textoNumPreguntaJ1) {
        this.textoNumPreguntaJ1 = textoNumPreguntaJ1;
    }

    public JLabel getTextoNumPreguntaJ2() {
        return textoNumPreguntaJ2;
    }

    public void setTextoNumPreguntaJ2(JLabel textoNumPreguntaJ2) {
        this.textoNumPreguntaJ2 = textoNumPreguntaJ2;
    }

    public JLabel getNumPreguntaJ1() {
        return numPreguntaJ1;
    }

    public void setNumPreguntaJ1(JLabel numPreguntaJ1) {
        this.numPreguntaJ1 = numPreguntaJ1;
    }

    public JLabel getNumPreguntaJ2() {
        return numPreguntaJ2;
    }

    public void setNumPreguntaJ2(JLabel numPreguntaJ2) {
        this.numPreguntaJ2 = numPreguntaJ2;
    }
  
}
