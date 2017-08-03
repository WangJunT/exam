package cm.cn.po;

import java.util.ArrayList;
import java.util.List;

public class JsCasequestionExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table js_casequestion
     *
     * @mbggenerated Wed Aug 02 20:12:20 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table js_casequestion
     *
     * @mbggenerated Wed Aug 02 20:12:20 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table js_casequestion
     *
     * @mbggenerated Wed Aug 02 20:12:20 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_casequestion
     *
     * @mbggenerated Wed Aug 02 20:12:20 CST 2017
     */
    public JsCasequestionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_casequestion
     *
     * @mbggenerated Wed Aug 02 20:12:20 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_casequestion
     *
     * @mbggenerated Wed Aug 02 20:12:20 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_casequestion
     *
     * @mbggenerated Wed Aug 02 20:12:20 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_casequestion
     *
     * @mbggenerated Wed Aug 02 20:12:20 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_casequestion
     *
     * @mbggenerated Wed Aug 02 20:12:20 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_casequestion
     *
     * @mbggenerated Wed Aug 02 20:12:20 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_casequestion
     *
     * @mbggenerated Wed Aug 02 20:12:20 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_casequestion
     *
     * @mbggenerated Wed Aug 02 20:12:20 CST 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_casequestion
     *
     * @mbggenerated Wed Aug 02 20:12:20 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_casequestion
     *
     * @mbggenerated Wed Aug 02 20:12:20 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table js_casequestion
     *
     * @mbggenerated Wed Aug 02 20:12:20 CST 2017
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRealIdIsNull() {
            addCriterion("real_id is null");
            return (Criteria) this;
        }

        public Criteria andRealIdIsNotNull() {
            addCriterion("real_id is not null");
            return (Criteria) this;
        }

        public Criteria andRealIdEqualTo(Integer value) {
            addCriterion("real_id =", value, "realId");
            return (Criteria) this;
        }

        public Criteria andRealIdNotEqualTo(Integer value) {
            addCriterion("real_id <>", value, "realId");
            return (Criteria) this;
        }

        public Criteria andRealIdGreaterThan(Integer value) {
            addCriterion("real_id >", value, "realId");
            return (Criteria) this;
        }

        public Criteria andRealIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("real_id >=", value, "realId");
            return (Criteria) this;
        }

        public Criteria andRealIdLessThan(Integer value) {
            addCriterion("real_id <", value, "realId");
            return (Criteria) this;
        }

        public Criteria andRealIdLessThanOrEqualTo(Integer value) {
            addCriterion("real_id <=", value, "realId");
            return (Criteria) this;
        }

        public Criteria andRealIdIn(List<Integer> values) {
            addCriterion("real_id in", values, "realId");
            return (Criteria) this;
        }

        public Criteria andRealIdNotIn(List<Integer> values) {
            addCriterion("real_id not in", values, "realId");
            return (Criteria) this;
        }

        public Criteria andRealIdBetween(Integer value1, Integer value2) {
            addCriterion("real_id between", value1, value2, "realId");
            return (Criteria) this;
        }

        public Criteria andRealIdNotBetween(Integer value1, Integer value2) {
            addCriterion("real_id not between", value1, value2, "realId");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andAnAIsNull() {
            addCriterion("an_A is null");
            return (Criteria) this;
        }

        public Criteria andAnAIsNotNull() {
            addCriterion("an_A is not null");
            return (Criteria) this;
        }

        public Criteria andAnAEqualTo(String value) {
            addCriterion("an_A =", value, "anA");
            return (Criteria) this;
        }

        public Criteria andAnANotEqualTo(String value) {
            addCriterion("an_A <>", value, "anA");
            return (Criteria) this;
        }

        public Criteria andAnAGreaterThan(String value) {
            addCriterion("an_A >", value, "anA");
            return (Criteria) this;
        }

        public Criteria andAnAGreaterThanOrEqualTo(String value) {
            addCriterion("an_A >=", value, "anA");
            return (Criteria) this;
        }

        public Criteria andAnALessThan(String value) {
            addCriterion("an_A <", value, "anA");
            return (Criteria) this;
        }

        public Criteria andAnALessThanOrEqualTo(String value) {
            addCriterion("an_A <=", value, "anA");
            return (Criteria) this;
        }

        public Criteria andAnALike(String value) {
            addCriterion("an_A like", value, "anA");
            return (Criteria) this;
        }

        public Criteria andAnANotLike(String value) {
            addCriterion("an_A not like", value, "anA");
            return (Criteria) this;
        }

        public Criteria andAnAIn(List<String> values) {
            addCriterion("an_A in", values, "anA");
            return (Criteria) this;
        }

        public Criteria andAnANotIn(List<String> values) {
            addCriterion("an_A not in", values, "anA");
            return (Criteria) this;
        }

        public Criteria andAnABetween(String value1, String value2) {
            addCriterion("an_A between", value1, value2, "anA");
            return (Criteria) this;
        }

        public Criteria andAnANotBetween(String value1, String value2) {
            addCriterion("an_A not between", value1, value2, "anA");
            return (Criteria) this;
        }

        public Criteria andAnBIsNull() {
            addCriterion("an_B is null");
            return (Criteria) this;
        }

        public Criteria andAnBIsNotNull() {
            addCriterion("an_B is not null");
            return (Criteria) this;
        }

        public Criteria andAnBEqualTo(String value) {
            addCriterion("an_B =", value, "anB");
            return (Criteria) this;
        }

        public Criteria andAnBNotEqualTo(String value) {
            addCriterion("an_B <>", value, "anB");
            return (Criteria) this;
        }

        public Criteria andAnBGreaterThan(String value) {
            addCriterion("an_B >", value, "anB");
            return (Criteria) this;
        }

        public Criteria andAnBGreaterThanOrEqualTo(String value) {
            addCriterion("an_B >=", value, "anB");
            return (Criteria) this;
        }

        public Criteria andAnBLessThan(String value) {
            addCriterion("an_B <", value, "anB");
            return (Criteria) this;
        }

        public Criteria andAnBLessThanOrEqualTo(String value) {
            addCriterion("an_B <=", value, "anB");
            return (Criteria) this;
        }

        public Criteria andAnBLike(String value) {
            addCriterion("an_B like", value, "anB");
            return (Criteria) this;
        }

        public Criteria andAnBNotLike(String value) {
            addCriterion("an_B not like", value, "anB");
            return (Criteria) this;
        }

        public Criteria andAnBIn(List<String> values) {
            addCriterion("an_B in", values, "anB");
            return (Criteria) this;
        }

        public Criteria andAnBNotIn(List<String> values) {
            addCriterion("an_B not in", values, "anB");
            return (Criteria) this;
        }

        public Criteria andAnBBetween(String value1, String value2) {
            addCriterion("an_B between", value1, value2, "anB");
            return (Criteria) this;
        }

        public Criteria andAnBNotBetween(String value1, String value2) {
            addCriterion("an_B not between", value1, value2, "anB");
            return (Criteria) this;
        }

        public Criteria andAnCIsNull() {
            addCriterion("an_C is null");
            return (Criteria) this;
        }

        public Criteria andAnCIsNotNull() {
            addCriterion("an_C is not null");
            return (Criteria) this;
        }

        public Criteria andAnCEqualTo(String value) {
            addCriterion("an_C =", value, "anC");
            return (Criteria) this;
        }

        public Criteria andAnCNotEqualTo(String value) {
            addCriterion("an_C <>", value, "anC");
            return (Criteria) this;
        }

        public Criteria andAnCGreaterThan(String value) {
            addCriterion("an_C >", value, "anC");
            return (Criteria) this;
        }

        public Criteria andAnCGreaterThanOrEqualTo(String value) {
            addCriterion("an_C >=", value, "anC");
            return (Criteria) this;
        }

        public Criteria andAnCLessThan(String value) {
            addCriterion("an_C <", value, "anC");
            return (Criteria) this;
        }

        public Criteria andAnCLessThanOrEqualTo(String value) {
            addCriterion("an_C <=", value, "anC");
            return (Criteria) this;
        }

        public Criteria andAnCLike(String value) {
            addCriterion("an_C like", value, "anC");
            return (Criteria) this;
        }

        public Criteria andAnCNotLike(String value) {
            addCriterion("an_C not like", value, "anC");
            return (Criteria) this;
        }

        public Criteria andAnCIn(List<String> values) {
            addCriterion("an_C in", values, "anC");
            return (Criteria) this;
        }

        public Criteria andAnCNotIn(List<String> values) {
            addCriterion("an_C not in", values, "anC");
            return (Criteria) this;
        }

        public Criteria andAnCBetween(String value1, String value2) {
            addCriterion("an_C between", value1, value2, "anC");
            return (Criteria) this;
        }

        public Criteria andAnCNotBetween(String value1, String value2) {
            addCriterion("an_C not between", value1, value2, "anC");
            return (Criteria) this;
        }

        public Criteria andAnDIsNull() {
            addCriterion("an_D is null");
            return (Criteria) this;
        }

        public Criteria andAnDIsNotNull() {
            addCriterion("an_D is not null");
            return (Criteria) this;
        }

        public Criteria andAnDEqualTo(String value) {
            addCriterion("an_D =", value, "anD");
            return (Criteria) this;
        }

        public Criteria andAnDNotEqualTo(String value) {
            addCriterion("an_D <>", value, "anD");
            return (Criteria) this;
        }

        public Criteria andAnDGreaterThan(String value) {
            addCriterion("an_D >", value, "anD");
            return (Criteria) this;
        }

        public Criteria andAnDGreaterThanOrEqualTo(String value) {
            addCriterion("an_D >=", value, "anD");
            return (Criteria) this;
        }

        public Criteria andAnDLessThan(String value) {
            addCriterion("an_D <", value, "anD");
            return (Criteria) this;
        }

        public Criteria andAnDLessThanOrEqualTo(String value) {
            addCriterion("an_D <=", value, "anD");
            return (Criteria) this;
        }

        public Criteria andAnDLike(String value) {
            addCriterion("an_D like", value, "anD");
            return (Criteria) this;
        }

        public Criteria andAnDNotLike(String value) {
            addCriterion("an_D not like", value, "anD");
            return (Criteria) this;
        }

        public Criteria andAnDIn(List<String> values) {
            addCriterion("an_D in", values, "anD");
            return (Criteria) this;
        }

        public Criteria andAnDNotIn(List<String> values) {
            addCriterion("an_D not in", values, "anD");
            return (Criteria) this;
        }

        public Criteria andAnDBetween(String value1, String value2) {
            addCriterion("an_D between", value1, value2, "anD");
            return (Criteria) this;
        }

        public Criteria andAnDNotBetween(String value1, String value2) {
            addCriterion("an_D not between", value1, value2, "anD");
            return (Criteria) this;
        }

        public Criteria andAnEIsNull() {
            addCriterion("an_E is null");
            return (Criteria) this;
        }

        public Criteria andAnEIsNotNull() {
            addCriterion("an_E is not null");
            return (Criteria) this;
        }

        public Criteria andAnEEqualTo(String value) {
            addCriterion("an_E =", value, "anE");
            return (Criteria) this;
        }

        public Criteria andAnENotEqualTo(String value) {
            addCriterion("an_E <>", value, "anE");
            return (Criteria) this;
        }

        public Criteria andAnEGreaterThan(String value) {
            addCriterion("an_E >", value, "anE");
            return (Criteria) this;
        }

        public Criteria andAnEGreaterThanOrEqualTo(String value) {
            addCriterion("an_E >=", value, "anE");
            return (Criteria) this;
        }

        public Criteria andAnELessThan(String value) {
            addCriterion("an_E <", value, "anE");
            return (Criteria) this;
        }

        public Criteria andAnELessThanOrEqualTo(String value) {
            addCriterion("an_E <=", value, "anE");
            return (Criteria) this;
        }

        public Criteria andAnELike(String value) {
            addCriterion("an_E like", value, "anE");
            return (Criteria) this;
        }

        public Criteria andAnENotLike(String value) {
            addCriterion("an_E not like", value, "anE");
            return (Criteria) this;
        }

        public Criteria andAnEIn(List<String> values) {
            addCriterion("an_E in", values, "anE");
            return (Criteria) this;
        }

        public Criteria andAnENotIn(List<String> values) {
            addCriterion("an_E not in", values, "anE");
            return (Criteria) this;
        }

        public Criteria andAnEBetween(String value1, String value2) {
            addCriterion("an_E between", value1, value2, "anE");
            return (Criteria) this;
        }

        public Criteria andAnENotBetween(String value1, String value2) {
            addCriterion("an_E not between", value1, value2, "anE");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNull() {
            addCriterion("answer is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNotNull() {
            addCriterion("answer is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerEqualTo(String value) {
            addCriterion("answer =", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotEqualTo(String value) {
            addCriterion("answer <>", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThan(String value) {
            addCriterion("answer >", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("answer >=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThan(String value) {
            addCriterion("answer <", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThanOrEqualTo(String value) {
            addCriterion("answer <=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLike(String value) {
            addCriterion("answer like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotLike(String value) {
            addCriterion("answer not like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerIn(List<String> values) {
            addCriterion("answer in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotIn(List<String> values) {
            addCriterion("answer not in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerBetween(String value1, String value2) {
            addCriterion("answer between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotBetween(String value1, String value2) {
            addCriterion("answer not between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andReserveOneIsNull() {
            addCriterion("reserve_one is null");
            return (Criteria) this;
        }

        public Criteria andReserveOneIsNotNull() {
            addCriterion("reserve_one is not null");
            return (Criteria) this;
        }

        public Criteria andReserveOneEqualTo(String value) {
            addCriterion("reserve_one =", value, "reserveOne");
            return (Criteria) this;
        }

        public Criteria andReserveOneNotEqualTo(String value) {
            addCriterion("reserve_one <>", value, "reserveOne");
            return (Criteria) this;
        }

        public Criteria andReserveOneGreaterThan(String value) {
            addCriterion("reserve_one >", value, "reserveOne");
            return (Criteria) this;
        }

        public Criteria andReserveOneGreaterThanOrEqualTo(String value) {
            addCriterion("reserve_one >=", value, "reserveOne");
            return (Criteria) this;
        }

        public Criteria andReserveOneLessThan(String value) {
            addCriterion("reserve_one <", value, "reserveOne");
            return (Criteria) this;
        }

        public Criteria andReserveOneLessThanOrEqualTo(String value) {
            addCriterion("reserve_one <=", value, "reserveOne");
            return (Criteria) this;
        }

        public Criteria andReserveOneLike(String value) {
            addCriterion("reserve_one like", value, "reserveOne");
            return (Criteria) this;
        }

        public Criteria andReserveOneNotLike(String value) {
            addCriterion("reserve_one not like", value, "reserveOne");
            return (Criteria) this;
        }

        public Criteria andReserveOneIn(List<String> values) {
            addCriterion("reserve_one in", values, "reserveOne");
            return (Criteria) this;
        }

        public Criteria andReserveOneNotIn(List<String> values) {
            addCriterion("reserve_one not in", values, "reserveOne");
            return (Criteria) this;
        }

        public Criteria andReserveOneBetween(String value1, String value2) {
            addCriterion("reserve_one between", value1, value2, "reserveOne");
            return (Criteria) this;
        }

        public Criteria andReserveOneNotBetween(String value1, String value2) {
            addCriterion("reserve_one not between", value1, value2, "reserveOne");
            return (Criteria) this;
        }

        public Criteria andReserveTwoIsNull() {
            addCriterion("reserve_two is null");
            return (Criteria) this;
        }

        public Criteria andReserveTwoIsNotNull() {
            addCriterion("reserve_two is not null");
            return (Criteria) this;
        }

        public Criteria andReserveTwoEqualTo(String value) {
            addCriterion("reserve_two =", value, "reserveTwo");
            return (Criteria) this;
        }

        public Criteria andReserveTwoNotEqualTo(String value) {
            addCriterion("reserve_two <>", value, "reserveTwo");
            return (Criteria) this;
        }

        public Criteria andReserveTwoGreaterThan(String value) {
            addCriterion("reserve_two >", value, "reserveTwo");
            return (Criteria) this;
        }

        public Criteria andReserveTwoGreaterThanOrEqualTo(String value) {
            addCriterion("reserve_two >=", value, "reserveTwo");
            return (Criteria) this;
        }

        public Criteria andReserveTwoLessThan(String value) {
            addCriterion("reserve_two <", value, "reserveTwo");
            return (Criteria) this;
        }

        public Criteria andReserveTwoLessThanOrEqualTo(String value) {
            addCriterion("reserve_two <=", value, "reserveTwo");
            return (Criteria) this;
        }

        public Criteria andReserveTwoLike(String value) {
            addCriterion("reserve_two like", value, "reserveTwo");
            return (Criteria) this;
        }

        public Criteria andReserveTwoNotLike(String value) {
            addCriterion("reserve_two not like", value, "reserveTwo");
            return (Criteria) this;
        }

        public Criteria andReserveTwoIn(List<String> values) {
            addCriterion("reserve_two in", values, "reserveTwo");
            return (Criteria) this;
        }

        public Criteria andReserveTwoNotIn(List<String> values) {
            addCriterion("reserve_two not in", values, "reserveTwo");
            return (Criteria) this;
        }

        public Criteria andReserveTwoBetween(String value1, String value2) {
            addCriterion("reserve_two between", value1, value2, "reserveTwo");
            return (Criteria) this;
        }

        public Criteria andReserveTwoNotBetween(String value1, String value2) {
            addCriterion("reserve_two not between", value1, value2, "reserveTwo");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table js_casequestion
     *
     * @mbggenerated do_not_delete_during_merge Wed Aug 02 20:12:20 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table js_casequestion
     *
     * @mbggenerated Wed Aug 02 20:12:20 CST 2017
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}