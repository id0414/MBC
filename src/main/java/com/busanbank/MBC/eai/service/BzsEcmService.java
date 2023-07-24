package com.busanbank.MBC.eai.service;

import java.util.Map;

public interface BzsEcmService {
  Map<String, Object> executeSendUMS(Map<String, Object> params, String host, int port, String envType);
}
