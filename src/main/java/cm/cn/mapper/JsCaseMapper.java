package cm.cn.mapper;

import cm.cn.po.JsCase;
import cm.cn.po.JsCaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JsCaseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_case
     *
     * @mbggenerated Mon Aug 07 15:27:41 CST 2017
     */
    int countByExample(JsCaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_case
     *
     * @mbggenerated Mon Aug 07 15:27:41 CST 2017
     */
    int deleteByExample(JsCaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_case
     *
     * @mbggenerated Mon Aug 07 15:27:41 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_case
     *
     * @mbggenerated Mon Aug 07 15:27:41 CST 2017
     */
    int insert(JsCase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_case
     *
     * @mbggenerated Mon Aug 07 15:27:41 CST 2017
     */
    int insertSelective(JsCase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_case
     *
     * @mbggenerated Mon Aug 07 15:27:41 CST 2017
     */
    List<JsCase> selectByExample(JsCaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_case
     *
     * @mbggenerated Mon Aug 07 15:27:41 CST 2017
     */
    JsCase selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_case
     *
     * @mbggenerated Mon Aug 07 15:27:41 CST 2017
     */
    int updateByExampleSelective(@Param("record") JsCase record, @Param("example") JsCaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_case
     *
     * @mbggenerated Mon Aug 07 15:27:41 CST 2017
     */
    int updateByExample(@Param("record") JsCase record, @Param("example") JsCaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_case
     *
     * @mbggenerated Mon Aug 07 15:27:41 CST 2017
     */
    int updateByPrimaryKeySelective(JsCase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_case
     *
     * @mbggenerated Mon Aug 07 15:27:41 CST 2017
     */
    int updateByPrimaryKey(JsCase record);
}