/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.congresoft.dao;

import java.util.ArrayList;
import pe.edu.pucp.congresoft.model.Congreso;

/**
 *
 * @author Jesus
 */
public interface CongresoDAO {
    int insertar(Congreso congreso);
    int actualizar(Congreso congreso);
    int eliminar(int idCongreso);
    ArrayList<Congreso> listar();
}
