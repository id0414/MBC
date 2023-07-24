package com.busanbank.MBC.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.busanbank.MBC.common.dto.Configuration;
import com.busanbank.MBC.common.dto.RestResponse;

@RestController
public class ConfigurationController extends DefaultController {
  @Autowired private ConfigurationService configurationService;

  @RequestMapping(value = "/common/configuration/get", method = RequestMethod.POST)
  public RestResponse<List<Configuration>> configList(@RequestBody Configuration req) {
    RestResponse<List<Configuration>> response = new RestResponse<List<Configuration>>();
    response.setData(configurationService.getList(req));
    response.setResultCode("00");
    return response;
  }
  
  @RequestMapping(value = "/common/configuration/put", method = RequestMethod.POST)
  public RestResponse<Configuration> updateConfig(@RequestBody Configuration req) {
    configurationService.update(req);

    RestResponse<Configuration> response = new RestResponse<Configuration>();
    response.setData(configurationService.getOne(req));
    response.setResultCode("00");
    return response;
  }
}