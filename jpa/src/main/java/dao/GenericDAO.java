package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class GenericDAO<T> {

    private Class<T> type;

    @PersistenceContext(unitName = "default")
    protected EntityManager entityManager;

    GenericDAO(Class<T> type) {
        this.type = type;
    }

    public T find(Long id) {
        if (id == null) {
            return null;
        }
        return entityManager.find(type, id);
    }

    public List<T> findAll() {
        return entityManager.createQuery(String.format("select o from %s o", type.getName()), type)
                .getResultList();
    }

    public void persist(T object) {
        entityManager.persist(object);
    }

    public T update(T object) {
        return entityManager.merge(object);
    }

    public void delete(T object) {
        entityManager.remove(object);
    }
}
