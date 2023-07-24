package com.busanbank.MBC.eai.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.busanbank.MBC.eai.eaiManager.EaiIntegrationManager;
import com.busanbank.MBC.eai.eaiManager.EaiIntegrationManagerImpl;
import com.busanbank.MBC.eai.ums.UMSON0001_S;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class BzsEcmServiceImpl implements BzsEcmService {
  private final EaiIntegrationManager integrationManager = new EaiIntegrationManagerImpl();


  @Override
  public Map<String, Object> executeSendUMS(Map<String, Object> params, String host, int port, String envType) {
    Map<String, Object> sendData = new HashMap<String, Object>();

    // 직원 정보
    String enob = String.valueOf(params.get("enob"));
    String brno = String.valueOf(params.get("brno"));

    Map<String, Object> stfInfoParams = new HashMap<String, Object>();
    stfInfoParams.put("dnCode", "BSBK");
    stfInfoParams.put("grCode", brno);
    stfInfoParams.put("urCode", enob);

    sendData.put(UMSON0001_S.reqUserId.getMappingId(), enob); // 발송요청자 사번
    sendData.put(UMSON0001_S.placeCd.getMappingId(), brno); // 점번
    sendData.put(UMSON0001_S.receiver.getMappingId(), params.get("receiver")); // 수신 전화번호
    sendData.put(UMSON0001_S.reservedDate.getMappingId(), params.get("reservedDate")); // 발송(예약) 일시
    sendData.put(UMSON0001_S.sender.getMappingId(), "15446200"); // 발신 전화번호
    sendData.put(UMSON0001_S.serviceNo.getMappingId(), params.get("serviceNo")); // 서비스 번호

    // 알림톡
    sendData.put(UMSON0001_S.umsFwDvcd.getMappingId(), "0025"); // UMS 발송 구분 코드
    sendData.put(UMSON0001_S.tmplType.getMappingId(), "J"); // 템플릿 타입
    sendData.put(UMSON0001_S.kakaoJonmun.getMappingId(), params.get("context")); // 알림톡 전문 메시지
    
    // LMS 메시지
    //Map<String, Object> message = new HashMap<>();
    //message.put("지점명", odsStfInfo.get("wrkBrnm"));
    //message.put("직원명", stfInfo.get("displayname"));
    //message.put("영업점대표번호", stfInfo.get("adPhonenumber"));
    //message.put("영업점팩스번호", stfInfo.get("adFax"));
    //message.put("직원E-Mail", stfInfo.get("externalmailaddress"));
    //message.put("명함URL", bizCardUrl + enob);
    //sendData.put(UMSON0001_S.subject.getMappingId(), params.get("subject")); // 제목
    //sendData.put(UMSON0001_S.message.getMappingId(), new JSONObject(message)); // 전문 데이터/메시지 내용
    sendData.put(UMSON0001_S.message.getMappingId(), params.get("context"));
    
    try {
      return integrationManager.requestUMSON0001(sendData, host, port, envType);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
  
}
