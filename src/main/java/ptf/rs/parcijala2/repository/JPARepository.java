package ptf.rs.parcijala2.repository;

import ptf.rs.parcijala2.models.Person;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class JPARepository implements PersonRepository {
    private final EntityManager em;

    public JPARepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public void addPerson(Person person) {
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
    }

    @Override
    public List<Person> getAll() {
        CriteriaQuery<Person> cq = em.getCriteriaBuilder().createQuery(Person.class);
        cq.select(cq.from(Person.class));
        return em.createQuery(cq).getResultList();
    }
}
