package com.busanbank.MBC.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Pagination {
  @JsonProperty("page")
  private Integer page;

  @JsonProperty("itemsPerPage")
  private Integer itemsPerPage;

  @JsonProperty("sortBy")
  private String sortBy;

  @JsonProperty("sortDesc")
  private String sortDesc;

  @Data
  public static class Response <T> {
    @JsonProperty("list")
    private T list;

    @JsonProperty("totalCount")
    private Integer totalCount;
  }
}