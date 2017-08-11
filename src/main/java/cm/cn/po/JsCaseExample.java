package cm.cn.po;

import java.util.ArrayList;
import java.util.List;

public class JsCaseExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table js_case
     *
     * @mbggenerated Mon Aug 07 15:27:41 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table js_case
     *
     * @mbggenerated Mon Aug 07 15:27:41 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table js_case
     *
     * @mbggenerated Mon Aug 07 15:27:41 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_case
     *
     * @mbggenerated Mon Aug 07 15:27:41 CST 2017
     */
    public JsCaseExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_case
     *
     * @mbggenerated Mon Aug 07 15:27:41 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_case
     *
     * @mbggenerated Mon Aug 07 15:27:41 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_case
     *
     * @mbggenerated Mon Aug 07 15:27:41 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_case
     *
     * @mbggenerated Mon Aug 07 15:27:41 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_case
     *
     * @mbggenerated Mon Aug 07 15:27:41 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_case
     *
     * @mbggenerated Mon Aug 07 15:27:41 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_case
     *
     * @mbggenerated Mon Aug 07 15:27:41 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_case
     *
     * @mbggenerated Mon Aug 07 15:27:41 CST 2017
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
     * This method corresponds to the database table js_case
     *
     * @mbggenerated Mon Aug 07 15:27:41 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table js_case
     *
     * @mbggenerated Mon Aug 07 15:27:41 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table js_case
     *
     * @mbggenerated Mon Aug 07 15:27:41 CST 2017
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

        public Criteria andCaseIdIsNull() {
            addCriterion("case_id is null");
            return (Criteria) this;
        }

        public Criteria andCaseIdIsNotNull() {
            addCriterion("case_id is not null");
            return (Criteria) this;
        }

        public Criteria andCaseIdEqualTo(Integer value) {
            addCriterion("case_id =", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotEqualTo(Integer value) {
            addCriterion("case_id <>", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdGreaterThan(Integer value) {
            addCriterion("case_id >", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("case_id >=", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdLessThan(Integer value) {
            addCriterion("case_id <", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdLessThanOrEqualTo(Integer value) {
            addCriterion("case_id <=", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdIn(List<Integer> values) {
            addCriterion("case_id in", values, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotIn(List<Integer> values) {
            addCriterion("case_id not in", values, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdBetween(Integer value1, Integer value2) {
            addCriterion("case_id between", value1, value2, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("case_id not between", value1, value2, "caseId");
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

        public Criteria andSelectArrayIsNull() {
            addCriterion("select_array is null");
            return (Criteria) this;
        }

        public Criteria andSelectArrayIsNotNull() {
            addCriterion("select_array is not null");
            return (Criteria) this;
        }

        public Criteria andSelectArrayEqualTo(String value) {
            addCriterion("select_array =", value, "selectArray");
            return (Criteria) this;
        }

        public Criteria andSelectArrayNotEqualTo(String value) {
            addCriterion("select_array <>", value, "selectArray");
            return (Criteria) this;
        }

        public Criteria andSelectArrayGreaterThan(String value) {
            addCriterion("select_array >", value, "selectArray");
            return (Criteria) this;
        }

        public Criteria andSelectArrayGreaterThanOrEqualTo(String value) {
            addCriterion("select_array >=", value, "selectArray");
            return (Criteria) this;
        }

        public Criteria andSelectArrayLessThan(String value) {
            addCriterion("select_array <", value, "selectArray");
            return (Criteria) this;
        }

        public Criteria andSelectArrayLessThanOrEqualTo(String value) {
            addCriterion("select_array <=", value, "selectArray");
            return (Criteria) this;
        }

        public Criteria andSelectArrayLike(String value) {
            addCriterion("select_array like", value, "selectArray");
            return (Criteria) this;
        }

        public Criteria andSelectArrayNotLike(String value) {
            addCriterion("select_array not like", value, "selectArray");
            return (Criteria) this;
        }

        public Criteria andSelectArrayIn(List<String> values) {
            addCriterion("select_array in", values, "selectArray");
            return (Criteria) this;
        }

        public Criteria andSelectArrayNotIn(List<String> values) {
            addCriterion("select_array not in", values, "selectArray");
            return (Criteria) this;
        }

        public Criteria andSelectArrayBetween(String value1, String value2) {
            addCriterion("select_array between", value1, value2, "selectArray");
            return (Criteria) this;
        }

        public Criteria andSelectArrayNotBetween(String value1, String value2) {
            addCriterion("select_array not between", value1, value2, "selectArray");
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

        public Criteria andReserveThreeIsNull() {
            addCriterion("reserve_three is null");
            return (Criteria) this;
        }

        public Criteria andReserveThreeIsNotNull() {
            addCriterion("reserve_three is not null");
            return (Criteria) this;
        }

        public Criteria andReserveThreeEqualTo(String value) {
            addCriterion("reserve_three =", value, "reserveThree");
            return (Criteria) this;
        }

        public Criteria andReserveThreeNotEqualTo(String value) {
            addCriterion("reserve_three <>", value, "reserveThree");
            return (Criteria) this;
        }

        public Criteria andReserveThreeGreaterThan(String value) {
            addCriterion("reserve_three >", value, "reserveThree");
            return (Criteria) this;
        }

        public Criteria andReserveThreeGreaterThanOrEqualTo(String value) {
            addCriterion("reserve_three >=", value, "reserveThree");
            return (Criteria) this;
        }

        public Criteria andReserveThreeLessThan(String value) {
            addCriterion("reserve_three <", value, "reserveThree");
            return (Criteria) this;
        }

        public Criteria andReserveThreeLessThanOrEqualTo(String value) {
            addCriterion("reserve_three <=", value, "reserveThree");
            return (Criteria) this;
        }

        public Criteria andReserveThreeLike(String value) {
            addCriterion("reserve_three like", value, "reserveThree");
            return (Criteria) this;
        }

        public Criteria andReserveThreeNotLike(String value) {
            addCriterion("reserve_three not like", value, "reserveThree");
            return (Criteria) this;
        }

        public Criteria andReserveThreeIn(List<String> values) {
            addCriterion("reserve_three in", values, "reserveThree");
            return (Criteria) this;
        }

        public Criteria andReserveThreeNotIn(List<String> values) {
            addCriterion("reserve_three not in", values, "reserveThree");
            return (Criteria) this;
        }

        public Criteria andReserveThreeBetween(String value1, String value2) {
            addCriterion("reserve_three between", value1, value2, "reserveThree");
            return (Criteria) this;
        }

        public Criteria andReserveThreeNotBetween(String value1, String value2) {
            addCriterion("reserve_three not between", value1, value2, "reserveThree");
            return (Criteria) this;
        }

        public Criteria andReserveFourIsNull() {
            addCriterion("reserve_four is null");
            return (Criteria) this;
        }

        public Criteria andReserveFourIsNotNull() {
            addCriterion("reserve_four is not null");
            return (Criteria) this;
        }

        public Criteria andReserveFourEqualTo(String value) {
            addCriterion("reserve_four =", value, "reserveFour");
            return (Criteria) this;
        }

        public Criteria andReserveFourNotEqualTo(String value) {
            addCriterion("reserve_four <>", value, "reserveFour");
            return (Criteria) this;
        }

        public Criteria andReserveFourGreaterThan(String value) {
            addCriterion("reserve_four >", value, "reserveFour");
            return (Criteria) this;
        }

        public Criteria andReserveFourGreaterThanOrEqualTo(String value) {
            addCriterion("reserve_four >=", value, "reserveFour");
            return (Criteria) this;
        }

        public Criteria andReserveFourLessThan(String value) {
            addCriterion("reserve_four <", value, "reserveFour");
            return (Criteria) this;
        }

        public Criteria andReserveFourLessThanOrEqualTo(String value) {
            addCriterion("reserve_four <=", value, "reserveFour");
            return (Criteria) this;
        }

        public Criteria andReserveFourLike(String value) {
            addCriterion("reserve_four like", value, "reserveFour");
            return (Criteria) this;
        }

        public Criteria andReserveFourNotLike(String value) {
            addCriterion("reserve_four not like", value, "reserveFour");
            return (Criteria) this;
        }

        public Criteria andReserveFourIn(List<String> values) {
            addCriterion("reserve_four in", values, "reserveFour");
            return (Criteria) this;
        }

        public Criteria andReserveFourNotIn(List<String> values) {
            addCriterion("reserve_four not in", values, "reserveFour");
            return (Criteria) this;
        }

        public Criteria andReserveFourBetween(String value1, String value2) {
            addCriterion("reserve_four between", value1, value2, "reserveFour");
            return (Criteria) this;
        }

        public Criteria andReserveFourNotBetween(String value1, String value2) {
            addCriterion("reserve_four not between", value1, value2, "reserveFour");
            return (Criteria) this;
        }

        public Criteria andReserveFiveIsNull() {
            addCriterion("reserve_five is null");
            return (Criteria) this;
        }

        public Criteria andReserveFiveIsNotNull() {
            addCriterion("reserve_five is not null");
            return (Criteria) this;
        }

        public Criteria andReserveFiveEqualTo(String value) {
            addCriterion("reserve_five =", value, "reserveFive");
            return (Criteria) this;
        }

        public Criteria andReserveFiveNotEqualTo(String value) {
            addCriterion("reserve_five <>", value, "reserveFive");
            return (Criteria) this;
        }

        public Criteria andReserveFiveGreaterThan(String value) {
            addCriterion("reserve_five >", value, "reserveFive");
            return (Criteria) this;
        }

        public Criteria andReserveFiveGreaterThanOrEqualTo(String value) {
            addCriterion("reserve_five >=", value, "reserveFive");
            return (Criteria) this;
        }

        public Criteria andReserveFiveLessThan(String value) {
            addCriterion("reserve_five <", value, "reserveFive");
            return (Criteria) this;
        }

        public Criteria andReserveFiveLessThanOrEqualTo(String value) {
            addCriterion("reserve_five <=", value, "reserveFive");
            return (Criteria) this;
        }

        public Criteria andReserveFiveLike(String value) {
            addCriterion("reserve_five like", value, "reserveFive");
            return (Criteria) this;
        }

        public Criteria andReserveFiveNotLike(String value) {
            addCriterion("reserve_five not like", value, "reserveFive");
            return (Criteria) this;
        }

        public Criteria andReserveFiveIn(List<String> values) {
            addCriterion("reserve_five in", values, "reserveFive");
            return (Criteria) this;
        }

        public Criteria andReserveFiveNotIn(List<String> values) {
            addCriterion("reserve_five not in", values, "reserveFive");
            return (Criteria) this;
        }

        public Criteria andReserveFiveBetween(String value1, String value2) {
            addCriterion("reserve_five between", value1, value2, "reserveFive");
            return (Criteria) this;
        }

        public Criteria andReserveFiveNotBetween(String value1, String value2) {
            addCriterion("reserve_five not between", value1, value2, "reserveFive");
            return (Criteria) this;
        }

        public Criteria andReserveSixIsNull() {
            addCriterion("reserve_six is null");
            return (Criteria) this;
        }

        public Criteria andReserveSixIsNotNull() {
            addCriterion("reserve_six is not null");
            return (Criteria) this;
        }

        public Criteria andReserveSixEqualTo(String value) {
            addCriterion("reserve_six =", value, "reserveSix");
            return (Criteria) this;
        }

        public Criteria andReserveSixNotEqualTo(String value) {
            addCriterion("reserve_six <>", value, "reserveSix");
            return (Criteria) this;
        }

        public Criteria andReserveSixGreaterThan(String value) {
            addCriterion("reserve_six >", value, "reserveSix");
            return (Criteria) this;
        }

        public Criteria andReserveSixGreaterThanOrEqualTo(String value) {
            addCriterion("reserve_six >=", value, "reserveSix");
            return (Criteria) this;
        }

        public Criteria andReserveSixLessThan(String value) {
            addCriterion("reserve_six <", value, "reserveSix");
            return (Criteria) this;
        }

        public Criteria andReserveSixLessThanOrEqualTo(String value) {
            addCriterion("reserve_six <=", value, "reserveSix");
            return (Criteria) this;
        }

        public Criteria andReserveSixLike(String value) {
            addCriterion("reserve_six like", value, "reserveSix");
            return (Criteria) this;
        }

        public Criteria andReserveSixNotLike(String value) {
            addCriterion("reserve_six not like", value, "reserveSix");
            return (Criteria) this;
        }

        public Criteria andReserveSixIn(List<String> values) {
            addCriterion("reserve_six in", values, "reserveSix");
            return (Criteria) this;
        }

        public Criteria andReserveSixNotIn(List<String> values) {
            addCriterion("reserve_six not in", values, "reserveSix");
            return (Criteria) this;
        }

        public Criteria andReserveSixBetween(String value1, String value2) {
            addCriterion("reserve_six between", value1, value2, "reserveSix");
            return (Criteria) this;
        }

        public Criteria andReserveSixNotBetween(String value1, String value2) {
            addCriterion("reserve_six not between", value1, value2, "reserveSix");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table js_case
     *
     * @mbggenerated do_not_delete_during_merge Mon Aug 07 15:27:41 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table js_case
     *
     * @mbggenerated Mon Aug 07 15:27:41 CST 2017
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