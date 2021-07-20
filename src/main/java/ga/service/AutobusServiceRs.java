package ga.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import ga.domain.Autobus;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/autobuses")
@Stateless
public class AutobusServiceRs {

  @Inject
  private AutobusService autobusService;

  @GET
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public List<Autobus> listarBuses() {
    return autobusService.listarBuses();
  }

  @GET
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  @Path("{id}")
  public Autobus encontrarBusPorId(@PathParam("id") int id) {
    return autobusService.encontrarBusPorId(new Autobus(id));
  }

  @POST
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public Response insertarBus(Autobus autobus) {
    try {
      autobusService.insertarBus(autobus);
      return Response.ok().entity(autobus).build();
    } catch (Exception e) {
      e.printStackTrace(System.out);
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
  }

  @PUT
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  @Path("{id}")
  public Response modificarBus(@PathParam("id") int id, Autobus autobusModificado) {
    try {
      Autobus autobus = autobusService.encontrarBusPorId(new Autobus(id));

      if (autobus != null) {
        autobusService.modificarBus(autobusModificado);
        return Response.ok().entity(autobusModificado).build();
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
  public Response eliminarBusPorId(@PathParam("id") int id) {
    try {
      autobusService.eliminarBus(new Autobus(id));
      return Response.ok().build();
    } catch (Exception e) {
      e.printStackTrace(System.out);
      return Response.status(404).build();
    }
  }

}
