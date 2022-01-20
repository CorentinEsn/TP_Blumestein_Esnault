package com.example.tp_blumestein_esnault;

import com.example.tp_blumestein_esnault.donnees.Utilisateur;

import java.sql.SQLException;
import java.util.List;

public class DAO<T> {

    private final Class<T> type;

    public DAO(Class<T> type) {
        this.type = type;
    }

    public List<T> getAll() {
        String[] string = type.getName().split("\\.");
        return ConnectBdd.getEntityManager().createQuery("SELECT t FROM " + string[string.length - 1] + " t", type).getResultList();
    }

    public T get(int id) {
        return ConnectBdd.getEntityManager().find(type, id);
    }

    public Object getColumn(int id, String column) {
        String[] string = type.getName().split("\\.");
        return ConnectBdd.getEntityManager().createQuery("SELECT " + column + " FROM " + string[string.length - 1] + " WHERE id =" + id).getSingleResult();
    }

    public void persist(T t) {
        ConnectBdd.startTransaction();
        ConnectBdd.getEntityManager().persist(t);
        ConnectBdd.commitTransaction();
    }

    public void update(T t) {
        ConnectBdd.startTransaction();
        ConnectBdd.getEntityManager().merge(t);
        ConnectBdd.commitTransaction();
    }

    public void delete(T t) {
        ConnectBdd.startTransaction();
        ConnectBdd.getEntityManager().remove(t);
        ConnectBdd.commitTransaction();
    }
}