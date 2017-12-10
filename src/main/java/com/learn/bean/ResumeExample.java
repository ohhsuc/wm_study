package com.learn.bean;

import java.util.ArrayList;
import java.util.List;

public class ResumeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResumeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andResIdIsNull() {
            addCriterion("res_id is null");
            return (Criteria) this;
        }

        public Criteria andResIdIsNotNull() {
            addCriterion("res_id is not null");
            return (Criteria) this;
        }

        public Criteria andResIdEqualTo(Integer value) {
            addCriterion("res_id =", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotEqualTo(Integer value) {
            addCriterion("res_id <>", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdGreaterThan(Integer value) {
            addCriterion("res_id >", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("res_id >=", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdLessThan(Integer value) {
            addCriterion("res_id <", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdLessThanOrEqualTo(Integer value) {
            addCriterion("res_id <=", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdIn(List<Integer> values) {
            addCriterion("res_id in", values, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotIn(List<Integer> values) {
            addCriterion("res_id not in", values, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdBetween(Integer value1, Integer value2) {
            addCriterion("res_id between", value1, value2, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotBetween(Integer value1, Integer value2) {
            addCriterion("res_id not between", value1, value2, "resId");
            return (Criteria) this;
        }

        public Criteria andResGenderIsNull() {
            addCriterion("res_gender is null");
            return (Criteria) this;
        }

        public Criteria andResGenderIsNotNull() {
            addCriterion("res_gender is not null");
            return (Criteria) this;
        }

        public Criteria andResGenderEqualTo(String value) {
            addCriterion("res_gender =", value, "resGender");
            return (Criteria) this;
        }

        public Criteria andResGenderNotEqualTo(String value) {
            addCriterion("res_gender <>", value, "resGender");
            return (Criteria) this;
        }

        public Criteria andResGenderGreaterThan(String value) {
            addCriterion("res_gender >", value, "resGender");
            return (Criteria) this;
        }

        public Criteria andResGenderGreaterThanOrEqualTo(String value) {
            addCriterion("res_gender >=", value, "resGender");
            return (Criteria) this;
        }

        public Criteria andResGenderLessThan(String value) {
            addCriterion("res_gender <", value, "resGender");
            return (Criteria) this;
        }

        public Criteria andResGenderLessThanOrEqualTo(String value) {
            addCriterion("res_gender <=", value, "resGender");
            return (Criteria) this;
        }

        public Criteria andResGenderLike(String value) {
            addCriterion("res_gender like", value, "resGender");
            return (Criteria) this;
        }

        public Criteria andResGenderNotLike(String value) {
            addCriterion("res_gender not like", value, "resGender");
            return (Criteria) this;
        }

        public Criteria andResGenderIn(List<String> values) {
            addCriterion("res_gender in", values, "resGender");
            return (Criteria) this;
        }

        public Criteria andResGenderNotIn(List<String> values) {
            addCriterion("res_gender not in", values, "resGender");
            return (Criteria) this;
        }

        public Criteria andResGenderBetween(String value1, String value2) {
            addCriterion("res_gender between", value1, value2, "resGender");
            return (Criteria) this;
        }

        public Criteria andResGenderNotBetween(String value1, String value2) {
            addCriterion("res_gender not between", value1, value2, "resGender");
            return (Criteria) this;
        }

        public Criteria andResPhoneIsNull() {
            addCriterion("res_phone is null");
            return (Criteria) this;
        }

        public Criteria andResPhoneIsNotNull() {
            addCriterion("res_phone is not null");
            return (Criteria) this;
        }

        public Criteria andResPhoneEqualTo(String value) {
            addCriterion("res_phone =", value, "resPhone");
            return (Criteria) this;
        }

        public Criteria andResPhoneNotEqualTo(String value) {
            addCriterion("res_phone <>", value, "resPhone");
            return (Criteria) this;
        }

        public Criteria andResPhoneGreaterThan(String value) {
            addCriterion("res_phone >", value, "resPhone");
            return (Criteria) this;
        }

        public Criteria andResPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("res_phone >=", value, "resPhone");
            return (Criteria) this;
        }

        public Criteria andResPhoneLessThan(String value) {
            addCriterion("res_phone <", value, "resPhone");
            return (Criteria) this;
        }

        public Criteria andResPhoneLessThanOrEqualTo(String value) {
            addCriterion("res_phone <=", value, "resPhone");
            return (Criteria) this;
        }

        public Criteria andResPhoneLike(String value) {
            addCriterion("res_phone like", value, "resPhone");
            return (Criteria) this;
        }

        public Criteria andResPhoneNotLike(String value) {
            addCriterion("res_phone not like", value, "resPhone");
            return (Criteria) this;
        }

        public Criteria andResPhoneIn(List<String> values) {
            addCriterion("res_phone in", values, "resPhone");
            return (Criteria) this;
        }

        public Criteria andResPhoneNotIn(List<String> values) {
            addCriterion("res_phone not in", values, "resPhone");
            return (Criteria) this;
        }

        public Criteria andResPhoneBetween(String value1, String value2) {
            addCriterion("res_phone between", value1, value2, "resPhone");
            return (Criteria) this;
        }

        public Criteria andResPhoneNotBetween(String value1, String value2) {
            addCriterion("res_phone not between", value1, value2, "resPhone");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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