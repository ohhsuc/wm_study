package com.learn.dao;

import com.learn.bean.Apply;
import com.learn.bean.ApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApplyMapper {
    long countByExample(ApplyExample example);

    int deleteByExample(ApplyExample example);

    int deleteByPrimaryKey(Integer appId);

    int insert(Apply record);

    int insertSelective(Apply record);

    List<Apply> selectByExample(ApplyExample example);
    
    List<Apply> selectByUserId(Integer uid);
    
    List<Apply> selectByCom(Integer comId);

    Apply selectByPrimaryKey(Integer appId);

    int updateByExampleSelective(@Param("record") Apply record, @Param("example") ApplyExample example);

    int updateByExample(@Param("record") Apply record, @Param("example") ApplyExample example);

    int updateByPrimaryKeySelective(Apply record);

    int updateByPrimaryKey(Apply record);
}