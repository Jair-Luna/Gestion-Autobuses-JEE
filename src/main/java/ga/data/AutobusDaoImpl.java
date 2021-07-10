package ga.data;

import ga.domain.Autobus;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AutobusDaoImpl implements AutobusDao{

  @PersistenceContext(unitName = "persistence_unit")
  EntityManager em;
  
  @Override
  public List<Autobus> findAllAutobus() {
    return em.createNamedQuery("Autobus.findAll").getResultList();
  }

  @Override
  public Autobus findBusById(Autobus autobus) {
    return em.find(Autobus.class, autobus.getIdAutobus());
  }

  @Override
  public void insertBus(Autobus autobus) {
    em.persist(autobus);
  }

  @Override
  public void updateBus(Autobus autobus) {
    em.merge(autobus);
  }

  @Override
  public void deleteBus(Autobus autobus) {
    em.remove(em.merge(autobus));
  }
  
}
