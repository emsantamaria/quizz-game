package es.ies.puerto.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * @version 1.0.0
 * @author emsantamaria
 */
public class Bbdd {
    private Connection con;

    public Bbdd(String url) {
       try {
        Class.forName("org.sqlite.JDBC");
        this.con=DriverManager.getConnection(url);
       } catch (Exception e) {
        e.printStackTrace();
       }
    }
    public List<Usuario> loadUsuarios(){
        List<Usuario>usuarios=new ArrayList<>();
        String qry="SELECT * FROM usuario";
        try {
            PreparedStatement st=con.prepareStatement(qry);
            ResultSet resultSet=st.executeQuery();
            while (resultSet.next()) {
                int id=resultSet.getInt("id");
                int puntaje=resultSet.getInt("puntaje");
                String nombre=resultSet.getString("nombre");
                List<Comodin>comodins=loaComodins(id);
                Usuario usuario=new Usuario(nombre, comodins, id, puntaje);
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  usuarios;
    }
    public List<Comodin>loaComodins(int id){
        List<Comodin>comodines=new ArrayList<>();
        String qry="SELECT * FROM usuario_comodin WHERE id=?";
        try {
            PreparedStatement st=con.prepareStatement(qry);
            st.setInt(1, id);
            ResultSet resultSet=st.executeQuery();
            while (resultSet.next()) {
                String nombre=resultSet.getString("nombre");
                int cantidad=resultSet.getInt("cantidad");
                Comodin comodin=new Comodin(id, cantidad, nombre);
                comodines.add(comodin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comodines;
    }
    public void insertData(Usuario usuario){
        String qry="INSERT INTO usuario(nombre,puntaje)VALUES(?, ?)";
        try {
            PreparedStatement st=con.prepareStatement(qry);
            st.setString(1, usuario.getNombre());
            st.setInt(2, usuario.getPuntaje());
            if(usuario.getComodines()!=null&&!usuario.getComodines().isEmpty()){
              for (int i = 0; i < usuario.getComodines().size(); i++) {
                insertComodin(usuario.getComodines().get(i), usuario.getId());
            }  
            }
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertComodin(Comodin comodin,int id){
        String qry="INSERT INTO usuario_comodin(id,nombre,cantidad)VALUES(?, ?, ?)";
        try {
            PreparedStatement st=con.prepareStatement(qry);
            st.setInt(1, id);
            st.setString(2, comodin.getNombre());
            st.setInt(3, comodin.getCantidad());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void closeConnection() throws SQLException{
        con.close();
    }


    public void delete(int id){
        String qry="delete from usuario where id=?";
        try {
            PreparedStatement st=con.prepareStatement(qry);
            st.setInt(1, id);
            st.executeUpdate();
           deleteComodin(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteComodin(int id){
        String qry="DELETE from usuario_comodin where id=?";
        try {
            PreparedStatement st=con.prepareStatement(qry);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void upadte(Usuario usuario){
        String qryUsuario = "UPDATE usuario SET nombre=?, puntaje=? WHERE id=?";
        try {
            PreparedStatement stUsuario = con.prepareStatement(qryUsuario);
            stUsuario.setString(1, usuario.getNombre());
            stUsuario.setInt(2, usuario.getPuntaje());
            stUsuario.setInt(3, usuario.getId());
            stUsuario.executeUpdate();  // Actualiza los datos del usuario
    
            // Actualiza o inserta los comodines asociados
            for (Comodin comodin : usuario.getComodines()) {
                updateComodin(comodin, usuario.getId());  // Actualiza cada comodín del usuario
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateComodin(Comodin comodin, int id){
        String qryComodin = "UPDATE usuario_comodin SET cantidad=? WHERE id=? AND nombre=?";
        try {
            PreparedStatement stComodin = con.prepareStatement(qryComodin);
            stComodin.setInt(1, comodin.getCantidad());
            stComodin.setInt(2, id);
            stComodin.setString(3, comodin.getNombre());
            int rowsUpdated = stComodin.executeUpdate();
            
            // Si no se actualizó ningún comodín, inserta uno nuevo
            if (rowsUpdated == 0) {
                insertComodin(comodin, id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   

    public List<Pregunta> loadPreguntas(){
        List<Pregunta>preguntas=new ArrayList<>();
        String qry="SELECT * from pregunta";
        try {
            PreparedStatement st=con.prepareStatement(qry);
            ResultSet resultSet=st.executeQuery();
            while (resultSet.next()) {
               String preguntaString= resultSet.getString("pregunta");
               int id=resultSet.getInt("id");
               String tipo=resultSet.getString("tipo");
               String pista=resultSet.getString("pista");
               List<Respuesta> respuestas=loadRespuestas(id);
               Pregunta pregunta=new Pregunta(respuestas, preguntaString, id,tipo,pista);
               preguntas.add(pregunta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return preguntas;
    }


    public List<Respuesta> loadRespuestas(int id) {
        List<Respuesta>respuestas=new ArrayList<>();
        String qry="SELECT * from respuestaPreguntas where id=?";
        try {
            PreparedStatement st=con.prepareStatement(qry);
            st.setInt(1, id);
            ResultSet resultSet=st.executeQuery();
            while (resultSet.next()) {
                String respuestaString=resultSet.getString("respuesta");
                Boolean correcta=true;
                String correctaString=resultSet.getString("correcta");
                if(correctaString.equals("False")){
                    correcta=false;
                }
                Respuesta respuesta=new Respuesta(respuestaString, correcta);
                respuestas.add(respuesta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return respuestas;
    }
}
