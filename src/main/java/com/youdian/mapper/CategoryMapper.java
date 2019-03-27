package com.youdian.mapper;

import com.youdian.bean.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author hs
 * @date 2019/2/28 - 20:49
 */
@Mapper
public interface CategoryMapper {

    @Select("select * from category")
    public List<Category> categoryList();

    @Select("select * from category where id=#{id}")
    @Results(
            @Result(property = "examples",column = "id",
            many = @Many(select = "com.youdian.mapper.ExampleMapper.getExampleByCid"))
    )
    public Category getCategoryById(Integer id);

    @Insert("insert into category(cname) values(#{cname})")
    public void insertCategory(Category category);

    @Delete("delete from category where id=#{id}")
    public void deleteCategory(Integer id);

    @Update("update category set cname=#{cname} where id=#{id}")
    public void updateCategory(Category category);


}
