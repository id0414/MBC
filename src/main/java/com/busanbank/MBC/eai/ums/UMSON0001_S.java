package com.busanbank.MBC.eai.ums;

import com.busanbank.MBC.eai.telegram.EAITelegram.ItemType;

/*
 * UMS 요청 전문
 */
public enum UMSON0001_S {
  compCd(ItemType.Text, 6, 0, "compCd", "", "001001", ""), // 계열사 코드
  sn(ItemType.Text, 20, 6, "sn", "", "00000000000000000000", ""), // 거래 고유 번호
  serviceNo(ItemType.Text, 10, 26, "serviceNo", "", "", ""), // 서비스 번호
  tmplType(ItemType.Text, 1, 36, "tmplType", "", "J", ""), // 템플릿 타입
  receiver(ItemType.Text, 20, 37, "receiver", "", "", ""), // 수신 전화번호
  sender(ItemType.Text, 20, 57, "sender", "", "", ""), // 발신 전화번호
  reservedDate(ItemType.Text, 14, 77, "reservedDate", "", "", ""), // 발송(예약) 일시
  placeCd(ItemType.Text, 3, 91, "placeCd", "", "", ""), // 점번
  receiverId(ItemType.Text, 8, 94, "receiverId", "", "", ""), // 고객 관리 번호
  reqUserId(ItemType.Text, 20, 102, "reqUserId", "", "", ""), // 발송 요청자 사번
  previewType(ItemType.Text, 1, 122, "previewType", "", "N", ""), // 미리보기 여부
  umsFwDvcd(ItemType.Text, 4, 123, "umsFwDvcd", "", "0005", ""), // UMS 발송 구분 코드
  slot1(ItemType.Text, 60, 127, "slot1", "", "", ""), // 요청자 사용 영역
  slot2(ItemType.Text, 60, 187, "slot2", "", "", ""), // UMS 예약 영역
  pirodoCheckYn(ItemType.Text, 1, 247, "pirodoCheckYn", "", "N", ""), // 피로도 체크 YN
  sendObjectCd(ItemType.Text, 3, 248, "sendObjectCd", "", "000", ""), // 발송 목적 코드
  subject(ItemType.Text, 50, 251, "subject", "", "", ""), // 제목
  compKey(ItemType.Text, 40, 301, "compKey", "", "", ""), // 계좌 / 카드 번호
  filePath1(ItemType.Text, 250, 341, "filePath1", "", "", ""), // 이미지 첨부파일 경로와 파일명1
  filePath2(ItemType.Text, 250, 591, "filePath2", "", "", ""), // 이미지 첨부파일 경로와 파일명2
  filePath3(ItemType.Text, 250, 841, "filePath3", "", "", ""), // 이미지 첨부파일 경로와 파일명3
  pushTit(ItemType.Text, 100, 1091, "pushTit", "", "", ""), // 제목
  pushMaxRsendTms(ItemType.Text, 1, 1191, "pushMaxRsendTms", "", "", ""), // 재전송횟수
  pushDtlMsgDvcd(ItemType.Text, 1, 1192, "pushDtlMsgDvcd", "", "", ""), // 메시지 형식 구분
  pushLemeMsgCntn(ItemType.Text, 255, 1193, "pushLemeMsgCntn", "", "", ""), // 알림 메시지(노티)
  pushHdnMsgCntn(ItemType.Text, 100, 1448, "pushHdnMsgCntn", "", "", ""), // 메시지 수신 후 처리
  webUrl(ItemType.Text, 200, 1548, "webUrl", "", "", ""), // 링크 URL
  imgUrl(ItemType.Text, 200, 1748, "imgUrl", "", "", ""), // 이미지 URL
  message(ItemType.Text, 1997, 1948, "message", "", "", "Y"), // 전문 데이터/메시지 내용
  delimiter1(ItemType.Text, 3, 3945, "delimiter1", "", "^|^", "D"), // 딜리미터 1
  pushDtlMsgCntn(ItemType.Text, 2497, 3948, "pushDtlMsgCntn", "", "", "Y"), // 보관함 상세 메시지
  delimiter2(ItemType.Text, 3, 6445, "delimiter2", "", "^|^", "D"), // 딜리미터 2
  kakaoJonmun(ItemType.Text, 2497, 6448, "kakaoJonmun", "", "", "Y"), // 알림톡/친구톡 전문 메시지
  delimiter3(ItemType.Text, 3, 8945, "delimiter3", "", "^|^", "D"), // 딜리미터 3
  kakaoAttachment(ItemType.Text, 2497, 8948, "kakaoAttachment", "", "", "Y"), // 알림톡/친구톡 챗버블 버튼
  delimiter4(ItemType.Text, 3, 11445, "delimiter4", "", "^|^", "D"), // 딜리미터 4
  emailSubject(ItemType.Text, 157, 11448, "emailSubject", "", "", "Y"), // 제목(이메일)
  delimiter5(ItemType.Text, 3, 11605, "delimiter5", "", "^|^", "D"), // 딜리미터 5
  emailReceiver(ItemType.Text, 97, 11608, "emailReceiver", "", "", "Y"), // 수신자 이메일
  delimiter6(ItemType.Text, 3, 11705, "delimiter6", "", "^|^", "D"), // 딜리미터 6
  receiverNm(ItemType.Text, 30, 11708, "receiverNm", "", "", "Y"), // 수신자명(법인명)
  delimiter7(ItemType.Text, 3, 11738, "delimiter7", "", "^|^", "D"), // 딜리미터 7
  secuKey(ItemType.Text, 10, 11741, "secuKey", "", "", "Y"), // 보안메일 비밀번호
  delimiter8(ItemType.Text, 3, 11751, "delimiter8", "", "^|^", "D"), // 딜리미터 8
  emailJonmun(ItemType.Text, 3997, 11754, "emailJonmun", "", "", "Y"), // 전문 데이터/메시지 내용
  delimiter9(ItemType.Text, 3, 15751, "delimiter9", "", "^|^", "D"), // 딜리미터 9
  emailFilePath1(ItemType.Text, 247, 15754, "emailFilePath1", "", "", "Y"), // 이미지 첨부파일 경로와 파일명1
  delimiter10(ItemType.Text, 3, 16001, "delimiter10", "", "^|^", "D"), // 딜리미터 10
  emailFilePath2(ItemType.Text, 247, 16004, "emailFilePath2", "", "", "Y"), // 이미지 첨부파일 경로와 파일명2
  delimiter11(ItemType.Text, 3, 16251, "delimiter11", "", "^|^", "D"), // 딜리미터 11
  emailFilePath3(ItemType.Text, 247, 16254, "emailFilePath3", "", "", "Y"), // 이미지 첨부파일 경로와 파일명3
  delimiter12(ItemType.Text, 3, 16501, "delimiter12", "", "^|^", "D"); // 딜리미터 12

  private final ItemType type;
  private final int length;
  private final int offset;
  private final String mappingId;
  private final String gridId;
  private final String defaultValue;
  private final String vcYn;

  /*
   * 생성자
   * @param type 항목유형
   * @param length 길이
   * @param offset 오프셋
   * @param defaultValue 기본값
   * @param mappingId 화면의 맵핑 이름
   * @param gridId 화면의 그룹 이름
   * @param defaultValue 기본값
   * @param vcYn 가변데이터 여부 값
   */
  UMSON0001_S(ItemType type, int length, int offset, String mappingId, String gridId, String defaultValue, String vcYn) {
    this.type = type;
    this.length = length;
    this.offset = offset;
    this.mappingId = mappingId;
    this.gridId = gridId;
    this.defaultValue = defaultValue;
    this.vcYn = vcYn;
  }

  /*
   * 항목 유형을 반환한다.
   * @return 항목 유형
   */
  public ItemType getType() {
    return this.type;
  }

  /*
   * 항목 길이를 반환한다.
   * @return 항목 길이
   */
  public int getLength() {
    return this.length;
  }

  /*
   * 항목 오프셋을 반환한다.
   * @return 항목 오프셋
   */
  public int getOffset() {
    return this.offset;
  }

  /*
   * 화면의 맵핑 이름을 반환한다.
   * @return 화면의 맵핑 이름
   */
  public String getMappingId() {
    return this.mappingId;
  }

  /*
   * 화면의 그룹 이름을 반환한다.
   * @return 화면의 그룹 이름
   */
  public String getGridId() {
    return this.gridId;
  }

  /*
   * 항목 기본값을 반환한다.
   * @return 기본값
   */
  public String getDefaultValue() {
    return this.defaultValue;
  }

  /*
   * 가변데이터 여부 값을 반환한다.
   * @return 여부 값
   */
  public String getVcYn() {
    return this.vcYn;
  }
}
