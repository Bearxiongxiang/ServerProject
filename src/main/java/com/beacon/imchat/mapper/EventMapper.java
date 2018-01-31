package com.beacon.imchat.mapper;

import com.beacon.imchat.domain.Event;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EventMapper {

    /**
     * 获取所有的事件
     * @return 所有事件列表
     */
    List<Event> getEvents();

    /**
     * 同个事件名称查询单个事件
     * @param eventName
     * @return 单个事件
     */
    Event getEventByName(@Param("eventName") String eventName);

    /**
     * 保存事件
     * @param eventBean
     * @return 返回结果
     */
    int saveEvent(Event eventBean);

    /**
     * 更新事件
     * @param eventBean
     * @return 返回更新结果
     */
    int updateEvent(Event eventBean);

    /**
     * 删除事件
     * @param eventName
     * @return 返回删除结果
     */
    int deleteEvent(String eventName);
}
