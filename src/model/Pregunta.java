/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.JFrame;

/**
 *
 * @author usuario
 */

public class Pregunta extends JFrame{
    private int puntuacion, respuestaCorrecta;
    private String categoria;
    private String textoPregunta;
    private String[] respuestas;
    private boolean finalRespuestaCorrecta = false;

    public Pregunta() {
    }

    public Pregunta(String categoria, int respuestaCorrecta, int puntuacion, String pregunta, String respuesta1, String respuesta2, String respuesta3) {
        this.categoria = categoria;       
        this.textoPregunta = pregunta;
        this.puntuacion = puntuacion;
        this.respuestaCorrecta = respuestaCorrecta;
        this.respuestas = new String[3];
        this.respuestas[0] = respuesta1;
        this.respuestas[1] = respuesta2;
        this.respuestas[2]=respuesta3;
    }
    
    public void setFinalRespuestaCorrecta(boolean finalRespuestaCorrecta){
        this.finalRespuestaCorrecta = finalRespuestaCorrecta;
    }
    
    public boolean isRespuestaCorrecta(int respuestaSeleccionada){
        if(respuestaCorrecta == respuestaSeleccionada){
            return true;
        }else{
            return false;
        }
    }
    
    public String getCategoria(){
        return categoria;
    }
    
    public String getTextoPregunta(){
        return textoPregunta;
    }
    
    public int getPuntuacion(){
        return puntuacion;
    }
    
    public void setDoublePuntuacion(){
        this.puntuacion = puntuacion*2;
    }
    
    public String getRespuestas(int posicion){
        return respuestas[posicion];
    }
    
    
    
    
}


