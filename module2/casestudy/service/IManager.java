package casestudy.service;

import java.util.List;

public interface IManager<T>{
    void add(T entity);
    boolean update(T entity);
    void delete (int id);
    T getById(int id);
    List<T> getAll();
}
