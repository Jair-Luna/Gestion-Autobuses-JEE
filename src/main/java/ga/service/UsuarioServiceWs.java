
package ga.service;

import ga.domain.Usuario;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface UsuarioServiceWs {
  
  @WebMethod
  public List<Usuario> listarUsuarios();
  
}
