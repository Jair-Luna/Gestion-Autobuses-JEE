package ga.service;

import ga.data.AutobusDao;
import ga.domain.Autobus;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

@Stateless
@WebService(endpointInterface = "ga.service.AutobusServiceWs")
@DeclareRoles({"ROLE_ADMIN", "ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN", "ROLE_USER"})
public class AutobusServiceImpl implements AutobusService, AutobusServiceRemote, AutobusServiceWs{

  @Inject
  private AutobusDao autobusDao;
  
  @Override
  public List<Autobus> listarBuses() {
    return autobusDao.findAllAutobus();
  }

  @Override
  public Autobus encontrarBusPorId(Autobus autobus) {
    return autobusDao.findBusById(autobus);
  }

  @Override
  public void insertarBus(Autobus autobus) {
    autobusDao.insertBus(autobus);
  }

  @Override
  public void modificarBus(Autobus autobus) {
    autobusDao.updateBus(autobus);
  }
  
  @Override
  @RolesAllowed("ROLE_ADMIN")
  public void eliminarBus(Autobus autobus) {
    autobusDao.deleteBus(autobus);
  }
  
}
