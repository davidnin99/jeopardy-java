/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Pregunta;
import model.Tablero;
import view.VentanaFinal;
import view.VentanaPreguntasGUI;
import view.ViewJeopardy;
import java.awt.event.ActionListener;

/**
 *
 * @author usuario
 */
public class ControladorFinal implements ActionListener {

    private VentanaFinal ventanaFinal;
    private Tablero tablero;
    private ViewJeopardy viewJeopardy;
    private Pregunta pregunta;
    private int i;
    private int contadorJ1, contadorJ2;

    public ControladorFinal(VentanaFinal ventanaFinal, Tablero tablero, ViewJeopardy viewJeopardy, Pregunta pregunta) {
        this.ventanaFinal = ventanaFinal;
        this.tablero = tablero;
        this.viewJeopardy = viewJeopardy;
        this.pregunta = pregunta;

        if (tablero.getTurno() == 26) {
            this.i = 0;
            this.contadorJ1 = 0;
            this.contadorJ2 = 0;
            ventanaFinal.getNumPreguntaJ1().setText(contadorJ1 + " de 5");
            ventanaFinal.getNumPreguntaJ2().setText(contadorJ2 + " de 5");
            this.ventanaFinal.getTextoJ1().setText(this.tablero.getJugador1().getNombreJugador());
            this.ventanaFinal.getTextoJ2().setText(this.tablero.getJugador2().getNombreJugador());

            //Add listeners to the view
            ventanaFinal.getButton().addActionListener(this);
        }

    }

    public ControladorFinal(VentanaFinal ventanaFinal, Tablero tablero, ViewJeopardy viewJeopardy, Pregunta pregunta, int contadorJ1, int contadorJ2) {

    }

    @Override
    public void actionPerformed(ActionEvent ae) {  //en el turno 26 se crea el action performed entonces la i es 0 y cada vez q se llama a este metodo (creado en el 26, i=0) la i de ese controlador final se aumenta 
        if (ae.getSource() == ventanaFinal.getButton()) {
            //view.setVisible(false);   
            ventanaFinal.setVisible(false);

            VentanaPreguntasGUI ventanaPregunta = new VentanaPreguntasGUI();
            Pregunta pregunta = tablero.getPreguntaFinalRound(i);
            ControladorPreguntas controller = new ControladorPreguntas(pregunta, ventanaPregunta, viewJeopardy, tablero, ventanaFinal);

            i = i + 1;

            if (tablero.isJ1Juega() == true) {
                contadorJ1 = contadorJ1 + 1;
                ventanaFinal.getNumPreguntaJ1().setText(contadorJ1 + " de 5");
            } else {
                contadorJ2 = contadorJ2 + 1;
                ventanaFinal.getNumPreguntaJ2().setText(contadorJ2 + " de 5");
            }
        }
    }
}
