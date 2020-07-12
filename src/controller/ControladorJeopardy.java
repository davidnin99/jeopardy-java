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
import view.VentanaPreguntasGUI;
import view.ViewJeopardy;

/**
 *
 * @author usuario
 */
public class ControladorJeopardy implements ActionListener {

    private ViewJeopardy viewJeopardy;
    private Tablero tablero;

    public ControladorJeopardy(ViewJeopardy viewJeopardy, Tablero model) {
        this.viewJeopardy = viewJeopardy;
        this.tablero = model;

        //ponemos los nombres que nos ha pasado la pantalla jugadores en el tablero
        this.viewJeopardy.getLabelJ1().setText(this.tablero.getJugador1().getNombreJugador());
        this.viewJeopardy.getLabelJ2().setText(this.tablero.getJugador2().getNombreJugador());

        //ponemos las puntuaciones que nos ha pasado la pantalla jugadores en el tablero
        this.viewJeopardy.getPuntuacionJ1().setText(String.valueOf(this.tablero.getJugador1().getPuntuacion()));
        this.viewJeopardy.getPuntuacionJ2().setText(String.valueOf(this.tablero.getJugador2().getPuntuacion()));

        //ponemos el turno que nos ha pasado la pantalla jugadores en el tablero
        this.viewJeopardy.getTurno().setText(String.valueOf(this.tablero.getTurno()));

        //set categorias in GUI
        String[] categorias = this.tablero.getCategorias();
        for (int i = 0; i < categorias.length; i++) {
            this.viewJeopardy.getCategorias()[i].setText(categorias[i]);
        }

        //Add listeners to the view
        for (int i = 0; i < viewJeopardy.getButtons().length; i++) {
            viewJeopardy.getButtons()[i].addActionListener(this);

        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        for (int i = 0; i < viewJeopardy.getButtons().length; i++) {
            if (ae.getSource() == viewJeopardy.getButtons()[i]) {
                Pregunta pregunta = tablero.getPregunta(i);
                viewJeopardy.getButtons()[i].setEnabled(false);
                VentanaPreguntasGUI viewPreguntas = new VentanaPreguntasGUI();
                ControladorPreguntas controladorPreguntas = new ControladorPreguntas(pregunta, viewPreguntas, viewJeopardy, tablero, i);
                viewJeopardy.setVisible(false);

            }
        }

    }
}
