package com.busanbank.MBC.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busanbank.MBC.common.dto.Configuration;

@Service
public class ConfigurationService {
  @Autowired private ConfigurationRepository configurationRepository;

  public Configuration getOne(Configuration req) {
    return configurationRepository.getOne(req);
  }

  public List<Configuration> getList(Configuration data) {
    return configurationRepository.getList(data);
  }
  
  public void insert(Configuration req) {
    configurationRepository.insert(req);
  }

  public void update(Configuration req) {
    configurationRepository.update(req);
  }
}