package guest;
 
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
 
@Stateless
public class GuestDao {
    // Injected database connection:
    @PersistenceContext private EntityManager em;

    // Stores a new guest:
    public void persist(Guest guest) {
        em.persist(guest);
    }

    // Retrieves all the guests:
    public List<Guest> getAllGuests() {
        TypedQuery<Guest> query = em.createQuery(
            "SELECT g FROM Guest g ORDER BY g.id", Guest.class);
        return query.getResultList();
    }
}