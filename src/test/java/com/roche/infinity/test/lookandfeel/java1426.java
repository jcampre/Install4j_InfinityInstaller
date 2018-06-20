package com.roche.infinity.test.lookandfeel;

import java.awt.*;
import java.awt.event.*;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class java1426 extends JPanel {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public java1426() {
    // Se crea el botón que vamos a cambiar de apariencia
    JButton boton = new JButton( "Boton Ej." );

    ActionListener miListener = new ActionListener() {
      public void actionPerformed( ActionEvent evt ) {
        String look = null;

        // Aquí se controla el Look&Feel presente
        if( evt.getActionCommand().equals( "Flecha" ) ) {
          look = "flecha.FlechaLookAndFeel";
        } 
        else {
          look = "com.sun.java.swing.plaf.metal.MetalLookAndFeel";
        }

        try {
          UIManager.setLookAndFeel( look );
          SwingUtilities.updateComponentTreeUI( java1426.this );
          java1426.this.validate();
        } catch( Exception e ) {
          System.err.println( "No se puede cambiar al LookAndFeel: "+look );
        }
      }
    };

    // Grupo de botones que va a permitir alternar entre un Look y
    // otro
    ButtonGroup grupo = new ButtonGroup();
    JRadioButton botonMetal = new JRadioButton( "Metal" );
    botonMetal.setSelected( true );
    botonMetal.addActionListener( miListener );
    grupo.add( botonMetal );

    JRadioButton botonFlecha = new JRadioButton( "Flecha" );
    botonFlecha.addActionListener( miListener );
    grupo.add( botonFlecha );

    add( boton );
    add( botonMetal );
    add( botonFlecha );
  }

  public static void main( String args[] ) {
    JFrame ventana = new JFrame( "Tutorial de Java, Swing" );

    ventana.addWindowListener( new WindowAdapter() {
      public void windowClosing( WindowEvent evt ) {
        System.exit( 0 );
      }
    });
    ventana.getContentPane().add( new java1426(),BorderLayout.CENTER );
    ventana.setSize( 300,100 );
//    ventana.show();
    ventana.setVisible(true);
  }
}