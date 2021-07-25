package ga.service;

import ga.domain.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/usuarios")
@Stateless
public class UsuarioServiceRs {
  
  @Inject
  private UsuarioService usuarioService;
  
  @GET
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public List<Usuario> listarUsuarios(){
    return usuarioService.listarUsuarios();
  }
  
  @GET
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  @Path("{id}")
  public Usuario encontrarUsuarioPorId(@PathParam("id") int id){
    return usuarioService.encontrarUsuarioPorId(new Usuario(id));
  }
  
  @POST
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public Response insertarUsuario(Usuario usuario){
    try {
      usuarioService.insertarUsuario(usuario);
      return Response.ok().entity(usuario).build();
    } catch (Exception e) {
      e.printStackTrace(System.out);
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
  }
  
  @PUT
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  @Path("{id}")
  public Response modificarUsuario(@PathParam("id") int id, Usuario usuarioModificado){
    try {
      Usuario usuario = usuarioService.encontrarUsuarioPorId(new Usuario(id));
      
      if (usuario != null) {
        usuarioService.modificarUsuario(usuarioModificado);
        return Response.ok().entity(usuarioModificado).build();
      } else {
        return Response.status(Response.Status.NOT_FOUND).build();
      }
    } catch (Exception e) {
      e.printStackTrace(System.out);
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
  }
  
  @DELETE
  @Path("{id}")
  public Response eliminarUsuarioPorId(@PathParam("id") int id){
    try {
      usuarioService.eliminarUsuario(new Usuario(id));
      return Response.ok().build();
    } catch (Exception e) {
      e.printStackTrace(System.out);
      return Response.status(404).build();
    }
  }
  
}
