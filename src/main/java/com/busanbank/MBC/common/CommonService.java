package com.busanbank.MBC.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busanbank.MBC.common.dto.CommonCode;

@Service
public class CommonService {
  @Autowired private CommonRepository commonRepository;

  // common code

  public CommonCode getOneCommonCode(CommonCode req) {
    return commonRepository.getOneCommonCode(req);
  }

  public List<CommonCode> getListCommonCode(CommonCode data) {
    return commonRepository.getListCommonCode(data);
  }

  public List<CommonCode> getListCommonCodeGroup(CommonCode data) {
    return commonRepository.getListCommonCodeGroup(data);
  }

  public void insertCommonCode(CommonCode req) {
    commonRepository.insertCommonCode(req);
  }

  public void updateCommonCode(CommonCode req) {
    commonRepository.updateCommonCode(req);
  }

  public void deleteCommonCode(CommonCode req) {
    commonRepository.deleteCommonCode(req);
  }

  public List<CommonCode> getListSkillMapping(CommonCode data) {
    return commonRepository.getListSkillMapping(data);
  }
}