package com.busanbank.MBC.common;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.busanbank.MBC.common.dto.Configuration;

@Repository
public interface ConfigurationRepository {
  public Configuration getOne(@Param("data") Configuration data);
  public List<Configuration> getList(@Param("data") Configuration data);
  public void insert(@Param("data") Configuration data);
  public void update(@Param("data") Configuration data);
  public void delete(@Param("data") Configuration data);
}