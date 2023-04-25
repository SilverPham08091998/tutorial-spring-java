package com.example.springjava.model.userdto;

public interface Convert<R, T> {
    R convertToEntity(final T t);

    T convertToDTO(final R r);
}
