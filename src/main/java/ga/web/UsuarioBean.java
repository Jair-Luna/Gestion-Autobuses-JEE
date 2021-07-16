
package ga.web;

import ga.domain.Usuario;
import ga.service.UsuarioService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.event.RowEditEvent;

@Named("usuarioBean")
@RequestScoped
public class UsuarioBean {
  
  Logger log = LogManager.getRootLogger();
  
  @Inject
  private UsuarioService usuarioService;
  
  private Usuario usuarioSeleccionado;
  List<Usuario> usuarios;
  
  public UsuarioBean(){
        
  }
  
  @PostConstruct
  public void inicializar(){
    usuarios = usuarioService.listarUsuarios();
    usuarioSeleccionado = new Usuario();
  }
  
  public void editListener(RowEditEvent event){
    Usuario usuario = (Usuario) event.getObject();
    usuarioService.modificarUsuario(usuario);
  }

  public Usuario getUsuarioSeleccionado() {
    return usuarioSeleccionado;
  }

  public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
    this.usuarioSeleccionado = usuarioSeleccionado;
  }

  public List<Usuario> getUsuarios() {
    return usuarios;
  }

  public void setUsuarios(List<Usuario> usuarios) {
    this.usuarios = usuarios;
  }
  
}
