package com.busanbank.MBC.eai.eaiManager;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.busanbank.MBC.eai.EAISocketClient;
import com.busanbank.MBC.eai.eaiManager.Constant.EaiDataKndcd;
import com.busanbank.MBC.eai.eaiManager.Constant.EaiTelegramInfo;
import com.busanbank.MBC.eai.telegram.BizCommonConstant;
import com.busanbank.MBC.eai.telegram.EAITelegram;
import com.busanbank.MBC.eai.ums.UMSON0001_R;
import com.busanbank.MBC.eai.ums.UMSON0001_S;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class EaiIntegrationManagerImpl implements EaiIntegrationManager {
  //private String host = "130.12.3.33";
  //private int port = 15300;
  //private String envType = "D"; // "P".equals(env.getActiveProfiles()[0]) ? "P" : "D";

  public static String nvl(Object str, String rep) {
    return nvl(str.toString(),rep);
  }
  
  public static String nvl(Object str) {
    return nvl(str.toString(),"");
  }
  
  public static String nvl(String str) {
    return nvl(str,"");
  }
  
  public static String nvl(String str, String rep) {
    return str==null ? rep : str;
  }

  @Override
  public Map<String, Object> requestUMSON0001(Map<String, Object> sendData, String host, int port, String envType) throws Exception {
    Map<String, Object> resultData = new HashMap<String, Object>();
    Map<String, String> body = new LinkedHashMap<String, String>();
    for (UMSON0001_S bodyColumn : UMSON0001_S.values()) {
      if (null != sendData.get(bodyColumn.getMappingId())) {
        body.put(bodyColumn.name(), EAITelegram.expand(bodyColumn.getLength(), nvl(sendData.get(bodyColumn.getMappingId())), bodyColumn.getType()));
        continue;
      }
      body.put(bodyColumn.name(), EAITelegram.expand(bodyColumn.getLength(), bodyColumn.getDefaultValue(), bodyColumn.getType()));
    }
    
    byte[] sendTelegram = EAISocketClient.makeTelegram(envType, EaiTelegramInfo.UMSON0001.getIfId(), EaiTelegramInfo.UMSON0001.name(), EaiTelegramInfo.UMSON0001.getLowerId(), body);

    byte[] recvTelegram = new EAISocketClient(host, port, 180).request(sendTelegram);

    EAITelegram resTelegram = new EAITelegram(recvTelegram, "EUC-KR");
    if (EaiDataKndcd.EM.name().equals(resTelegram.getBizCommonItem(BizCommonConstant.DATA_KNDCD))) {
      //  error
      //Map<String, Object> errorData = makeErrorData(resTelegram);
      throw new Exception("");
    }

    int offset = 0;
    for (UMSON0001_R bodyColumn : UMSON0001_R.values()) {
      if ("".equals(bodyColumn.getGridId())) {
        resultData.put(bodyColumn.getMappingId(), resTelegram.getBizIndividualItem(offset, bodyColumn.getLength()).trim());
        offset += bodyColumn.getLength();
      }
    }
    return resultData;
  }
}
