package com.tencent.wxcloudrun.dto;

import lombok.Data;

@Data
public class PushRequest {


  private String serverId;
  private String serverInfo;
  private String warningInfo;
  private String admin;

}
