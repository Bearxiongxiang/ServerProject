package com.beacon.imchat.mapper;


import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by F1331886 on 2018/1/18 0018.
 */
@Mapper
public interface SystemMapper {

    int insertSystem(System system);

    String findSystemTopic(String sysName);



}
