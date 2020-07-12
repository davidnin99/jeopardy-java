/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import model.Pregunta;
import model.Tablero;
import view.VentanaEmpate;
import view.VentanaFinal;
import view.VentanaPreguntasGUI;
import view.ViewJeopardy;

/**
 *
 * @author usuario
 */
public class ControladorPreguntas implements ActionListener {

    private Pregunta pregunta;
    private VentanaPreguntasGUI ventanaPreguntas;
    private int respuestaSeleccionada;
    private ViewJeopardy viewJeopardy;
    private Tablero tablero;
    private int posicionPregunta;
    private VentanaFinal viewVentanaFinal;

    public ControladorPreguntas(Pregunta pregunta, VentanaPreguntasGUI ventanaPreguntas, ViewJeopardy viewJeopardy, Tablero tablero, int posicionPregunta) {
        this.pregunta = pregunta;
        this.ventanaPreguntas = ventanaPreguntas;
        this.viewJeopardy = viewJeopardy;
        this.tablero = tablero;
        this.posicionPregunta = posicionPregunta;

        mostrarPregunta();

        ventanaPreguntas.getResponderBotton().addActionListener(this);
    }

    public ControladorPreguntas(Pregunta pregunta, VentanaPreguntasGUI ventanaPreguntas, ViewJeopardy viewJeopardy, Tablero tablero, VentanaFinal viewVentanaFinal) {
        this.pregunta = pregunta;
        this.tablero = tablero;

        this.ventanaPreguntas = ventanaPreguntas;
        this.viewJeopardy = viewJeopardy;
        this.viewVentanaFinal = viewVentanaFinal;

        mostrarPregunta();

        //Add listeners to the view
        ventanaPreguntas.getResponderBotton().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        respuestaSeleccionada = Integer.parseInt(ventanaPreguntas.getGroup().getSelection().getActionCommand());//0,1,2
        if (tablero.getTurno() < 26) {
            if (ae.getSource() == ventanaPreguntas.getResponderBotton()) {
                isRespuestaCorrecta();

                isRespuestaErronea();
                tablero.aumentarTurno();
                tablero.aQuienLeTocaJugar();
                tablero.cambiarColorLetras();

                ventanaPreguntas.getResponderBotton().setEnabled(false);

            }

        } else {
            if (ae.getSource() == ventanaPreguntas.getResponderBotton()) {
                ventanaPreguntas.getResponderBotton().setEnabled(false);
                isRespuestaCorrecta();
                isRespuestaErronea();
                tablero.aumentarTurno();
                tablero.aQuienLeTocaJugar();
            }
        }
        ventanaPreguntas.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent ae) {
                if (tablero.getTurno() < 26) {
                    viewJeopardy.setVisible(true);
                    tablero.colocarPuntuacionPreguntas();
                    ventanaPreguntas.setVisible(false);
                } else if (tablero.getTurno() == 26) {
                    if (tablero.getJugador1().getPuntuacion() > tablero.getJugador2().getPuntuacion()) {
                        tablero.getJugador1().haGanado();
                        JOptionPane.showMessageDialog(ventanaPreguntas, tablero.getJugador1().getNombreJugador() + "ha ganao la partida", "Gana J1", JOptionPane.INFORMATION_MESSAGE);
                    } else if (tablero.getJugador1().getPuntuacion() < tablero.getJugador2().getPuntuacion()) {
                        tablero.getJugador2().haGanado();
                        JOptionPane.showMessageDialog(ventanaPreguntas, tablero.getJugador2().getNombreJugador() + "ha ganao la partida", "Gana J2", JOptionPane.INFORMATION_MESSAGE);
                    } else if (tablero.getJugador1().getPuntuacion() == tablero.getJugador2().getPuntuacion()) {
                        ventanaPreguntas.setVisible(false);
                        VentanaEmpate ventanaEmpate = new VentanaEmpate();
                        ControladorEmpate controladorEmpate = new ControladorEmpate(ventanaEmpate, tablero, viewJeopardy, pregunta);

                    }
                } else if (tablero.getTurno() >= 26 && tablero.getTurno() < 36) {
                    if (pregunta.isRespuestaCorrecta(respuestaSeleccionada)) {
                        viewVentanaFinal.setVisible(true);

                        if (tablero.isJ1Juega()) {
                            viewVentanaFinal.getTextoJ1().setForeground(Color.GREEN);
                            viewVentanaFinal.getNumPreguntaJ1().setForeground(Color.GREEN);
                            viewVentanaFinal.getTextoNumPreguntaJ1().setForeground(Color.GREEN);
                            viewVentanaFinal.getTextoJ2().setForeground(Color.BLACK);
                            viewVentanaFinal.getNumPreguntaJ2().setForeground(Color.BLACK);
                            viewVentanaFinal.getTextoNumPreguntaJ2().setForeground(Color.BLACK);
                        } else {
                            viewVentanaFinal.getTextoJ1().setForeground(Color.BLACK);
                            viewVentanaFinal.getNumPreguntaJ1().setForeground(Color.BLACK);
                            viewVentanaFinal.getTextoNumPreguntaJ1().setForeground(Color.BLACK);
                            viewVentanaFinal.getTextoJ2().setForeground(Color.GREEN);
                            viewVentanaFinal.getNumPreguntaJ2().setForeground(Color.GREEN);
                            viewVentanaFinal.getTextoNumPreguntaJ2().setForeground(Color.GREEN);
                        }
                        ControladorFinal controladorFinal = new ControladorFinal(viewVentanaFinal, tablero, viewJeopardy, pregunta);

                    } else {
                        if (tablero.isJ1Juega()) {//si juega jugador1 el jugador2 ha fallado ergo gana jugador 1
                            JOptionPane.showMessageDialog(ventanaPreguntas.getFinalFrame(), tablero.getJugador2().getNombreJugador() + " ha fallado la pregunta, eso quiere decir que " + tablero.getJugador1().getNombreJugador() + " ha ganado la partida.", "Gana J1", JOptionPane.INFORMATION_MESSAGE);
                            ventanaPreguntas.setDefaultCloseOperation(ventanaPreguntas.getFinalFrame().EXIT_ON_CLOSE);

                        } else {
                            JOptionPane.showMessageDialog(ventanaPreguntas.getFinalFrame(), tablero.getJugador1().getNombreJugador() + " ha fallado la pregunta, eso quiere decir que " + tablero.getJugador2().getNombreJugador() + " ha ganado la partida.", "Gana J1", JOptionPane.INFORMATION_MESSAGE);
                            ventanaPreguntas.setDefaultCloseOperation(ventanaPreguntas.getFinalFrame().EXIT_ON_CLOSE);

                        }
                    }
                } else if (tablero.getTurno() == 36) {
                    if (pregunta.isRespuestaCorrecta(respuestaSeleccionada)) {
                        JOptionPane.showMessageDialog(ventanaPreguntas.getFinalFrame(), " Habeis acertado todas las preguntas de la Final Round. Habeis quedado empate.", "Empate", JOptionPane.INFORMATION_MESSAGE);
                        ventanaPreguntas.setDefaultCloseOperation(ventanaPreguntas.getFinalFrame().EXIT_ON_CLOSE);
                    } else {
                        if (tablero.isJ1Juega()) {//si juega jugador1 el jugador2 ha fallado ergo gana jugador 1
                            JOptionPane.showMessageDialog(ventanaPreguntas.getFinalFrame(), tablero.getJugador2().getNombreJugador() + " ha fallado la pregunta, eso quiere decir que " + tablero.getJugador1().getNombreJugador() + " ha ganado la partida.", "Gana J1", JOptionPane.INFORMATION_MESSAGE);
                            ventanaPreguntas.setDefaultCloseOperation(ventanaPreguntas.getFinalFrame().EXIT_ON_CLOSE);

                        } else {
                            JOptionPane.showMessageDialog(ventanaPreguntas.getFinalFrame(), tablero.getJugador1().getNombreJugador() + " ha fallado la pregunta, eso quiere decir que " + tablero.getJugador2().getNombreJugador() + " ha ganado la partida.", "Gana J1", JOptionPane.INFORMATION_MESSAGE);
                            ventanaPreguntas.setDefaultCloseOperation(ventanaPreguntas.getFinalFrame().EXIT_ON_CLOSE);

                        }
                    }
                }
            }

        });

    }

    private void isRespuestaCorrecta() {
        if (pregunta.isRespuestaCorrecta(respuestaSeleccionada) == true) {
            if (respuestaSeleccionada == 0) {
                ventanaPreguntas.getButton1().setForeground(Color.GREEN);
            }
            if (respuestaSeleccionada == 1) {
                ventanaPreguntas.getButton2().setForeground(Color.GREEN);
            }
            if (respuestaSeleccionada == 2) {
                ventanaPreguntas.getButton3().setForeground(Color.GREEN);
            }
            tablero.saberPuntuacionQueSeVaASumar(posicionPregunta);
        }

    }

    private void isRespuestaErronea() {
        if (pregunta.isRespuestaCorrecta(respuestaSeleccionada) == false) {
            if (respuestaSeleccionada == 0) {
                ventanaPreguntas.getButton1().setForeground(Color.RED);
            }
            if (respuestaSeleccionada == 1) {
                ventanaPreguntas.getButton2().setForeground(Color.RED);
            }
            if (respuestaSeleccionada == 2) {
                ventanaPreguntas.getButton3().setForeground(Color.RED);
            }
            tablero.saberPuntuacionQueSeVaARestar(posicionPregunta);
        }
    }

    public void mostrarPregunta() {
        ventanaPreguntas.getLabelCategoria().setText(pregunta.getCategoria());
        ventanaPreguntas.getLabelPregunta().setText(pregunta.getTextoPregunta());
        ventanaPreguntas.getButton1().setText(pregunta.getRespuestas(0));
        ventanaPreguntas.getButton2().setText(pregunta.getRespuestas(1));
        ventanaPreguntas.getButton3().setText(pregunta.getRespuestas(2));
    }

}
