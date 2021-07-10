package ga.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQueries({
  @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u ORDER BY u.id_usuario")
})
@Table(name = "usuario")
public class Usuario implements Serializable{
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_usuario")
  private int id_usuario;
  
  private String nombre;
  
  private String apellido;
  
  private String email;
  
  private String telefono;
  
  public Usuario(){
    
  }

  public Usuario(String nombre, String apellido, String email, String telefono) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.email = email;
    this.telefono = telefono;
  }

  public int getId_usuario() {
    return id_usuario;
  }

  public void setId_usuario(int id_usuario) {
    this.id_usuario = id_usuario;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  @Override
  public String toString() {
    return "Usuario{" + "id_usuario=" + id_usuario + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono + '}';
  }
  
  
}
