package com.demo.util;

public enum Profile
{

   DEV("dev"), SIT("sit"), UAT("uat"), PROD("prod");

   private final String profile;

   private Profile(final String profile)
   {
      this.profile = profile;
   }

   public String getProfile()
   {
      return profile;
   }

}
