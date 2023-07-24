package com.busanbank.MBC.eai.telegram;

import com.busanbank.MBC.eai.telegram.EAITelegram.ItemType;

/*
 * EAI 시스템 헤더
 */
public enum SystemCommonConstant {
  STD_GRAM_LEN(ItemType.Number, 8, 0, "00000000"),
  GRAM_ENC_DVCD(ItemType.Text, 1, 8, "1"),
  GBL_ID_DATE(ItemType.Text, 8, 9, "00000000"),
  GBL_ID_SYSTEM_ID(ItemType.Text, 8, 17, "IDD00000"),
  GBL_ID_STANDARD_TELEGRAM(ItemType.Number, 14, 25, "00000000000000"),
  GBL_ID_STATUS_NUM(ItemType.Number, 2, 39, "00"),
  CHNL_TPCD(ItemType.Text, 2, 41, "US"),
  CLI_IP(ItemType.Text, 39, 43, "0.0.0.0"),
  CLI_MAC(ItemType.Text, 12, 82, "000000000000"),
  CONF_INFO_DVCD(ItemType.Text, 1, 94, "D"),
  FST_TRS_SYS_CD(ItemType.Text, 3, 95, "IDD"),
  MCI_NODE_NO(ItemType.Number, 2, 98, "00"),
  TRS_SYS_CD(ItemType.Text, 3, 100, "IDD"),
  TRS_NODE_NO(ItemType.Number, 2, 103, "00"),
  RCV_SV_CD(ItemType.Text, 12, 105, " "),
  RSLT_RCV_SV_CD(ItemType.Text, 12, 117, " "),
  FRG_MCI_IF_ID(ItemType.Text, 16, 129, " "),
  EAI_IF_ID(ItemType.Text, 12, 145, " "),
  XA_TRNS_DVCD(ItemType.Text, 1, 157, "1"),
  TRNS_SYNC_DVCD(ItemType.Text, 1, 158, "S"),
  RQST_RSP_DVCD(ItemType.Text, 1, 159, "S"),
  GRAM_RQST_DTTI(ItemType.Text, 17, 160, " "),
  TTL_USE_DVCD(ItemType.Text, 1, 177, "1"),
  FST_STI(ItemType.Text, 6, 178, " "),
  KEEP_HR_SEC_CNT(ItemType.Number, 3, 184, "000"),
  GRAM_RSP_DTTI(ItemType.Text, 17, 187, " "),
  RSP_RSLT_DVCD(ItemType.Text, 1, 204, "1"),
  OUTPT_GRAM_TPCD(ItemType.Text, 1, 205, " "),
  GRAM_COTI_SEQ(ItemType.Number, 3, 206, "000"),
  PRB_SYS_CD(ItemType.Text, 3, 209, " "),
  STD_GRAM_ERCD(ItemType.Text, 10, 212, " "),
  STD_GRAM_VER(ItemType.Text, 1, 222, "1"),
  GRAM_LANG_DVCD(ItemType.Text, 2, 223, "KR"),
  LT_CHNL_TPCD(ItemType.Text, 2, 225, " "),
  CHNL_GRAM_COMPART_LEN(ItemType.Number, 4, 227, "0000"),
  EAI_NODE_NO(ItemType.Number, 2, 231, " "),
  SYS_HEADER_PPR_CHAR_CNTN(ItemType.Text, 67, 233, " ");

  private final ItemType type;
  private final int length;
  private final int offset;
  private final String defaultValue;

  /*
   * 시스템 헤더 생성자
   * @param type 항목유형
   * @param length 길이
   * @param offset 오프셋
   * @param defaultValue 기본값
   */
  SystemCommonConstant(ItemType type, int length, int offset, String defaultValue) {
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