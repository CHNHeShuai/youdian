package com.youdian.mapper;

import com.youdian.bean.Company;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author hs
 * @date 2019/3/3 - 11:18
 */
@Mapper
public interface CompanyMapper {

    @Select("select * from company where id=#{id}")
    public Company getCompanyById(Integer id);

    @Update("update company set jianjie=#{jianjie},linian=#{linian},jiazhiguan=#{jiazhiguan},kouhao=#{kouhao},historyimage=#{historyimage},history=#{history},telephone=#{telephone},email=#{email},address=#{address} where id=#{id}")
    public void updateCompany(Company company);
}
