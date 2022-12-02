package com.demo.dto;

import java.math.BigInteger;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HeaderDto
{
   private final String authorization;

   private final BigInteger userId;

}
