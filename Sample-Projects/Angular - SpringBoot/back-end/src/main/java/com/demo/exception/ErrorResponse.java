package com.demo.exception;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@XmlRootElement(name = "error")
public class ErrorResponse
{

   private String title;
   private List<ErrorDetail> details;

}
