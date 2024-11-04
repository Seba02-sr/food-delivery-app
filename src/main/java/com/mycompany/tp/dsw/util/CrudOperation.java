package com.mycompany.tp.dsw.util;

public interface CrudOperation<T> {
    void ejecutar(T item);
}