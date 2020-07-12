/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.ViewJeopardy;

/**
 *
 * @author usuario
 */
public class Tablero {

    
    private Set<Pregunta> preguntas = new LinkedHashSet<>();
    private Set<Pregunta> preguntasFinalRound = new LinkedHashSet<>();
    private int turno;
    private boolean J1Juega = true;
    private ViewJeopardy viewJeopardy;
    private Jugador jugador1;
    private Jugador jugador2;
    
    
    public Tablero(Jugador J1, Jugador J2, ViewJeopardy view) {
        this.turno = 0;
        this.viewJeopardy = view;
        this.jugador1 = J1;
        this.jugador2 = J2;
        
        try {
            cargarDatos();       
        } catch (IOException ex) {
            Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
        }
         colocarPuntuacionPreguntas(); 
        
        aQuienLeTocaJugar();
        
        cambiarColorLetras();
        
    }

    private void cargarDatos() throws IOException{
        
        FileReader frEntrada = new FileReader("preguntasJeopardy.txt");
        BufferedReader brEntrada = new BufferedReader(frEntrada); 
        String frase;

        frase = brEntrada.readLine();
        while (frase != null){
            String[] valores = frase.split(";");
            Pregunta p = new Pregunta(valores[0],Integer.parseInt(valores[1]),Integer.parseInt(valores[2]),valores[3], valores[4], valores[5], valores[6]);
            preguntas.add(p);
            frase = brEntrada.readLine();
        } 
    }
     public void cargarDatosFinalRound() throws IOException{
        
        FileReader frEntrada = new FileReader("preguntasFinalRound.txt");
        BufferedReader brEntrada = new BufferedReader(frEntrada); 
        String frase;

        frase = brEntrada.readLine();
        while (frase != null){
            String[] valores = frase.split(";");
            Pregunta p = new Pregunta(valores[0],Integer.parseInt(valores[1]),Integer.parseInt(valores[2]),valores[3], valores[4], valores[5], valores[6]);
            preguntasFinalRound.add(p);
            frase = brEntrada.readLine();
        } 
    }
    
    public String[] getCategorias(){
        Set<String> categorias = new LinkedHashSet<>();
        for (Pregunta pregunta : preguntas){
            categorias.add(pregunta.getCategoria());
        }
        String[] result = categorias.toArray(new String[categorias.size()]);
        return result;
    }
    
    public Pregunta getPregunta(int i){
        int indiceFila = i/5;
        int indiceColumna = i%5;

        Pregunta[] p = preguntas.toArray(new Pregunta[preguntas.size()]);
        return p[indiceFila+5*indiceColumna];

    } 
    public void colocarPuntuacionPreguntas(){
        if(turno <= 9){
            for (int i = 0; i < viewJeopardy.getButtons().length; i++) {
                Pregunta p = getPregunta(i);
                int puntuacion = p.getPuntuacion();
                viewJeopardy.getButtons()[i].setText(String.valueOf(puntuacion));
            } }
        if(turno == 10){
            JOptionPane.showMessageDialog(viewJeopardy.getF(), "Habeis llegado a la Double Jeopardy Round, donde la puntuacion de cada pregunta se multiplica X2.", "Double Jeopardy Round", JOptionPane.INFORMATION_MESSAGE);
        }if(turno >= 10 && turno <= 25){
            for (int i = 0; i < viewJeopardy.getButtons().length; i++) {
                Pregunta p = getPregunta(i);
                int puntuacion = p.getPuntuacion() * 2;
                viewJeopardy.getButtons()[i].setText(String.valueOf(puntuacion));
            } 
        }
         
        
    }
    
    public void saberPuntuacionQueSeVaASumar(int i){
        int puntuacion = 0;
        Pregunta p = getPregunta(i);
        
        if(turno <= 10){
            puntuacion = p.getPuntuacion();
        }else if(turno >= 11 && turno <= 25){
            puntuacion = p.getPuntuacion() * 2;
        }    
         
        if(J1Juega == true){
            jugador1.actualizarPuntuacion(puntuacion);
            viewJeopardy.getPuntuacionJ1().setText(String.valueOf(jugador1.getPuntuacion())); 
        }else{
            jugador2.actualizarPuntuacion(puntuacion);
            viewJeopardy.getPuntuacionJ2().setText(String.valueOf(jugador2.getPuntuacion())); 
        }
    }
     public void saberPuntuacionQueSeVaARestar(int i){
        int puntuacion = 0;
        Pregunta p = getPregunta(i);
        
        if(turno <= 10){
            puntuacion = puntuacion-p.getPuntuacion();
            
        }else if(turno >= 11 && turno <= 25){
            puntuacion = puntuacion-p.getPuntuacion() * 2;
            if(puntuacion < 0){
                puntuacion = 0;
            }
        }    
         
        if(J1Juega == true){
            if(puntuacion <0){
                jugador1.actualizarPuntuacion(0);
                viewJeopardy.getPuntuacionJ1().setText("0"); 
            }else{
            jugador1.actualizarPuntuacion(puntuacion);
            viewJeopardy.getPuntuacionJ1().setText(String.valueOf(jugador1.getPuntuacion())); 
            }
            
        }else{
            if(puntuacion <0){
                jugador2.actualizarPuntuacion(0);
                viewJeopardy.getPuntuacionJ2().setText("0"); 
            }else{
            jugador2.actualizarPuntuacion(puntuacion);
            viewJeopardy.getPuntuacionJ2().setText(String.valueOf(jugador2.getPuntuacion())); 
            }
        }
    }
    
    
    
    public int getTurno(){;
        return turno;
    }
    
    public void aumentarTurno(){
        turno = turno + 1;
        viewJeopardy.getTurno().setText(String.valueOf(turno));
    }
    
    public void aQuienLeTocaJugar(){
        if(turno%2 == 1){ //juega el J1
            J1Juega = true;
        }else{ //juega el J2
            J1Juega = false;
        }  
    }
    public void cambiarColorLetras(){
        if(J1Juega == true){
            viewJeopardy.getTextoJ1().setForeground(Color.GREEN);
            viewJeopardy.getLabelJ1().setForeground(Color.GREEN);
            viewJeopardy.getTextoPuntuacionJ1().setForeground(Color.GREEN);
            viewJeopardy.getPuntuacionJ1().setForeground(Color.GREEN);
            
            viewJeopardy.getTextoJ2().setForeground(Color.BLACK);
            viewJeopardy.getLabelJ2().setForeground(Color.BLACK);
            viewJeopardy.getTextoPuntuacionJ2().setForeground(Color.BLACK);
            viewJeopardy.getPuntuacionJ2().setForeground(Color.BLACK);
        }else{
            viewJeopardy.getTextoJ2().setForeground(Color.GREEN);
            viewJeopardy.getLabelJ2().setForeground(Color.GREEN);
            viewJeopardy.getTextoPuntuacionJ2().setForeground(Color.GREEN);
            viewJeopardy.getPuntuacionJ2().setForeground(Color.GREEN);
            
            viewJeopardy.getTextoJ1().setForeground(Color.BLACK);
            viewJeopardy.getLabelJ1().setForeground(Color.BLACK);
            viewJeopardy.getTextoPuntuacionJ1().setForeground(Color.BLACK);
            viewJeopardy.getPuntuacionJ1().setForeground(Color.BLACK);
        }
    }
        
    public Pregunta getPreguntaFinalRound(int i){
        Pregunta[] p = preguntasFinalRound.toArray(new Pregunta[preguntasFinalRound.size()]);

        return p[i];
    }
    
    
    public Set<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Set<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public Set<Pregunta> getPreguntasFinalRound() {
        return preguntasFinalRound;
    }

    public void setPreguntasFinalRound(Set<Pregunta> preguntasFinalRound) {
        this.preguntasFinalRound = preguntasFinalRound;
    }

    public boolean isJ1Juega() {
        return J1Juega;
    }

    public void setJ1Juega(boolean J1Juega) {
        this.J1Juega = J1Juega;
    }

    public ViewJeopardy getViewJeopardy() {
        return viewJeopardy;
    }

    public void setViewJeopardy(ViewJeopardy viewJeopardy) {
        this.viewJeopardy = viewJeopardy;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }
    
    
}

