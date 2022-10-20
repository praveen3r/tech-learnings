package com.demo.dto;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

/**
 * This is the dynamic response for all GET APIs
 *
 * @author e5616358
 * @version v1
 * @since 10-29-2020
 */
@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class DemoResponse<T extends Serializable> implements Serializable
{

   private static final long serialVersionUID = 1L;

   private Map<String, List<T>> properties;

   @JsonAnyGetter
   public Map<String, List<T>> getProperties()
   {
      return properties;
   }

   public DemoResponse(final String propertyName, final List<T> entityList)
   {
      properties = Collections.singletonMap(propertyName, entityList);
   }

}
