package casestudy2.service;

import java.util.List;

public interface IService<T>{
    boolean add(T entity);
    boolean update(T entity);
    void delete (int id);
    T getById(int id);
    List<T> getAll();
}
