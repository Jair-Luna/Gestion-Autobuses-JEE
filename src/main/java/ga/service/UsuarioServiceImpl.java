
package ga.service;

import ga.data.UsuarioDao;
import ga.domain.Usuario;
import java.util.*;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class UsuarioServiceImpl implements UsuarioServiceRemote, UsuarioService{

  @Inject
  private UsuarioDao usuarioDao;
  
  @Override
  public List<Usuario> listarUsuarios() {
    return usuarioDao.findAllUsuarios();
  }

  @Override
  public Usuario encontrarUsuarioPorId(Usuario usuario) {
    return usuarioDao.findUserById(usuario);
  }

  @Override
  public Usuario encontrarUsuarioPorEmail(Usuario usuario) {
    return usuarioDao.findUserByEmail(usuario);
  }

  @Override
  public void insertarUsuario(Usuario usuario) {
    usuarioDao.insertUser(usuario);
  }

  @Override
  public void modificarUsuario(Usuario usuario) {
   usuarioDao.updateUser(usuario);
  }

  @Override
  public void eliminarUsuario(Usuario usuario) {
    usuarioDao.deleteUser(usuario);
  }
  
}
