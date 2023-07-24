package com.busanbank.MBC.eai.eaiManager;

import java.util.Map;

public interface EaiIntegrationManager {
   
    // UMS발송
    Map<String, Object> requestUMSON0001(Map<String, Object> sendData, String host, int port, String envType) throws Exception;
    
}
