package com.busanbank.MBC.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.busanbank.MBC.common.dto.CommonCode;
import com.busanbank.MBC.common.dto.RestResponse;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CommonController extends DefaultController {
  @Autowired private CommonService commonService;

  @RequestMapping(value = "/common/code/group", method = RequestMethod.GET)
  public RestResponse<List<CommonCode>> commonCodeGroupList(CommonCode req) {
    RestResponse<List<CommonCode>> response = new RestResponse<List<CommonCode>>();
    response.setData(commonService.getListCommonCodeGroup(req));
    response.setResultCode("00");
    return response;
  }

  @RequestMapping(value = "/common/code", method = RequestMethod.GET)
  public RestResponse<List<CommonCode>> commonCodeList(CommonCode req) {
    RestResponse<List<CommonCode>> response = new RestResponse<List<CommonCode>>();
    response.setData(commonService.getListCommonCode(req));
    response.setResultCode("00");
    return response;
  }

  @RequestMapping(value = "/common/code", method = RequestMethod.POST)
  public RestResponse<CommonCode> insertCommonCode(@RequestBody CommonCode req) {
    commonService.insertCommonCode(req);

    RestResponse<CommonCode> response = new RestResponse<CommonCode>();
    // response.setData(commonService.getOneCommonCode(req));
    response.setResultCode("00");
    return response;
  }

  @RequestMapping(value = "/common/code/put", method = RequestMethod.POST)
  public RestResponse<CommonCode> updateCommonCode(@RequestBody CommonCode req) {
    commonService.updateCommonCode(req);

    RestResponse<CommonCode> response = new RestResponse<CommonCode>();
    // response.setData(commonService.getOneCommonCode(req));
    response.setResultCode("00");
    return response;
  }

  @RequestMapping(value = "/common/code/delete", method = RequestMethod.POST)
  public RestResponse<CommonCode> deleteCommonCode(@RequestBody CommonCode req) {
    // if (req.getIDD_ROLE_CD() == null) {
    //   log.info("NO IDD_ROLE_CD");
    //   throw new AvcNotMatchedException();
    // }

    commonService.deleteCommonCode(req);

    RestResponse<CommonCode> response = new RestResponse<CommonCode>();
    response.setResultCode("00");
    return response;
  }

  @RequestMapping(value = "/common/code/mapping", method = RequestMethod.GET)
  public RestResponse<List<CommonCode>> skillMappingList(CommonCode req) {
    RestResponse<List<CommonCode>> response = new RestResponse<List<CommonCode>>();
    response.setData(commonService.getListSkillMapping(req));
    response.setResultCode("00");
    return response;
  }
}