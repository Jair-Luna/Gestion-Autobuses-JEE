
package ga.service;

import ga.data.UsuarioDao;
import ga.domain.Usuario;
import java.util.*;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

@Stateless
@WebService(endpointInterface = "ga.service.UsuarioServiceWs")
@DeclareRoles({"ROLE_ADMIN", "ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN", "ROLE_USER"})
public class UsuarioServiceImpl implements UsuarioServiceRemote, UsuarioService, UsuarioServiceWs{

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
  @RolesAllowed("ROLE_ADMIN")
  public void eliminarUsuario(Usuario usuario) {
    usuarioDao.deleteUser(usuario);
  }
  
}
