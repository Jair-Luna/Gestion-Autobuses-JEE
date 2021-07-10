
package ga.service;

import ga.domain.Usuario;
import java.util.*;
import javax.ejb.Stateless;

@Stateless
public class UsuarioServiceImpl implements UsuarioServiceRemote, UsuarioService{

  @Override
  public List<Usuario> listarUsuarios() {
    List<Usuario> usuarios = new ArrayList<>();
    usuarios.add(new Usuario(1, "David", "Fierro", "dfierro@mail.com", "0934672833"));
    usuarios.add(new Usuario(2, "Andres", "Lopez", "alopez@mail.com", "0989450726"));
    return usuarios;
  }

  @Override
  public Usuario encontrarUsuarioPorId(Usuario usuario) {
    return null;
  }

  @Override
  public Usuario encontrarUsuarioPorEmail(Usuario usuario) {
    return null;
  }

  @Override
  public void insertarUsuario(Usuario usuario) {
    
  }

  @Override
  public void modificarUsuario(Usuario usuario) {
    
  }

  @Override
  public void eliminarUsuario(Usuario usuario) {
    
  }
  
}
