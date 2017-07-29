package com.handsome.admin.dao.api.generator;

import com.handsome.admin.ao.bean.Title;
import com.handsome.admin.ao.bean.TitleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TitleMapper {
    int countByExample(TitleExample example);

    int deleteByExample(TitleExample example);

    int deleteByPrimaryKey(String id);

    int insert(Title record);

    int insertSelective(Title record);

    List<Title> selectByExample(TitleExample example);

    Title selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Title record, @Param("example") TitleExample example);

    int updateByExample(@Param("record") Title record, @Param("example") TitleExample example);

    int updateByPrimaryKeySelective(Title record);

    int updateByPrimaryKey(Title record);
}