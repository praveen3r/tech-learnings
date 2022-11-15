package com.demo.util;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapperImpl;

public class CommonUtil
{

   private CommonUtil()
   {
      throw new IllegalStateException("Utility class");
   }

   public static boolean isNotEmpty(final String value)
   {
      return Optional.ofNullable(value).isPresent() && !value.trim().equals(Constants.EMPTY);
   }

   public static boolean isNotEmpty(final List<?> value)
   {
      return Optional.ofNullable(value).isPresent() && !value.isEmpty();
   }

   public static boolean isNotEmpty(final Object value)
   {
      return Optional.ofNullable(value).isPresent();
   }

	/*
	 * public static String getAuthorization() { final SecurityContext
	 * securityContext = SecurityContextHolder.getContext(); final Authentication
	 * authentication = securityContext.getAuthentication(); String authorization =
	 * null;
	 * 
	 * if ((authentication != null) && (authentication.getDetails() instanceof
	 * HeaderDto)) { final HeaderDto header = (HeaderDto)
	 * authentication.getDetails(); authorization = header.getAuthorization(); }
	 * return authorization; }
	 */

	/*
	 * public static String getUserId() { final SecurityContext securityContext =
	 * SecurityContextHolder.getContext(); final Authentication authentication =
	 * securityContext.getAuthentication(); String userId = null;
	 * 
	 * if ((authentication != null) && (authentication.getDetails() instanceof
	 * HeaderDto)) { final HeaderDto header = (HeaderDto)
	 * authentication.getDetails(); userId = header.getUserId(); } return userId; }
	 */

   public static boolean compareValues(final String value1, final String value2)
   {
      return Optional.ofNullable(value1).map(s -> s.equals(value2)).orElseGet(() -> false)
         .booleanValue();
   }

   public static boolean strictCompareValues(final String value1, final String value2)
   {
      boolean isValid = Boolean.FALSE;
      if (Optional.ofNullable(value2).isPresent())
      {
         isValid = Optional.ofNullable(value1).map(s -> s.trim().equals(value2.trim()))
            .orElseGet(() -> Boolean.FALSE).booleanValue();
      }
      return isValid;
   }

   public static boolean strictCompareValuesIgnoreCase(final String value1, final String value2)
   {
      boolean isValid = Boolean.FALSE;
      if (Optional.ofNullable(value2).isPresent())
      {
         isValid = Optional.ofNullable(value1).map(s -> s.trim().equalsIgnoreCase(value2.trim()))
            .orElseGet(() -> Boolean.FALSE).booleanValue();
      }
      return isValid;
   }

   public static boolean compareValues(final Character value1, final Character value2)
   {
      return Optional.ofNullable(value1).map(s -> s.equals(value2)).orElseGet(() -> false)
         .booleanValue();
   }

   public static void copyNonNullProperties(final Object source, final Object destination)
   {
      BeanUtils.copyProperties(source, destination, getNullPropertyNames(source));
   }

   private static String[] getNullPropertyNames(final Object source)
   {
      final var src = new BeanWrapperImpl(source);
      final var propertyDescriptors = src.getPropertyDescriptors();

      return Arrays.stream(propertyDescriptors)
         .filter(x -> Objects.isNull(src.getPropertyValue(x.getName()))).map(x -> x.getName())
         .toArray(String[]::new);
   }

   /* added below validation to check if the passed value is numeric or not */
   public static final boolean isNumeric(final String str)
   {
      return str.matches("[0-9]+");
   }
}