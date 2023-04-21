/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Conexion;
import Modelos.PersonaModel;
import Vistas.frmLogin;
import Vistas.frmPersonas;
import Vistas.frmPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex Avila
 */
public class ConexionController implements ActionListener{
    frmLogin VistaLogin;
    frmPrincipal VistaPrincipal;
    Conexion ModeloConexion;
    frmPersonas VistaPersonas;
    PersonaModel ModeloPersona; 

    public ConexionController(frmLogin VistaLogin, frmPrincipal VistaPrincipal, Conexion ModeloConexion, frmPersonas VistaPersonas, PersonaModel ModeloPersona) {
        this.VistaLogin = VistaLogin;
        this.VistaPrincipal = VistaPrincipal;
        this.ModeloConexion = ModeloConexion;
        this.VistaPersonas = VistaPersonas;
        this.ModeloPersona = ModeloPersona;
        
        //this.VistaPrincipal.setExtendedState(frmPrincipal.MAXIMIZED_BOTH);
        this.VistaPrincipal.setVisible(true);
        
        this.VistaLogin.btnAceptar.addActionListener(this);
        this.VistaPrincipal.btnConectar.addActionListener(this);
        
        
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.VistaPrincipal.btnConectar){
            this.VistaLogin.setVisible(true);
            this.VistaLogin.setLocationRelativeTo(null);
        }
        
        if(e.getSource()==this.VistaLogin.btnAceptar){
            this.ModeloConexion.Conectar(this.VistaLogin.txtUsuario.getText(), this.VistaLogin.txtContra.getText());
            
            if(ModeloConexion!=null){
                this.VistaLogin.dispose();
                this.VistaPersonas.btnGuardar.addActionListener(this);
                this.VistaPersonas.setVisible(true);
                this.VistaPersonas.setLocationRelativeTo(null);
                
            }
            if(e.getSource()==this.VistaPersonas.btnGuardar)
            {
                //MANDAR A GUARDAR EL REGISTRO
                this.ModeloPersona.GuardarPerona(this.VistaPersonas.txtApellidos.getText(),
                        this.ModeloPersona.);
            }
             
        }
    }
}
