package com.busanbank.MBC.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RestResponse <T> {
  @JsonProperty("data")
  private T data;

  @JsonProperty("resultCode")
  private String resultCode;

  @JsonProperty("errorMessage")
  private String errorMessage;
}