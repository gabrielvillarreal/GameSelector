/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udemy.poo.interfaz;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author villa
 */
public interface Actions {
    
    public void pintar(Graphics2D g); //graficos en 2 dimensiones. todas las clases usan estas interfaces
    public void teclado(KeyEvent e);
    public void raton(MouseEvent e);
    public void calculo();
    
}
