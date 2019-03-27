package com.youdian.mapper;

import com.youdian.bean.State;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author hs
 * @date 2019/3/3 - 11:18
 */
@Mapper
public interface StateMapper {

    @Select("select * from state where id=#{id}")
    public State getStateById(Integer id);

    @Select("select * from state ORDER BY updatetime  DESC")
    public List<State> stateList();

    @Select("SELECT * FROM state ORDER BY updatetime  DESC LIMIT 0,3")
    public List<State> stateListByDesc();

    @Insert("insert into state(title,image,miaoshu,updatetime,pageview) values(#{title},#{image},#{miaoshu},#{updatetime},#{pageview})")
    public void insertState(State state);

    @Update("update state set title=#{title},image=#{image},miaoshu=#{miaoshu},updatetime=#{updatetime} where id=#{id}")
    public void updateState(State state);

    @Delete("delete from state where id=#{id}")
    public void deleteState(Integer id);

    @Update("update state set pageview=#{pageview} where id = #{id}")
    public void updatePageview(State state);

    @Select("SELECT * FROM state WHERE id > #{id} ORDER BY id LIMIT 0,1; ")
    public State getNextId(Integer id);
}
