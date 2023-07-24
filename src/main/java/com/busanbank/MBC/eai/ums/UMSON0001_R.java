package com.busanbank.MBC.eai.ums;

import com.busanbank.MBC.eai.telegram.EAITelegram.ItemType;

public enum UMSON0001_R {
  sn(ItemType.Text, 20, 0, "sn", "", " "), // 거래고유번호
  seq(ItemType.Text, 100, 20, "seq", "", " " ), // 발송거래고유번호
  slot1(ItemType.Number, 60, 120, "slot1", "", " "), // 요청자 사용영역
  errorCd(ItemType.Text, 4, 180, "errorCd", "", " "), // 발송 에러 코드
  errMsg(ItemType.Text, 250, 184, "errMsg", "", " "); // 발송 에러 메시지

  private final ItemType type;
  private final int length;
  private final int offset;
  private final String mappingId;
  private final String gridId;
  private final String defaultValue;

  UMSON0001_R(ItemType type, int length, int offset, String mappingId, String gridId, String defaultValue) {
    this.type = type;
    this.length = length;
    this.offset = offset;
    this.mappingId = mappingId;
    this.gridId = gridId;
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

  public String getMappingId() {
    return this.mappingId;
  }

  public String getGridId() {
    return this.gridId;
  }

  public String getDefaultValue() {
    return this.defaultValue;
  }
}
