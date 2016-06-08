package com.ehualu.rise.dao.sms;

import java.util.List;

import com.ehualu.rise.pojo.sms.SmsRecord;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface SmsRecordDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SmsRecord record);

    int insertSelective(SmsRecord record);

    SmsRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SmsRecord record);

    int updateByPrimaryKey(SmsRecord record);
    
    int findSmsRecordCount();
    
    List<SmsRecord> findSmsRecord(PageBounds pageBounds);
}