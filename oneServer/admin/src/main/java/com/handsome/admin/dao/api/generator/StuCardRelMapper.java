package com.handsome.admin.dao.api.generator;

import com.handsome.admin.ao.bean.StuCardRel;
import com.handsome.admin.ao.bean.StuCardRelExample;
import com.handsome.admin.ao.bean.StuCardRelKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StuCardRelMapper {
    int countByExample(StuCardRelExample example);

    int deleteByExample(StuCardRelExample example);

    int deleteByPrimaryKey(StuCardRelKey key);

    int insert(StuCardRel record);

    int insertSelective(StuCardRel record);

    List<StuCardRel> selectByExample(StuCardRelExample example);

    StuCardRel selectByPrimaryKey(StuCardRelKey key);

    int updateByExampleSelective(@Param("record") StuCardRel record, @Param("example") StuCardRelExample example);

    int updateByExample(@Param("record") StuCardRel record, @Param("example") StuCardRelExample example);

    int updateByPrimaryKeySelective(StuCardRel record);

    int updateByPrimaryKey(StuCardRel record);
}