
package ga.data;

import ga.domain.Usuario;
import java.util.List;

public interface UsuarioDao {
  public List<Usuario> findAllUsuarios();
  
  public Usuario findUserById(Usuario usuario);
  
  public Usuario findUserByEmail(Usuario usuario);
  
  public void insertUser(Usuario usuario);
  
  public void updateUser(Usuario usuario);
  
  public void deleteUser(Usuario usuario);
}
