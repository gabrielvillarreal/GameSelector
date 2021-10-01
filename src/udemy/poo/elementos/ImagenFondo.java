/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udemy.poo.elementos;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import udemy.poo.interfaz.Actions;


/**
 *
 * @author villa
 */
public class ImagenFondo implements Actions{

    private Image imagen = null;
    private Image imagenDos = null;
    //voy a usar el patron Singleton
    private Component componente; //componente dinamico
    private int x = -20;
    private static ImagenFondo objetoUnico; //es el objeto unico, no uso new
    private MediaTracker tracker; //me sirve para hacer una configuracion que es la base de todo esto
    
    public static ImagenFondo imagenFondo(){
        if(objetoUnico == null){
            objetoUnico = new ImagenFondo(); //aca lo creo recien, lo instancio
        }
        return objetoUnico;
    }
    
    private ImagenFondo(){
    }

    public void configuracion(Component componente, String archivo, String personaje){
        this.componente = componente;
        tracker = new MediaTracker(componente);
        Toolkit herram =  Toolkit.getDefaultToolkit();
        imagen = herram.getImage(getClass().getResource("/udemy/poo/recursos/"+ archivo)); //imagen de fondo
        imagenDos = herram.getImage(getClass().getResource("/udemy/poo/recursos/"+ personaje)); //le asigno el valor de personaje
        tracker.addImage(imagen, 1); //indice 1
        tracker.addImage(imagenDos, 2);
        
        //espera a que todas las imagenes sean cargadas
        try {
            tracker.waitForAll(); //si tengo imagenes grandes, espera hasta que lo cargue. promesas en servicios y cosas asi
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
    }
            
    
    @Override
    public void pintar(Graphics2D g) {
        g.drawImage(imagen, 0, 0, this.componente.getWidth(), this.componente.getHeight(), null);
        g.drawImage(imagenDos, x+40, 90, 270, 368, null); //redimensiono la imagen en 40x90
        
    }

    @Override
    public void teclado(KeyEvent e) {
    }

    @Override
    public void raton(MouseEvent e) {
    }

    @Override
    public void calculo() {
    }
    
}
