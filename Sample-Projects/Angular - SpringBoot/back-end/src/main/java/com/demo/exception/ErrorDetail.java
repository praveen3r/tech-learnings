package com.demo.exception;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDetail implements Serializable
{
   /**
    *
    */
   private static final long serialVersionUID = 1L;

   private String code;
   private String message;
   private String field;

   public ErrorDetail(final String code, final String message)
   {
      this.code = code;
      this.message = message;
      this.field = "";
   }

   public ErrorDetail(final String code)
   {
      this.code = code;
   }
}
