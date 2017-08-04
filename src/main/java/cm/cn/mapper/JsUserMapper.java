package cm.cn.mapper;

import cm.cn.po.JsUser;
import cm.cn.po.JsUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JsUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_user
     *
     * @mbggenerated Fri Aug 04 09:50:34 CST 2017
     */
    int countByExample(JsUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_user
     *
     * @mbggenerated Fri Aug 04 09:50:34 CST 2017
     */
    int deleteByExample(JsUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_user
     *
     * @mbggenerated Fri Aug 04 09:50:34 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_user
     *
     * @mbggenerated Fri Aug 04 09:50:34 CST 2017
     */
    int insert(JsUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_user
     *
     * @mbggenerated Fri Aug 04 09:50:34 CST 2017
     */
    int insertSelective(JsUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_user
     *
     * @mbggenerated Fri Aug 04 09:50:34 CST 2017
     */
    List<JsUser> selectByExample(JsUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_user
     *
     * @mbggenerated Fri Aug 04 09:50:34 CST 2017
     */
    JsUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_user
     *
     * @mbggenerated Fri Aug 04 09:50:34 CST 2017
     */
    int updateByExampleSelective(@Param("record") JsUser record, @Param("example") JsUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_user
     *
     * @mbggenerated Fri Aug 04 09:50:34 CST 2017
     */
    int updateByExample(@Param("record") JsUser record, @Param("example") JsUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_user
     *
     * @mbggenerated Fri Aug 04 09:50:34 CST 2017
     */
    int updateByPrimaryKeySelective(JsUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_user
     *
     * @mbggenerated Fri Aug 04 09:50:34 CST 2017
     */
    int updateByPrimaryKey(JsUser record);
}