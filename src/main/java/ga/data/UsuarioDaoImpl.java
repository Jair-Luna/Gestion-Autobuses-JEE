
package ga.data;

import ga.domain.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class UsuarioDaoImpl implements UsuarioDao{
  
  @PersistenceContext(unitName = "persistence_unit")
  EntityManager em;

  @Override
  public List<Usuario> findAllUsuarios() {
    return em.createNamedQuery("Usuario.findAll").getResultList();
  }

  @Override
  public Usuario findUserById(Usuario usuario) {
    return em.find(Usuario.class, usuario.getIdUsuario());
  }

  @Override
  public Usuario findUserByEmail(Usuario usuario) {
   Query query = em.createQuery("FROM Usuario u WHERE u.email =: email");
   query.setParameter("email", usuario.getEmail());
   return (Usuario) query.getSingleResult();
  }

  @Override
  public void insertUser(Usuario usuario) {
    em.persist(usuario);
  }

  @Override
  public void updateUser(Usuario usuario) {
    em.merge(usuario);
  }

  @Override
  public void deleteUser(Usuario usuario) {
    em.remove(em.merge(usuario));
  }
  
}
