/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.belch.bl;

import co.com.belch.dal.Conexion;
import co.com.belch.ent.Usuario;
import co.com.belch.pre.VentanaPrincipal;
import co.com.belch.pre.Logeo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ESTUDIANTE2302T
 */
public class Usuariobl {

    private Connection link;

    public Usuariobl() throws SQLException {
        Conexion c = new Conexion();
        this.link = c.conectar();

    }

    public void login() throws SQLException {
        Usuario usulogin = new Usuario();
        VentanaPrincipal vp = new VentanaPrincipal();
        Logeo log = new Logeo();
        log.Iniciar.action(null,log);
        String sql = "SELECT  * FROM usuario  WHERE nombreUsuario='" + usulogin.getNickname() + "' && contraseña'" + usulogin.getContraseña() + "'";
        try {
            Statement st = link.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next());
            
            log.txtUsuario.getText();
            log.txtContraseña.getText();
            
            log.Iniciar.action(null, vp);
            if (log.txtUsuario.getText().equals(rs.getString("nombreUsuario")) && log.txtContraseña.getText().equals(rs.getString("contraseña"))) {
        
                
                vp.setVisible(true);

            } else {

                JOptionPane.showMessageDialog(null, "usuario o contraseña incorrectos", "Aviso", JOptionPane.PLAIN_MESSAGE);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Usuariobl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void registrar() {

    }

}
