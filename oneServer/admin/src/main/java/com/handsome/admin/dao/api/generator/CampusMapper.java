package com.handsome.admin.dao.api.generator;

import com.handsome.admin.ao.bean.Campus;
import com.handsome.admin.ao.bean.CampusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CampusMapper {
    int countByExample(CampusExample example);

    int deleteByExample(CampusExample example);

    int deleteByPrimaryKey(String id);

    int insert(Campus record);

    int insertSelective(Campus record);

    List<Campus> selectByExample(CampusExample example);

    Campus selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Campus record, @Param("example") CampusExample example);

    int updateByExample(@Param("record") Campus record, @Param("example") CampusExample example);

    int updateByPrimaryKeySelective(Campus record);

    int updateByPrimaryKey(Campus record);
}