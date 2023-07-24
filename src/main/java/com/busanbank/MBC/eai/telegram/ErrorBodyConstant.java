package com.busanbank.MBC.eai.telegram;

import com.busanbank.MBC.eai.telegram.EAITelegram.ItemType;

/*
 * 에러바디
 */
public enum ErrorBodyConstant {
  outptGramId(ItemType.Text, 9, 0, "", " "),
  outptGramLwrId(ItemType.Text, 2, 9, "", " "),
  intputScrenId(ItemType.Text, 9, 11, "", " "),
  oriErcd(ItemType.Text, 10, 20, "", " "),
  msgOutptAttr(ItemType.Text, 1, 30, "", " "),
  errOrgnItemNm(ItemType.Text, 200, 31, "", " "),
  mnmsgInfoItrTms(ItemType.Number, 1, 231, "", " "),
  msgCd(ItemType.Text, 10, 232, "", " "),
  mnmsgCntn(ItemType.Text, 200, 242, "", " "),
  errLocatCntn(ItemType.Text, 100, 442, "", " "),
  adnMsgItrTms(ItemType.Number, 2, 542, "", " "),
  adnMsgList(ItemType.Array, 0, 0, "adnMsgItrTms", " "),
  adnMsgCd(ItemType.Text, 10, 544, "adnMsgList", " "),
  adnMsgCntn(ItemType.Text, 100, 554, "adnMsgList", " ");

  private final ItemType type;
  private final int length;
  private final int offset;
  private final String gridId;
  private final String defaultValue;

  ErrorBodyConstant(ItemType type, int length, int offset, String gridId, String defaultValue) {
    this.type = type;
    this.length = length;
    this.offset = offset;
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

  public String getGridId() {
    return this.gridId;
  }

  public String getDefaultValue() {
    return this.defaultValue;
  }
}