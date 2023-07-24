package com.busanbank.MBC.eai.eaiManager;

public class Constant {
  /*
   * 연계시스템 구분
   */
  public enum IntegrationCd {
    EAI;
  }

  /*
   * EAI 전문식별자
   */
  public enum EaiTelegramInfo {
    UMSON0001("IDDUMSON0001", "  ");

    String lowerId;
    String ifId;
    String addIfId;

    EaiTelegramInfo(String ifId, String lowerId) {
      this.ifId = ifId;
      this.lowerId = lowerId;
    }

    EaiTelegramInfo(String ifId, String addIfId, String lowerId) {
      this.ifId = ifId;
      this.addIfId = addIfId;
      this.lowerId = lowerId;
    }

    public String getIfId() {
      return this.ifId;
    }

    public String getLowerId() {
      return this.lowerId;
    }

    public String getAddIfId() {
      return this.addIfId;
    }
  }

  public enum EaiDataKndcd {
    NM, // 정상
    EM, // 오류
    AM, // 책임자승인
    CM; // 부은가족 - 리바운드거래대상
  }

  public enum EaiCommonDataKndcd {
    CSNF_INQ_RNCD("01", "고객정보조회사유코드");

    private String code;

    EaiCommonDataKndcd(String code, String codeNm) {
      this.code = code;
    }

    public String getCode() {
      return code;
    }
  }
}
