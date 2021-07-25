
package ga.web;

import ga.domain.Autobus;
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
  private Autobus autobus;
  
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
  
  public void agregarUsuario(){
    usuarioService.insertarUsuario(usuarioSeleccionado);
    this.usuarios.add(usuarioSeleccionado);
    this.usuarioSeleccionado = null;
  }
  
  public void eliminarUsuario(){
    this.usuarioService.eliminarUsuario(usuarioSeleccionado);
    this.usuarios.remove(this.usuarioSeleccionado);
    this.usuarioSeleccionado = null;
  }
  
  public void reiniciarUsuario(){
    this.usuarioSeleccionado = null;
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

  public Autobus getAutobus() {
    return autobus;
  }

  public void setAutobus(Autobus autobus) {
    this.autobus = autobus;
  }

  
}