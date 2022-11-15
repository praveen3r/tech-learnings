package com.demo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.demo.util.CommonUtil;

public class NotNullCustomValidator implements ConstraintValidator<NotNullCustom, Object>
{

   @Override
   public boolean isValid(final Object value, final ConstraintValidatorContext context)
   {
      return CommonUtil.isNotEmpty(value);
   }
}
