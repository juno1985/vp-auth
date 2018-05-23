package org.softcits.auth.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.softcits.auth.model.MbgRole;
import org.softcits.auth.model.MbgRoleExample;

public interface MbgRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles
     *
     * @mbg.generated Wed May 23 16:30:48 CST 2018
     */
    long countByExample(MbgRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles
     *
     * @mbg.generated Wed May 23 16:30:48 CST 2018
     */
    int deleteByExample(MbgRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles
     *
     * @mbg.generated Wed May 23 16:30:48 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles
     *
     * @mbg.generated Wed May 23 16:30:48 CST 2018
     */
    int insert(MbgRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles
     *
     * @mbg.generated Wed May 23 16:30:48 CST 2018
     */
    int insertSelective(MbgRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles
     *
     * @mbg.generated Wed May 23 16:30:48 CST 2018
     */
    List<MbgRole> selectByExample(MbgRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles
     *
     * @mbg.generated Wed May 23 16:30:48 CST 2018
     */
    MbgRole selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles
     *
     * @mbg.generated Wed May 23 16:30:48 CST 2018
     */
    int updateByExampleSelective(@Param("record") MbgRole record, @Param("example") MbgRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles
     *
     * @mbg.generated Wed May 23 16:30:48 CST 2018
     */
    int updateByExample(@Param("record") MbgRole record, @Param("example") MbgRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles
     *
     * @mbg.generated Wed May 23 16:30:48 CST 2018
     */
    int updateByPrimaryKeySelective(MbgRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles
     *
     * @mbg.generated Wed May 23 16:30:48 CST 2018
     */
    int updateByPrimaryKey(MbgRole record);
}