package com.handsome.admin.dao.api.generator;

import com.handsome.admin.ao.bean.CcLl;
import com.handsome.admin.ao.bean.CcLlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CcLlMapper {
    int countByExample(CcLlExample example);

    int deleteByExample(CcLlExample example);

    int deleteByPrimaryKey(String id);

    int insert(CcLl record);

    int insertSelective(CcLl record);

    List<CcLl> selectByExample(CcLlExample example);

    CcLl selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CcLl record, @Param("example") CcLlExample example);

    int updateByExample(@Param("record") CcLl record, @Param("example") CcLlExample example);

    int updateByPrimaryKeySelective(CcLl record);

    int updateByPrimaryKey(CcLl record);
}