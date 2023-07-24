package com.busanbank.MBC.eai.telegram;
import java.io.UnsupportedEncodingException;

public class EAITelegram {

  /*
  * 항목유형
  */
  public enum ItemType {
    Number,
    Text,
    Array;
  }

  byte[] telegram;
  SystemCommon sysCom;
  BizCommon bizCom;
  BizIndividual bizIndi;
  final String defaultEncode;


  public EAITelegram() throws Exception {
    this("UTF-8");
  }

  public EAITelegram(String encode) throws Exception {
    sysCom = new SystemCommon(); 
    bizCom = new BizCommon();
    bizIndi = new BizIndividual();
    byte[] sysComTel = sysCom.getTelegram();
    byte[] bizComTel = bizCom.getTelegram();
    byte[] bizIndiTel = bizIndi.getTelegram();
    byte[] tempTel = new byte[sysComTel.length + bizComTel.length + bizIndiTel.length];

    this.telegram = tempTel;
    this.defaultEncode = encode;
  }

  public EAITelegram(byte[] telegram) throws UnsupportedEncodingException {
    this(telegram, "UTF-8");
  }

  public EAITelegram(byte[] telegram, String encode) throws UnsupportedEncodingException {
    this.telegram = telegram;

    sysCom = new SystemCommon(this.telegram, 0, 300); 
    bizCom = new BizCommon(this.telegram, sysCom.getTelegramLength(), 222);
    int commonLength = sysCom.getTelegramLength() + bizCom.getTelegramLength();
    bizIndi = new BizIndividual(this.telegram, commonLength, telegram.length - commonLength);
    this.defaultEncode = encode;
  }

  public EAITelegram(byte[] telegram, String encode, String type) throws UnsupportedEncodingException {
    this.telegram = telegram;
    bizIndi = new BizIndividual(this.telegram, 0, telegram.length);
    this.defaultEncode = encode;
  }

  public EAITelegram(String telegramString, String encode) throws UnsupportedEncodingException {
    this.telegram = telegramString.getBytes(encode);

    sysCom = new SystemCommon(this.telegram, 0, 300); 
    bizCom = new BizCommon(this.telegram, sysCom.getTelegramLength(), 222);
    int commonLength = sysCom.getTelegramLength() + bizCom.getTelegramLength();
    bizIndi = new BizIndividual(this.telegram, commonLength, telegram.length - commonLength);
    this.defaultEncode = encode;
  }

  public int createSysCommonTelegram(String telegramString) {
    this.telegram = telegramString.getBytes();
    sysCom = new SystemCommon(this.telegram);
    return this.telegram.length;
  }

  public int createBizCommonTelegram(String telegramString) {
    byte[] bizCommonTelegram = telegramString.getBytes();

    bizCom = new BizCommon(bizCommonTelegram);

    byte[] tempTelegram = this.telegram;
    this.telegram = new byte[tempTelegram.length + bizCommonTelegram.length];

    System.arraycopy(tempTelegram, 0, this.telegram, 0, tempTelegram.length);
    System.arraycopy(bizCommonTelegram, 0, this.telegram, tempTelegram.length, bizCommonTelegram.length);
    return bizCommonTelegram.length;
  }

  public int createIndividualTelegram(String telegramString) {
    byte[] individualTelegram = telegramString.getBytes();
    bizIndi = new BizIndividual(individualTelegram, individualTelegram.length);

    byte[] tempTelegram = this.telegram;
    this.telegram = new byte[tempTelegram.length + individualTelegram.length];

    System.arraycopy(tempTelegram, 0, this.telegram, 0, tempTelegram.length);
    System.arraycopy(individualTelegram, 0, this.telegram, tempTelegram.length, individualTelegram.length);
    return individualTelegram.length;
  }

  public byte[] getOriginalTelegram() {
    byte[] copyTelegram = new byte[telegram.length];
    System.arraycopy(telegram, 0, copyTelegram, 0, copyTelegram.length);
    return copyTelegram;
  }

  public byte[] getTelegram() {
    byte[] tempSysCom = sysCom.getTelegram();
    byte[] tempBizCom = bizCom.getTelegram();
    byte[] tempBizIndi = bizIndi.getTelegram();
    byte[] fullTelegram = new byte[tempSysCom.length + tempBizCom.length + tempBizIndi.length];

    System.arraycopy(tempSysCom, 0, fullTelegram, 0, tempSysCom.length);
    System.arraycopy(tempBizCom, 0, fullTelegram, tempSysCom.length, tempBizCom.length);
    System.arraycopy(tempBizIndi, 0, fullTelegram, tempSysCom.length + tempBizCom.length, tempBizIndi.length);
    return fullTelegram;
  }

  public String getTelegramPlain() throws UnsupportedEncodingException {
    return new String(getTelegram(), defaultEncode);
  }

  public String getGroupTelegramPlain() throws UnsupportedEncodingException {
    byte[] tempBizIndi = bizIndi.getTelegram();
    byte[] fullTelegram = new byte[tempBizIndi.length];

    System.arraycopy(tempBizIndi, 0, fullTelegram, 0, tempBizIndi.length);
    return new String(fullTelegram, defaultEncode);
  }

  public String getTelegramPlain(String encode) throws UnsupportedEncodingException {
    return new String(getTelegram(), encode);
  }

  public int getTelegramLength() {
    return telegram.length;
  }

  public byte[] getSystemCommonTelegram() {
    return sysCom.getTelegram();
  }

  public void setSystemCommonItem(SystemCommonConstant sysCommonConst, String value) {
    sysCom.setItem(sysCommonConst, value);
  }

  public String getSystemCommonItem(SystemCommonConstant sysCommonConst) throws UnsupportedEncodingException {
    return getSystemCommonItem(sysCommonConst, defaultEncode);
  }

  public String getSystemCommonItem(SystemCommonConstant sysCommonConst, String encode) throws UnsupportedEncodingException {
    return sysCom.getItem(sysCommonConst, encode);
  }

  public byte[] getBizCommonTelegram() {
    return bizCom.getTelegram();
  }

  public void setBizCommonItem(BizCommonConstant bizCommonConst, String value) {
    bizCom.setItem(bizCommonConst, value);
  }

  public String getBizCommonItem(BizCommonConstant bizCommonConst) throws UnsupportedEncodingException {
    return getBizCommonItem(bizCommonConst, defaultEncode);
  }

  public String getBizCommonItem(BizCommonConstant bizCommonConst, String encode) throws UnsupportedEncodingException {
    return bizCom.getItem(bizCommonConst, encode);
  }

  public byte[] getBizIndividual() {
    return bizIndi.getTelegram();
  }

  public void setBizIndividualItem(int offset, int length, String value) {
    bizIndi.setItem(offset, length, value);
  }

  public String getBizIndividualItem(int offset, int length) throws UnsupportedEncodingException {
    return getBizIndividualItem(offset, length, defaultEncode);
  }

  public String getBizIndividualItem(int offset, int length, String encode) throws UnsupportedEncodingException {
    return bizIndi.getItem(offset, length, encode);
  }

  public static String expand(int len, String data) throws Exception {
    return expand(len, data, ItemType.Text);
  }

  public static String expand(int len, String data, ItemType mode) throws Exception {
    if (data == null) {
      return data;
    }
    return expand(len, data.getBytes("EUC-KR"), mode, "EUC-KR");
  }

  public static String expand(int len, String data, ItemType mode, String encode) throws Exception {
    if (data == null) {
      return data;      
    }
    return expand(len, data.getBytes(encode), mode, encode);
  }

  public static String expand(int len, byte[] data, ItemType mode, String encode) throws Exception {
    byte[] resultBytes = new byte[len];
    try {
      if (ItemType.Number == mode) {
        if (data == null) {
          data = "0".getBytes(encode);
        }

        int i = 0;
        for (int loopCnt = len - data.length; i < loopCnt; i++) {
          resultBytes[i] = '0';
        }
        for (int j = 0; i < len; i++, j++) {
          resultBytes[i] = data[j];
        }
      } else {
        if (data == null) {
          data = " ".getBytes();
        }

        int i = 0;
        int offset = (len < data.length ? len : data.length);
        for (int loopCnt = offset; i < loopCnt; i++) {
          resultBytes[i] = data[i];
        }

        for (; i < len; i++) {
          resultBytes[i] = ' ';
        }
      }
    } catch(Exception e) {
      throw new Exception(String.format("입력한 값이 [%s] ==> 길이[%s] 범위를 초과하였습니다.", new String(data), Integer.toString(len)));
    }
    return new String(resultBytes, encode);
  }

  public class SystemCommon {
    /*
     * 시스템 공통부
     */
    byte[] systemCommon = null;

    public SystemCommon() throws Exception {
      StringBuilder sb = new StringBuilder();
      for (SystemCommonConstant sysCommon : SystemCommonConstant.values()) {
        sb.append(expand(sysCommon.getLength(), sysCommon.getDefaultValue(), sysCommon.getType()));
      }
      systemCommon = sb.toString().getBytes();
    }

    public SystemCommon(byte[] telegram) {
      this(telegram, 0, telegram.length);
    }

    public SystemCommon(byte[] telegram, int offset, int commonLength) {
      systemCommon = new byte[commonLength];
      System.arraycopy(telegram, offset, systemCommon, 0, systemCommon.length);
    }

    public byte[] getTelegram() {
      byte[] copyTelegram = new byte[systemCommon.length];
      System.arraycopy(systemCommon, 0, copyTelegram, 0, copyTelegram.length);
      return copyTelegram;
    }

    public int getTelegramLength() {
      return systemCommon.length;
    }

    public String getTelegramPlain(String encode) throws UnsupportedEncodingException {
      return new String(systemCommon, encode);
    }

    public void setItem(SystemCommonConstant sysCommonConst, String value) {
      System.arraycopy(value.getBytes(), 0, systemCommon, sysCommonConst.getOffset(), sysCommonConst.getLength());
    }

    public String getItem(SystemCommonConstant sysCommonConst, String encode) throws UnsupportedEncodingException {
      byte[] temp = new byte[sysCommonConst.getLength()];
      System.arraycopy(systemCommon, sysCommonConst.getOffset(), temp, 0, temp.length);
      return new String(temp, encode);
    }
  }

  public class BizCommon {
    /*
     * 비지니스 공통부
     */
    byte[] bizCommon;

    public BizCommon() throws Exception {
      StringBuilder sb = new StringBuilder();
      for (BizCommonConstant bizCommon : BizCommonConstant.values()) {
        sb.append(expand(bizCommon.getLength(), bizCommon.getDefaultValue(), bizCommon.getType()));
      }
      bizCommon = sb.toString().getBytes();
    }

    public BizCommon(byte[] telegram) {
      this(telegram, 0, telegram.length);
    }
    
    public BizCommon(byte[] telegram, int offset, int commonLength) {
      bizCommon = new byte[commonLength];
      System.arraycopy(telegram, offset, bizCommon, 0, bizCommon.length);
    }

    public byte[] getTelegram() {
      byte[] copyTelegram = new byte[bizCommon.length];
      System.arraycopy(bizCommon, 0, copyTelegram, 0, copyTelegram.length);
      return copyTelegram;
    }

    public int getTelegramLength() {
      return bizCommon.length;
    }

    public String getTelegramPlain(String encode) throws UnsupportedEncodingException {
      return new String(bizCommon, encode);
    }

    public void setItem(BizCommonConstant bizCommonConst, String value) {
      System.arraycopy(value.getBytes(), 0, bizCommon, bizCommonConst.getOffset(), bizCommonConst.getLength());
    }

    public String getItem(BizCommonConstant bizCommonConst, String encode) throws UnsupportedEncodingException {
      byte[] temp = new byte[bizCommonConst.getLength()];
      System.arraycopy(bizCommon, bizCommonConst.getOffset(), temp, 0, temp.length);
      return new String(temp, encode);
    }
  }

  public class BizIndividual {
    /*
     * 비지니스 개별부
     */
    byte[] individual;

    public BizIndividual() {
      individual = new byte[0];
    }

    public BizIndividual(byte[] telegram, int bizIndividualLength) {
      this(telegram, 0, bizIndividualLength);
    }

    public BizIndividual(byte[] telegram, int offset, int bizIndividualLength) {
      individual = new byte[bizIndividualLength];
      System.arraycopy(telegram, offset, individual, 0, individual.length);
    }

    public int setTelegram(String telegramPlain) throws UnsupportedEncodingException {
      return setTelegram(telegramPlain, defaultEncode);
    }

    public int setTelegram(String telegramPlain, String encode) throws UnsupportedEncodingException {
      individual = telegramPlain.getBytes(encode);
      return individual.length;
    }
    
    public byte[] getTelegram() {
      byte[] copyTelegram = new byte[individual.length];
      System.arraycopy(individual, 0, copyTelegram, 0, copyTelegram.length);
      return copyTelegram;
    }

    public int getTelegramLength() {
      return individual.length;
    }

    public String getTelegramPlain(String encode) throws UnsupportedEncodingException {
      return new String(individual, encode);
    }

    public void setItem(int offset, int length, String value) {
      System.arraycopy(value.getBytes(), 0, individual, offset, length);
    }

    public String getItem(int offset, int length, String encode) throws UnsupportedEncodingException {
      byte[] temp = new byte[length];
      System.arraycopy(individual, offset, temp, 0, temp.length);
      return new String(temp, encode);
    }


  }
}
