package com.demo.exception;

@FunctionalInterface
public interface ThrowingPredicate<T, E extends Exception>
{

   boolean test(T t) throws E;

}