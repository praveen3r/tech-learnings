package com.demo.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

public class DateUtil
{
   private DateUtil()
   {
      throw new IllegalStateException("Utility class");
   }
   
   public static Date currentDateTime()
   {
      return Date.from(Instant.now());
   }
   
   public static LocalDateTime currentLocalDateTime()
   {
      return LocalDateTime.now();
   }

}