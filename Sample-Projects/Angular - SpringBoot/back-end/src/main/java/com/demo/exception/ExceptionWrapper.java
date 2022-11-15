package com.demo.exception;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ExceptionWrapper
{

   private ExceptionWrapper()
   {
      throw new IllegalStateException("ExceptionWrapper class");
   }

   public static <T> Consumer<T> throwException(final ThrowingConsumer<T, Exception> consumer)
   {

      return i ->
      {
         try
         {
            consumer.accept(i);
         }
         catch (final Exception ex)
         {
            throw new RuntimeException(ex);
         }
      };
   }

   public static <T> Predicate<T> throwPredicateException(
      final ThrowingPredicate<T, Exception> predicate)
   {

      return i ->
      {
         try
         {
            return predicate.test(i);
         }
         catch (final Exception ex)
         {
            throw new RuntimeException(ex);
         }
      };
   }

   public static <T, U> BiConsumer<? super T, ? super U> throwsMapException(
      final ThrowingBiConsumer<T, U, Exception> consumer)
   {
      return (i, j) ->
      {
         try
         {
            consumer.accept(i, j);
         }
         catch (final Exception ex)
         {
            throw new RuntimeException(ex);
         }
      };
   }
}
