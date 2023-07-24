package com.busanbank.MBC.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CommonCode {
  // TB_IDDM_CMN_CD
  @JsonProperty("CMGRP_CD")
  private String CMGRP_CD;

  @JsonProperty("IDD_GROUP_NO")
  private String IDD_GROUP_NO;

  @JsonProperty("CD_ID_NM")
  private String CD_ID_NM;

  @JsonProperty("CD_CNTN_NM")
  private String CD_CNTN_NM;

  @JsonProperty("DL_AUTH_EON")
  private String DL_AUTH_EON;

  @JsonProperty("LT_CHPR_ID")
  private String LT_CHPR_ID;

  @JsonProperty("LT_CH_DTTI")
  private String LT_CH_DTTI;
}