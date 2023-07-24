package com.busanbank.MBC.common;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.busanbank.MBC.common.dto.CommonCode;

@Repository
public interface CommonRepository {
  // common code
  public CommonCode getOneCommonCode(@Param("data") CommonCode data);
  public List<CommonCode> getListCommonCode(@Param("data") CommonCode data);
  public List<CommonCode> getListCommonCodeGroup(@Param("data") CommonCode data);
  public void insertCommonCode(@Param("data") CommonCode data);
  public void updateCommonCode(@Param("data") CommonCode data);
  public void deleteCommonCode(@Param("data") CommonCode data);
  public List<CommonCode> getListSkillMapping(@Param("data") CommonCode data);
}