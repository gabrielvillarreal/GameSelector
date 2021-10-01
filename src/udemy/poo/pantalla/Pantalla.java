/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udemy.poo.pantalla;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.Timer;
import javax.swing.JPanel;
import udemy.poo.interfaz.Actions;

/**
 *
 * @author villa
 */
public class Pantalla extends JPanel implements KeyListener, MouseListener {

    //en un arraylist
    private ArrayList<Actions> componente = new ArrayList<>(); //una lista
    
    private Timer tiempo;

    public Pantalla(Timer tiempo) {
        this.addKeyListener(this); //añado el oyente de tecla
        this.addMouseListener(this);//añado el oyente de mouse
        this.tiempo = tiempo;
    }

    public ArrayList<Actions> getComponente() {
        return componente;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        Graphics2D gg = (Graphics2D) g;
        
        for (Actions actions : componente) {
            actions.calculo();
            actions.pintar(gg); //le digo que me pinte
        }
    }
    
    
    
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int codigoTecla = e.getKeyCode();
        
        if(codigoTecla == KeyEvent.VK_P){ //si la tecla presionada es P
            this.tiempo.stop();//paro el tiempo
        } else if(codigoTecla == KeyEvent.VK_R){//si la tecla presionada es R
            this.tiempo.start();//empiezo el tiempo
        } else if(codigoTecla == KeyEvent.VK_E ){
            System.exit(0);
        }
        for (Actions actions : componente) {
            actions.teclado(e); //implemento la interfaz de teclado
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //traigo el oyente del evento raton
        for (Actions actions : componente) {
            actions.raton(e);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    
    
}
