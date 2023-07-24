package com.busanbank.MBC.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DateTime {
  @JsonProperty("startDate")
  private String startDate;

  @JsonProperty("endDate")
  private String endDate;
}