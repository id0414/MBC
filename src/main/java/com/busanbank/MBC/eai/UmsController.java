package com.busanbank.MBC.eai;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.busanbank.MBC.common.DefaultController;
import com.busanbank.MBC.common.dto.RestResponse;
import com.busanbank.MBC.eai.service.BzsEcmServiceImpl;


@RestController
public class UmsController {
  @Value("${eai.host}") private String host;
  @Value("${eai.port}") private int port;
  @Value("${eai.env}") private String envType;
  
  @Autowired private BzsEcmServiceImpl umsService;

  @RequestMapping(value = "/ums", method = RequestMethod.POST)
  public RestResponse<Map<String, Object>> ums(@RequestBody Map<String, Object> params) {
    RestResponse<Map<String, Object>> response = new RestResponse<Map<String, Object>>();
    response.setData(umsService.executeSendUMS(params, host, port, envType));
    response.setResultCode("00");
    return response;
  }
}
