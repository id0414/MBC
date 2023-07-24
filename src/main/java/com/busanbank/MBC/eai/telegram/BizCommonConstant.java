package com.busanbank.MBC.eai.telegram;

import com.busanbank.MBC.eai.telegram.EAITelegram.ItemType;

/*
 * 비지니스 업무 헤더
 */
public enum BizCommonConstant {
  BLG_CMGR_CD(ItemType.Text, 2, 0, "01"),
  TT_BRNO(ItemType.Text, 3, 2, "000"),
  MTBCNO(ItemType.Text, 3, 5, "000"),
  ENOB(ItemType.Text, 7, 8, "       "),
  SHP_DVCD(ItemType.Text, 1, 15, "0"),
  TRNS_CMGR_CD(ItemType.Text, 2, 16, "01"),
  TU_BRNO(ItemType.Text, 3, 18, "000"),
  TRNS_TUNO(ItemType.Text, 3, 21, "000"),
  VE_BRNO(ItemType.Text, 3, 24, "000"),
  APVL_TYPE_DVCD(ItemType.Text, 1, 27, "1"),
  APPER_RSP_RSCD(ItemType.Text, 1, 28, "1"),
  OTM1_APVL_ENOB(ItemType.Text, 7, 29, " "),
  OTM1_APVL_TUNO(ItemType.Text, 3, 36, " "),
  OTM2_APVL_ENOB(ItemType.Text, 7, 39, " "),
  OTM2_APVL_TUNO(ItemType.Text, 3, 46, " "),
  SCREN_ID(ItemType.Text, 9, 49, "IDD000000"),
  LWR_SCREN_ID(ItemType.Text, 9, 58, " "),
  INPUT_GRAM_ID(ItemType.Text, 9, 67, " "),
  INPUT_GRAM_LWR_ID(ItemType.Text, 2, 76, " "),
  MSG_COTI_CD(ItemType.Text, 1, 78, "1"),
  NEXT_PGE_REU_CD(ItemType.Text, 1, 79, "1"),
  NON_RQST_MSG_OUTPT_CD(ItemType.Text, 1, 80, "1"),
  CAN_CORR_DVCD(ItemType.Text, 1, 81, "1"),
  AUTO_TRNS_REU_CD(ItemType.Text, 1, 82, "1"),
  INPUT_GRAM_EDIT_DVCD(ItemType.Text, 1, 83, "2"),
  SMLT_TRNS_DVCD(ItemType.Text, 1, 84, "1"),
  VD_TRNS_DVCD(ItemType.Text, 1, 85, "1"),
  FRG_ORGTCD(ItemType.Text, 4, 86, ""),
  FRG_BIZ_CD(ItemType.Text, 4, 90, ""),
  OUTS_TCIRT_NO(ItemType.Text, 10, 94, ""),
  AITM_RNWL_MODE_DVCD(ItemType.Text, 1, 104, "1"),
  TADY_TRNS_NDV_CAN_REU_CD(ItemType.Text, 1, 105, "1"),
  BNKB_PRTR_CNNT_DVCD(ItemType.Text, 1, 106, "1"),
  ICCRD_MDM_DVCD(ItemType.Text, 1, 107, "1"),
  MS_USE_DCD(ItemType.Text, 1, 108, "1"),
  RRNO_INFO_PRTC_DVCD(ItemType.Text, 1, 109, "1"),
  CUST_NM_INFO_PRTC_DVCD(ItemType.Text, 1, 110, "1"),
  ACNO_INFO_PRTC_DVCD(ItemType.Text, 1, 111, "1"),
  CDNO_ONFP_PRTC_DVCD(ItemType.Text, 1, 112, "1"),
  TLNO_INFO_PRTC_DVCD(ItemType.Text, 1, 113, "1"),
  ADDR_INFO_PRTC_DVCD(ItemType.Text, 1, 114, "1"),
  LOG_REC_DVCD(ItemType.Text, 1, 115, "1"),
  TT_OPEN_DVCD(ItemType.Text, 1, 116, " "),
  TRLG_KEY_VAL(ItemType.Text, 56, 117, " "),
  DLNG_STCD(ItemType.Text, 1, 173, " "),
  TT_RSP_INPUT_RSRN_DVCD(ItemType.Text, 1, 174, " "),
  TT_RSP_INPUT_RSRN_EDIT_ID(ItemType.Text, 11, 175, " "),
  OUTPT_WAT_STCD(ItemType.Text, 1, 186, " "),
  TU_SCREN_NO(ItemType.Text, 4, 187, " "),
  CSNF_INQ_RNCD(ItemType.Text, 2, 191, "  "),
  BF_APVL_INFO_USE_DVCD(ItemType.Text, 1, 193, " "),
  OUTPT_FRML_BTCH_DSGN_DVCD(ItemType.Text, 1, 194, " "),
  RPPR_DCA_DVCD(ItemType.Text, 1, 195, " "),
  TRNS_HEADER_PPR_CHAR_CNTN(ItemType.Text, 16, 196, "                "),
  DATA_KNDCD(ItemType.Text, 2, 212, "10"),
  DATA_LEN(ItemType.Number, 8, 214, "0");

  private final ItemType type;
  private final int length;
  private final int offset;
  private final String defaultValue;

  /*
   * 비지니스 업무 헤더 생성자
   * @param type 항목유형
   * @param length 길이
   * @param offset 오프셋
   * @param defaultValue 기본값
   */
  BizCommonConstant(ItemType type, int length, int offset, String defaultValue) {
    this.type = type;
    this.length = length;
    this.offset = offset;
    this.defaultValue = defaultValue;
  }

  public ItemType getType() {
    return this.type;
  }

  public int getLength() {
    return this.length;
  }

  public int getOffset() {
    return this.offset;
  }

  public String getDefaultValue() {
    return this.defaultValue;
  }
}
