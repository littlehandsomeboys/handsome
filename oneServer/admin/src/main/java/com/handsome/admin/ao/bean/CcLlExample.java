package com.handsome.admin.ao.bean;

import java.util.ArrayList;
import java.util.List;

public class CcLlExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CcLlExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSelect1IsNull() {
            addCriterion("select1 is null");
            return (Criteria) this;
        }

        public Criteria andSelect1IsNotNull() {
            addCriterion("select1 is not null");
            return (Criteria) this;
        }

        public Criteria andSelect1EqualTo(String value) {
            addCriterion("select1 =", value, "select1");
            return (Criteria) this;
        }

        public Criteria andSelect1NotEqualTo(String value) {
            addCriterion("select1 <>", value, "select1");
            return (Criteria) this;
        }

        public Criteria andSelect1GreaterThan(String value) {
            addCriterion("select1 >", value, "select1");
            return (Criteria) this;
        }

        public Criteria andSelect1GreaterThanOrEqualTo(String value) {
            addCriterion("select1 >=", value, "select1");
            return (Criteria) this;
        }

        public Criteria andSelect1LessThan(String value) {
            addCriterion("select1 <", value, "select1");
            return (Criteria) this;
        }

        public Criteria andSelect1LessThanOrEqualTo(String value) {
            addCriterion("select1 <=", value, "select1");
            return (Criteria) this;
        }

        public Criteria andSelect1Like(String value) {
            addCriterion("select1 like", value, "select1");
            return (Criteria) this;
        }

        public Criteria andSelect1NotLike(String value) {
            addCriterion("select1 not like", value, "select1");
            return (Criteria) this;
        }

        public Criteria andSelect1In(List<String> values) {
            addCriterion("select1 in", values, "select1");
            return (Criteria) this;
        }

        public Criteria andSelect1NotIn(List<String> values) {
            addCriterion("select1 not in", values, "select1");
            return (Criteria) this;
        }

        public Criteria andSelect1Between(String value1, String value2) {
            addCriterion("select1 between", value1, value2, "select1");
            return (Criteria) this;
        }

        public Criteria andSelect1NotBetween(String value1, String value2) {
            addCriterion("select1 not between", value1, value2, "select1");
            return (Criteria) this;
        }

        public Criteria andSelect2IsNull() {
            addCriterion("select2 is null");
            return (Criteria) this;
        }

        public Criteria andSelect2IsNotNull() {
            addCriterion("select2 is not null");
            return (Criteria) this;
        }

        public Criteria andSelect2EqualTo(String value) {
            addCriterion("select2 =", value, "select2");
            return (Criteria) this;
        }

        public Criteria andSelect2NotEqualTo(String value) {
            addCriterion("select2 <>", value, "select2");
            return (Criteria) this;
        }

        public Criteria andSelect2GreaterThan(String value) {
            addCriterion("select2 >", value, "select2");
            return (Criteria) this;
        }

        public Criteria andSelect2GreaterThanOrEqualTo(String value) {
            addCriterion("select2 >=", value, "select2");
            return (Criteria) this;
        }

        public Criteria andSelect2LessThan(String value) {
            addCriterion("select2 <", value, "select2");
            return (Criteria) this;
        }

        public Criteria andSelect2LessThanOrEqualTo(String value) {
            addCriterion("select2 <=", value, "select2");
            return (Criteria) this;
        }

        public Criteria andSelect2Like(String value) {
            addCriterion("select2 like", value, "select2");
            return (Criteria) this;
        }

        public Criteria andSelect2NotLike(String value) {
            addCriterion("select2 not like", value, "select2");
            return (Criteria) this;
        }

        public Criteria andSelect2In(List<String> values) {
            addCriterion("select2 in", values, "select2");
            return (Criteria) this;
        }

        public Criteria andSelect2NotIn(List<String> values) {
            addCriterion("select2 not in", values, "select2");
            return (Criteria) this;
        }

        public Criteria andSelect2Between(String value1, String value2) {
            addCriterion("select2 between", value1, value2, "select2");
            return (Criteria) this;
        }

        public Criteria andSelect2NotBetween(String value1, String value2) {
            addCriterion("select2 not between", value1, value2, "select2");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
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