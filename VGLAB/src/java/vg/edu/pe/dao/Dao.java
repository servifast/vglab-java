package vg.edu.pe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {

    private Connection cn;

    public void Conexion() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            cn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.8.169:1521:XE", "VGLAB", "vallegrande2018");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    public void Cerrar() throws SQLException {      //Cerrar la coneccion
        if (cn != null) {
            if (cn.isClosed() == false) {
                cn.close();
            }
        }
    }

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

//    public static void main(String[] args) {
//        Dao dao = new Dao();
//        dao.Conexion();
//    }
    
}
