/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Conexion;
import Vistas.frmLogin;
import Vistas.frmPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Alex Avila
 */
public class ConexionController implements ActionListener{
    frmLogin VistaLogin;
    frmPrincipal VistaPrincipal;
    Conexion ModeloConexion;

    public ConexionController(frmLogin VistaLogin, frmPrincipal VistaPrincipal, Conexion ModeloConexion) {
        this.VistaLogin = VistaLogin;
        this.VistaPrincipal = VistaPrincipal;
        this.ModeloConexion = ModeloConexion;
        
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
            
        }
    }
}
