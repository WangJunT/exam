package cm.cn.mapper;

import cm.cn.po.JsLevel;
import cm.cn.po.JsLevelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JsLevelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_level
     *
     * @mbggenerated Fri Aug 25 16:57:36 CST 2017
     */
    int countByExample(JsLevelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_level
     *
     * @mbggenerated Fri Aug 25 16:57:36 CST 2017
     */
    int deleteByExample(JsLevelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_level
     *
     * @mbggenerated Fri Aug 25 16:57:36 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_level
     *
     * @mbggenerated Fri Aug 25 16:57:36 CST 2017
     */
    int insert(JsLevel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_level
     *
     * @mbggenerated Fri Aug 25 16:57:36 CST 2017
     */
    int insertSelective(JsLevel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_level
     *
     * @mbggenerated Fri Aug 25 16:57:36 CST 2017
     */
    List<JsLevel> selectByExample(JsLevelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_level
     *
     * @mbggenerated Fri Aug 25 16:57:36 CST 2017
     */
    JsLevel selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_level
     *
     * @mbggenerated Fri Aug 25 16:57:36 CST 2017
     */
    int updateByExampleSelective(@Param("record") JsLevel record, @Param("example") JsLevelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_level
     *
     * @mbggenerated Fri Aug 25 16:57:36 CST 2017
     */
    int updateByExample(@Param("record") JsLevel record, @Param("example") JsLevelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_level
     *
     * @mbggenerated Fri Aug 25 16:57:36 CST 2017
     */
    int updateByPrimaryKeySelective(JsLevel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_level
     *
     * @mbggenerated Fri Aug 25 16:57:36 CST 2017
     */
    int updateByPrimaryKey(JsLevel record);
}