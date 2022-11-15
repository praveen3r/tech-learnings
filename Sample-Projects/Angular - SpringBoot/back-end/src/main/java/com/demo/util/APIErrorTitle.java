package com.demo.util;

/*
 * =====================================================================
 * Copyright 2016-2020 Fidelity National Information Services, Inc.
 * and/or its subsidiaries - All Rights Reserved worldwide.
 *
 * This document is protected under the trade secret and copyright laws
 * as the property of Fidelity National Information Services, Inc.
 * and/or its subsidiaries.
 *
 * Copying, reproduction or distribution should be limited and only to
 * employees with a "need to know" to do their job. Any disclosure
 * of this document to third parties is strictly prohibited.
 * =====================================================================
 */

public enum APIErrorTitle
{

   SERVER_VALIDATION("server-side validation failed"), SERVER_ERROR("server error"), REQUEST_ERROR("request error");

   private final String title;

   private APIErrorTitle(final String title)
   {
      this.title = title;
   }

   public String getTitle()
   {
      return title;
   }
}
