package com.learn.dao;

import com.learn.bean.Resume;
import com.learn.bean.ResumeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResumeMapper {
    long countByExample(ResumeExample example);

    int deleteByExample(ResumeExample example);

    int deleteByPrimaryKey(Integer resId);

    int insert(Resume record);

    int insertSelective(Resume record);

    List<Resume> selectByExample(ResumeExample example);

    Resume selectByPrimaryKey(Integer resId);

    int updateByExampleSelective(@Param("record") Resume record, @Param("example") ResumeExample example);

    int updateByExample(@Param("record") Resume record, @Param("example") ResumeExample example);

    int updateByPrimaryKeySelective(Resume record);

    int updateByPrimaryKey(Resume record);
}