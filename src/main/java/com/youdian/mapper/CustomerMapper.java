package com.youdian.mapper;

import com.youdian.bean.Customer;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hs
 * @date 2019/3/18 - 21:05
 */
@Mapper
public interface CustomerMapper {

    @Insert("insert into customer(username,telephone,linktime,gbook) values(#{username},#{telephone},#{linktime},#{gbook})")
    public void insertCustomer(Customer customer);

    @Delete("delete from customer where id=#{id}")
    public void deleteCustomer(Integer id);

    @Select("select * from customer")
    public List<Customer> customerList();

}
