package com.wipro.campaign.util;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Date;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DateDeserializer extends JsonDeserializer<Date>
{

   @Override
   public Date deserialize(final JsonParser jsonParser, final DeserializationContext ctx)
      throws IOException
   {
      Date date = null;
      final String str = jsonParser.getText();

      if (Optional.ofNullable(str).isPresent())
      {
         final String property = jsonParser.currentName();
         try
         {
            date = convertStringToDate(str, "uuuu-MM-dd");
         }
         catch (final Exception e)
         {
            final StringBuilder sb = new StringBuilder();
            sb.append("Invalid date").append(" ").append(property);
            log.error("Error is {}", sb.toString());
         }
      }
      return date;

   }

   public static Date convertStringToDate(final String date, final String pattern)
   {
      final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern)
         .withResolverStyle(ResolverStyle.STRICT);
      final ZoneId defaultZoneId = ZoneId.systemDefault();
      final LocalDate localDate = LocalDate.parse(date, formatter);
      return Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

   }
}