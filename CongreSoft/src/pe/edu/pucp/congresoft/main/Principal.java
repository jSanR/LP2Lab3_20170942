/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.congresoft.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import pe.edu.pucp.congresoft.dao.CongresoDAO;
import pe.edu.pucp.congresoft.model.Congreso;
import pe.edu.pucp.congresoft.mysql.CongresoMySQL;

/**
 *
 * @author Jesus
 */
public class Principal {
    public static void main(String[] args){
        ArrayList<Congreso> congresos =new ArrayList<Congreso>();
        SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
        try{
            Congreso c1=new Congreso("INTERACT 2021", sdf.parse("01-01-2021"), sdf.parse("05-01-2021"),"BOLIVIA",true);
            CongresoDAO cDAO= new CongresoMySQL();
        
            int result= cDAO.insertar(c1);
            if(result!=0){
                System.out.println("Inserción correcta\n");
            }
            congresos= cDAO.listar();
            for(Congreso congreso: congresos){
                System.out.println(congreso.mostrarDatos());
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
