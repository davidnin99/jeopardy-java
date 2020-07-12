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
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author usuario
 */
public class ViewJeopardy extends JFrame {

    private JLabel nombreJugador1, nombreJugador2, puntuacionJ1, puntuacionJ2, turno, textoTurno, jugador1, jugador2, textoPuntuacionJ1, textoPuntuacionJ2;
    private JButton[] buttons;
    private JLabel[] categorias;
    private JFrame f;

    public ViewJeopardy() {
        this.setTitle("Jeopardy");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addComponentsToPane(this.getContentPane());
        this.setResizable(false);

        this.pack();
        this.setVisible(true);
    }

    private void addComponentsToPane(Container pane) {
        pane.setLayout(new BorderLayout(0, 5));

        //JPanel categorias
        JPanel PanelCategorias = new JPanel(new FlowLayout(FlowLayout.LEFT));
        String[] values = {"categoria 1", "categoria 2", "categoria 3", "categoria 4", "categoria 5"};
        categorias = new JLabel[values.length];
        for (int i = 0; i < values.length; i++) {
            categorias[i] = new JLabel(values[i]);
            categorias[i].setPreferredSize(new Dimension(150, 100));
            categorias[i].setHorizontalAlignment(SwingConstants.CENTER);
            categorias[i].setOpaque(true);
            categorias[i].setBackground(Color.WHITE);
            categorias[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            PanelCategorias.add(categorias[i]);
        }
        pane.add(PanelCategorias, BorderLayout.NORTH);

        //JPanel buttons
        JPanel buttonsPanel = new JPanel(new GridLayout(5, 5));
        String[] values2 = {"100€", "100€", "100€", "100€", "100€", "200€", "200€", "200€", "200€", "200€", "300€", "300€", "300€", "300€", "300€", "400€", "400€", "400€", "400€", "400€", "500€", "500€", "500€", "500€", "500€"};
        //String[] values2 = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
        buttons = new JButton[values2.length];
        for (int i = 0; i < values2.length; i++) {
            buttons[i] = new JButton(values2[i]);
            buttons[i].setPreferredSize(new Dimension(150, 100));
            buttonsPanel.add(buttons[i]);
        }
        pane.add(buttonsPanel, BorderLayout.CENTER);

        //JPanel Jugadores
        JPanel PanelJugadores = new JPanel(new GridLayout(2, 5));
        PanelJugadores.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        PanelJugadores.setBackground(Color.WHITE);

        //Jlabel 
        jugador1 = new JLabel();
        jugador1.setText("Jugador 1: ");
        jugador1.setHorizontalAlignment(SwingConstants.RIGHT);

        PanelJugadores.add(jugador1);

        //Jlabel
        nombreJugador1 = new JLabel();
        nombreJugador1.setText("Nombre J1");
        PanelJugadores.add(nombreJugador1);

        //Jlabel 
        textoTurno = new JLabel();
        textoTurno.setText("Turno:");
        textoTurno.setHorizontalAlignment(SwingConstants.CENTER);
        PanelJugadores.add(textoTurno);

        //Jlabel 
        jugador2 = new JLabel();
        jugador2.setText("Jugador 2: ");
        jugador2.setHorizontalAlignment(SwingConstants.RIGHT);
        PanelJugadores.add(jugador2);

        //Jlabel J2
        nombreJugador2 = new JLabel();
        nombreJugador2.setText("Nombre J2");
        PanelJugadores.add(nombreJugador2);

        //Jlabel texto Puntuacion J1
        textoPuntuacionJ1 = new JLabel();
        textoPuntuacionJ1.setText("Puntuacion: ");
        textoPuntuacionJ1.setHorizontalAlignment(SwingConstants.RIGHT);
        PanelJugadores.add(textoPuntuacionJ1);

        //Jlabel puntuacion J1
        puntuacionJ1 = new JLabel();
        puntuacionJ1.setText("**** €");
        PanelJugadores.add(puntuacionJ1);

        //Jlabel turno
        turno = new JLabel();
        turno.setText("*");
        turno.setHorizontalAlignment(SwingConstants.CENTER);
        PanelJugadores.add(turno);

        //Jlabel texto puntuacion J2
        textoPuntuacionJ2 = new JLabel();
        textoPuntuacionJ2.setText("Puntuacion: ");
        textoPuntuacionJ2.setHorizontalAlignment(SwingConstants.RIGHT);
        PanelJugadores.add(textoPuntuacionJ2);

        //Jlabel puntuacion J2
        puntuacionJ2 = new JLabel();
        puntuacionJ2.setText("**** €");
        PanelJugadores.add(puntuacionJ2);
        pane.add(PanelJugadores, BorderLayout.SOUTH);

    }

    public JLabel getLabelJ1() {
        return nombreJugador1;
    }

    public void setLabelJ1(JLabel labelJ1) {
        this.nombreJugador1 = labelJ1;
    }

    public JLabel getLabelJ2() {
        return nombreJugador2;
    }

    public void setLabelJ2(JLabel labelJ2) {
        this.nombreJugador2 = labelJ2;
    }

    public JLabel getPuntuacionJ1() {
        return puntuacionJ1;
    }

    public void setPuntuacionJ1(JLabel puntuacionJ1) {
        this.puntuacionJ1 = puntuacionJ1;
    }

    public JLabel getPuntuacionJ2() {
        return puntuacionJ2;
    }

    public void setPuntuacionJ2(JLabel puntuacionJ2) {
        this.puntuacionJ2 = puntuacionJ2;
    }

    public JLabel getTurno() {
        return turno;
    }

    public void setTurno(JLabel turno) {
        this.turno = turno;
    }

    public JLabel getTextoTurno() {
        return textoTurno;
    }

    public void setTextoTurno(JLabel textoTurno) {
        this.textoTurno = textoTurno;
    }

    public JLabel getTextoJ1() {
        return jugador1;
    }

    public void setTextoJ1(JLabel textoJ1) {
        this.jugador1 = textoJ1;
    }

    public JLabel getTextoJ2() {
        return jugador2;
    }

    public void setTextoJ2(JLabel textoJ2) {
        this.jugador2 = textoJ2;
    }

    public JLabel getTextoPuntuacionJ1() {
        return textoPuntuacionJ1;
    }

    public void setTextoPuntuacionJ1(JLabel textoPuntuacionJ1) {
        this.textoPuntuacionJ1 = textoPuntuacionJ1;
    }

    public JLabel getTextoPuntuacionJ2() {
        return textoPuntuacionJ2;
    }

    public void setTextoPuntuacionJ2(JLabel textoPuntuacionJ2) {
        this.textoPuntuacionJ2 = textoPuntuacionJ2;
    }

    public JButton[] getButtons() {
        return buttons;
    }

    public void setButtons(JButton[] buttons) {
        this.buttons = buttons;
    }

    public JLabel[] getCategorias() {
        return categorias;
    }

    public void setCategorias(JLabel[] categorias) {
        this.categorias = categorias;
    }

    public JFrame getF() {
        return f;
    }

    public void setF(JFrame f) {
        this.f = f;
    }
}
