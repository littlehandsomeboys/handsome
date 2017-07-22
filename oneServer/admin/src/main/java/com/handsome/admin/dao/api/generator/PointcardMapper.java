package com.handsome.admin.dao.api.generator;

import com.handsome.admin.ao.bean.Pointcard;
import com.handsome.admin.ao.bean.PointcardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PointcardMapper {
    int countByExample(PointcardExample example);

    int deleteByExample(PointcardExample example);

    int deleteByPrimaryKey(String id);

    int insert(Pointcard record);

    int insertSelective(Pointcard record);

    List<Pointcard> selectByExample(PointcardExample example);

    Pointcard selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Pointcard record, @Param("example") PointcardExample example);

    int updateByExample(@Param("record") Pointcard record, @Param("example") PointcardExample example);

    int updateByPrimaryKeySelective(Pointcard record);

    int updateByPrimaryKey(Pointcard record);
}