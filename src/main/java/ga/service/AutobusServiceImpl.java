package ga.service;

import ga.data.AutobusDao;
import ga.domain.Autobus;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class AutobusServiceImpl implements AutobusService{

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
  public void eliminarBus(Autobus autobus) {
    autobusDao.deleteBus(autobus);
  }
  
}
