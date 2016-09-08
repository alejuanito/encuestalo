package com.encuestas.web.utils;

public enum ContentTypeEnum {
  PDF("application/x-pdf", ".pdf"),
  XLS("application/vnd.ms-excel", ".xls");
  
  private final String code;
  private final String ext;
  
  private ContentTypeEnum (String code, String ext) {
    this.code = code;
    this.ext = ext;
  }

  public String getCode() {
    return code;
  }

  public String getExt() {
    return ext;
  }
}
