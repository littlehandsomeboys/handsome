package com.handsome.admin.dao.api.generator;

import com.handsome.admin.ao.bean.Camp;
import com.handsome.admin.ao.bean.CampExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CampMapper {
    int countByExample(CampExample example);

    int deleteByExample(CampExample example);

    int deleteByPrimaryKey(String id);

    int insert(Camp record);

    int insertSelective(Camp record);

    List<Camp> selectByExample(CampExample example);

    Camp selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Camp record, @Param("example") CampExample example);

    int updateByExample(@Param("record") Camp record, @Param("example") CampExample example);

    int updateByPrimaryKeySelective(Camp record);

    int updateByPrimaryKey(Camp record);
}