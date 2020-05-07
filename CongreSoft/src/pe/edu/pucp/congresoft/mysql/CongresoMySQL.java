/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.congresoft.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import pe.edu.pucp.congresoft.config.DBManager;
import pe.edu.pucp.congresoft.dao.CongresoDAO;
import pe.edu.pucp.congresoft.model.Congreso;

/**
 *
 * @author Jesus
 */
public class CongresoMySQL implements CongresoDAO {

    @Override
    public int insertar(Congreso congreso) {
        int result=0;
        try{
            //Registrar el jar de conexión
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Establecer conexión
            Connection con =DriverManager.getConnection("jdbc:mysql://" + 
                    DBManager.hostname +
                    ":3306/inf282", DBManager.user, DBManager.password);
            //Ejecutar sentencia
            String sql= "INSERT INTO CONGRESO(NOMBRE,FECHA_INICIO,FECHA_FIN,PAIS,ACTIVO)" + 
                    "VALUES(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, congreso.getNombre());
            ps.setDate(2,new java.sql.Date(congreso.getFecha_inicio().getTime()));
            ps.setDate(3,new java.sql.Date(congreso.getFecha_fin().getTime()));
            ps.setString(4, congreso.getPais());
            ps.setBoolean(5, congreso.isActivo());
            result=ps.executeUpdate();
            //Cerrar conexión
            con.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public int actualizar(Congreso congreso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(int idCongreso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Congreso> listar() {
        ArrayList<Congreso> congresos = new ArrayList<Congreso>();
        try{
            //Registrar el jar de conexión
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Establecer conexión
            Connection con=DriverManager.getConnection("jdbc:mysql://" + 
                    DBManager.hostname +
                    ":3306/inf282", DBManager.user, DBManager.password);
            //Ejecutar sentencia
            String sql= "SELECT * FROM CONGRESO";
            Statement st = con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
                Congreso congreso = new Congreso();
                congreso.setId(rs.getInt("ID_CONGRESO"));
                congreso.setNombre(rs.getString("NOMBRE"));
                congreso.setFecha_inicio(rs.getDate("FECHA_INICIO"));
                congreso.setFecha_fin(rs.getDate("FECHA_FIN"));
                congreso.setPais(rs.getString("PAIS"));
                congreso.setActivo(rs.getBoolean("ACTIVO"));
                congresos.add(congreso);
            }
            //Cerrar conexión
            con.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return congresos;
    }
    
}
