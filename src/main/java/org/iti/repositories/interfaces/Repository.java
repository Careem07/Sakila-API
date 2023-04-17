package org.iti.repositories.interfaces;
import java.util.List;
public interface Repository<T> {
    T create(T t);

    T findById(int id);

    <K> T find(K k);

    List<T> findAll();

    T update (T t);

    boolean remove(T t);

}
