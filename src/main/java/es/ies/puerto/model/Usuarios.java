package es.ies.puerto.model;

import java.sql.SQLException;
import java.util.List;
/**
 * @version 1.0.0
 * @author emsantamaria
 */
public class Usuarios {
    private List<Usuario>usuarios;
    Bbdd bbdd;
    String path="jdbc:sqlite:src/main/resources/db/Usuarios.db";
    /**
     * Constructor inicializador
          * @throws ClassNotFoundException 
          */
        public Usuarios(){
            bbdd=new Bbdd(path);
            usuarios=bbdd.loadUsuarios();
            try {
                bbdd.closeConnection();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
   

    /**
     * Funsion que permite aniadir a un usuario
     */
public boolean aniadir(Usuario usuario){
    this.bbdd=new Bbdd(path);
    if(usuarios.contains(usuario)){
        return false;
    }
    bbdd.insertData(usuario);
    try {
        bbdd.closeConnection();
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return  usuarios.add(usuario);
}

/**
 * metodo que permite eliminar a un usuario
 * @param usuario
 * @return
 * @throws ClassNotFoundException
 * @throws SQLException
 */
public boolean remove(Usuario usuario) throws ClassNotFoundException, SQLException{
    this.bbdd=new Bbdd(path);
    if(!usuarios.contains(usuario)){
        return false;
    }
    bbdd.delete(usuario.getId());
    bbdd.closeConnection();
    return usuarios.remove(usuario);
 } 

 /**
  * Metodo que permite actualizar a un usuario
  * @param usuario
  */
 public void upadte(Usuario usuario){
    bbdd=new Bbdd(path);
    bbdd.upadte(usuario);
    try {
        bbdd.closeConnection();
    } catch (SQLException e) {

        e.printStackTrace();
    }
 }

 /**
  * MEtodo que busca a un usuario por su nombre
  * @param name
  * @return
  */
 public Usuario findByName(String name){
    bbdd=new Bbdd(path);
    usuarios=bbdd.loadUsuarios();
    try {
        bbdd.closeConnection();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    for (Usuario usuario : usuarios) {
        if(usuario.getNombre().equals(name)){
            return usuario;
        }
    }
    return null;
 }
}
