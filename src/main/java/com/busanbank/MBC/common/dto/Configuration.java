package com.busanbank.MBC.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Configuration {
  // TB_IDDM_SE
  @JsonProperty("CMGRP_CD")
  private String CMGRP_CD;

  @JsonProperty("SE_GROUP_NM")
  private String SE_GROUP_NM;

  @JsonProperty("SE_CD_NM")
  private String SE_CD_NM;

  @JsonProperty("SE_VAL")
  private String SE_VAL;

  @JsonProperty("ADN_EPL")
  private String ADN_EPL;

  @JsonProperty("LT_CHPR_ID")
  private String LT_CHPR_ID;

  @JsonProperty("LT_CH_DTTI")
  private String LT_CH_DTTI;
}