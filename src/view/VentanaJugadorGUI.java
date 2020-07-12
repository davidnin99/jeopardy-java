/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author usuario
 */
public class VentanaJugadorGUI extends JFrame {

    private JTextField nombreJugador1, nombreJugador2;
    private JButton play;
    private JLabel labelNombre1, labelNombre2, labelTitulo;
    private JFrame frame;

    public VentanaJugadorGUI() {
        this.setTitle("Jeopardy");
        this.setPreferredSize(new Dimension(300, 150));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addComponentsToPane(this.getContentPane());
        this.setResizable(false); // no se puede hacer pequeño ni grande la pantala

        this.pack(); //el tamaño de la pantalla se adecua al tamaño de los conmponentes, contra mas cosas tenga dentro la pantalla mas grande sera
        this.setVisible(true);
    }
    
    private void addComponentsToPane(Container panel) {
        panel.setLayout(new BorderLayout(0, 10));

        //Jlabel
        labelTitulo = new JLabel();
        labelTitulo.setText("Introduce los nombres de los jugadores");
        panel.add(labelTitulo, BorderLayout.NORTH);

        //panel2
        JPanel panel2 = new JPanel(new GridLayout(3, 2));

        //Jlabel
        labelNombre1 = new JLabel();
        labelNombre1.setText("Nombre Jugador 1: ");
        panel2.add(labelNombre1);

        //textField
        nombreJugador1 = new JTextField();
        //text1.setActionCommand(TEXTFIELD_STRING1);
        nombreJugador1.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel2.add(nombreJugador1);

        //Jlabel
        labelNombre2 = new JLabel();
        labelNombre2.setText("Nombre Jugador 2: ");
        panel2.add(labelNombre2);

        //textField
        nombreJugador2 = new JTextField();
        //text2.setActionCommand(TEXTFIELD_STRING2);
        nombreJugador2.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel2.add(nombreJugador2);

        panel.add(panel2, BorderLayout.CENTER);

        //Jbutton
        play = new JButton("Jugar");
        play.setVerticalTextPosition(AbstractButton.CENTER);
        play.setHorizontalTextPosition(AbstractButton.CENTER);
        play.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(play, BorderLayout.SOUTH);
    }

    public JTextField getNombreJugador1() {
        return nombreJugador1;
    }

    public void setNombreJugador1(JTextField nombreJugador1) {
        this.nombreJugador1 = nombreJugador1;
    }

    public JTextField getNombreJugador2() {
        return nombreJugador2;
    }

    public void setNombreJugador2(JTextField nombreJugador2) {
        this.nombreJugador2 = nombreJugador2;
    }

    public JButton getPlay() {
        return play;
    }

    public void setPlay(JButton play) {
        this.play = play;
    }

    public JLabel getLabelNombre1() {
        return labelNombre1;
    }

    public void setLabelNombre1(JLabel labelNombre1) {
        this.labelNombre1 = labelNombre1;
    }

    public JLabel getLabelNombre2() {
        return labelNombre2;
    }

    public void setLabelNombre2(JLabel labelNombre2) {
        this.labelNombre2 = labelNombre2;
    }

    public JLabel getLabelTitulo() {
        return labelTitulo;
    }

    public void setLabelTitulo(JLabel labelTitulo) {
        this.labelTitulo = labelTitulo;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
    
    
}
