
package ga.service;

import ga.domain.Usuario;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UsuarioService {
  public List<Usuario> listarUsuarios();
  
  public Usuario encontrarUsuarioPorId(Usuario usuario);
  
  public Usuario encontrarUsuarioPorEmail(Usuario usuario);
  
  public void insertarUsuario(Usuario usuario);
  
  public void modificarUsuario(Usuario usuario);
  
  public void eliminarUsuario(Usuario usuario);
}
