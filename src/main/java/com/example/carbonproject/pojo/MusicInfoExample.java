package com.example.carbonproject.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MusicInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MusicInfoExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andArtistIsNull() {
            addCriterion("artist is null");
            return (Criteria) this;
        }

        public Criteria andArtistIsNotNull() {
            addCriterion("artist is not null");
            return (Criteria) this;
        }

        public Criteria andArtistEqualTo(String value) {
            addCriterion("artist =", value, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistNotEqualTo(String value) {
            addCriterion("artist <>", value, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistGreaterThan(String value) {
            addCriterion("artist >", value, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistGreaterThanOrEqualTo(String value) {
            addCriterion("artist >=", value, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistLessThan(String value) {
            addCriterion("artist <", value, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistLessThanOrEqualTo(String value) {
            addCriterion("artist <=", value, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistLike(String value) {
            addCriterion("artist like", value, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistNotLike(String value) {
            addCriterion("artist not like", value, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistIn(List<String> values) {
            addCriterion("artist in", values, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistNotIn(List<String> values) {
            addCriterion("artist not in", values, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistBetween(String value1, String value2) {
            addCriterion("artist between", value1, value2, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistNotBetween(String value1, String value2) {
            addCriterion("artist not between", value1, value2, "artist");
            return (Criteria) this;
        }

        public Criteria andLanguageIsNull() {
            addCriterion("`language` is null");
            return (Criteria) this;
        }

        public Criteria andLanguageIsNotNull() {
            addCriterion("`language` is not null");
            return (Criteria) this;
        }

        public Criteria andLanguageEqualTo(String value) {
            addCriterion("`language` =", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotEqualTo(String value) {
            addCriterion("`language` <>", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageGreaterThan(String value) {
            addCriterion("`language` >", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageGreaterThanOrEqualTo(String value) {
            addCriterion("`language` >=", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLessThan(String value) {
            addCriterion("`language` <", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLessThanOrEqualTo(String value) {
            addCriterion("`language` <=", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLike(String value) {
            addCriterion("`language` like", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotLike(String value) {
            addCriterion("`language` not like", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageIn(List<String> values) {
            addCriterion("`language` in", values, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotIn(List<String> values) {
            addCriterion("`language` not in", values, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageBetween(String value1, String value2) {
            addCriterion("`language` between", value1, value2, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotBetween(String value1, String value2) {
            addCriterion("`language` not between", value1, value2, "language");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIsNull() {
            addCriterion("release_time is null");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIsNotNull() {
            addCriterion("release_time is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeEqualTo(Date value) {
            addCriterionForJDBCDate("release_time =", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("release_time <>", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("release_time >", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("release_time >=", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeLessThan(Date value) {
            addCriterionForJDBCDate("release_time <", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("release_time <=", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIn(List<Date> values) {
            addCriterionForJDBCDate("release_time in", values, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("release_time not in", values, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("release_time between", value1, value2, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("release_time not between", value1, value2, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andTransnameIsNull() {
            addCriterion("transname is null");
            return (Criteria) this;
        }

        public Criteria andTransnameIsNotNull() {
            addCriterion("transname is not null");
            return (Criteria) this;
        }

        public Criteria andTransnameEqualTo(String value) {
            addCriterion("transname =", value, "transname");
            return (Criteria) this;
        }

        public Criteria andTransnameNotEqualTo(String value) {
            addCriterion("transname <>", value, "transname");
            return (Criteria) this;
        }

        public Criteria andTransnameGreaterThan(String value) {
            addCriterion("transname >", value, "transname");
            return (Criteria) this;
        }

        public Criteria andTransnameGreaterThanOrEqualTo(String value) {
            addCriterion("transname >=", value, "transname");
            return (Criteria) this;
        }

        public Criteria andTransnameLessThan(String value) {
            addCriterion("transname <", value, "transname");
            return (Criteria) this;
        }

        public Criteria andTransnameLessThanOrEqualTo(String value) {
            addCriterion("transname <=", value, "transname");
            return (Criteria) this;
        }

        public Criteria andTransnameLike(String value) {
            addCriterion("transname like", value, "transname");
            return (Criteria) this;
        }

        public Criteria andTransnameNotLike(String value) {
            addCriterion("transname not like", value, "transname");
            return (Criteria) this;
        }

        public Criteria andTransnameIn(List<String> values) {
            addCriterion("transname in", values, "transname");
            return (Criteria) this;
        }

        public Criteria andTransnameNotIn(List<String> values) {
            addCriterion("transname not in", values, "transname");
            return (Criteria) this;
        }

        public Criteria andTransnameBetween(String value1, String value2) {
            addCriterion("transname between", value1, value2, "transname");
            return (Criteria) this;
        }

        public Criteria andTransnameNotBetween(String value1, String value2) {
            addCriterion("transname not between", value1, value2, "transname");
            return (Criteria) this;
        }

        public Criteria andAlbumIsNull() {
            addCriterion("album is null");
            return (Criteria) this;
        }

        public Criteria andAlbumIsNotNull() {
            addCriterion("album is not null");
            return (Criteria) this;
        }

        public Criteria andAlbumEqualTo(String value) {
            addCriterion("album =", value, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumNotEqualTo(String value) {
            addCriterion("album <>", value, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumGreaterThan(String value) {
            addCriterion("album >", value, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumGreaterThanOrEqualTo(String value) {
            addCriterion("album >=", value, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumLessThan(String value) {
            addCriterion("album <", value, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumLessThanOrEqualTo(String value) {
            addCriterion("album <=", value, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumLike(String value) {
            addCriterion("album like", value, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumNotLike(String value) {
            addCriterion("album not like", value, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumIn(List<String> values) {
            addCriterion("album in", values, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumNotIn(List<String> values) {
            addCriterion("album not in", values, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumBetween(String value1, String value2) {
            addCriterion("album between", value1, value2, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumNotBetween(String value1, String value2) {
            addCriterion("album not between", value1, value2, "album");
            return (Criteria) this;
        }

        public Criteria andGainIsNull() {
            addCriterion("gain is null");
            return (Criteria) this;
        }

        public Criteria andGainIsNotNull() {
            addCriterion("gain is not null");
            return (Criteria) this;
        }

        public Criteria andGainEqualTo(Double value) {
            addCriterion("gain =", value, "gain");
            return (Criteria) this;
        }

        public Criteria andGainNotEqualTo(Double value) {
            addCriterion("gain <>", value, "gain");
            return (Criteria) this;
        }

        public Criteria andGainGreaterThan(Double value) {
            addCriterion("gain >", value, "gain");
            return (Criteria) this;
        }

        public Criteria andGainGreaterThanOrEqualTo(Double value) {
            addCriterion("gain >=", value, "gain");
            return (Criteria) this;
        }

        public Criteria andGainLessThan(Double value) {
            addCriterion("gain <", value, "gain");
            return (Criteria) this;
        }

        public Criteria andGainLessThanOrEqualTo(Double value) {
            addCriterion("gain <=", value, "gain");
            return (Criteria) this;
        }

        public Criteria andGainIn(List<Double> values) {
            addCriterion("gain in", values, "gain");
            return (Criteria) this;
        }

        public Criteria andGainNotIn(List<Double> values) {
            addCriterion("gain not in", values, "gain");
            return (Criteria) this;
        }

        public Criteria andGainBetween(Double value1, Double value2) {
            addCriterion("gain between", value1, value2, "gain");
            return (Criteria) this;
        }

        public Criteria andGainNotBetween(Double value1, Double value2) {
            addCriterion("gain not between", value1, value2, "gain");
            return (Criteria) this;
        }

        public Criteria andPeakIsNull() {
            addCriterion("peak is null");
            return (Criteria) this;
        }

        public Criteria andPeakIsNotNull() {
            addCriterion("peak is not null");
            return (Criteria) this;
        }

        public Criteria andPeakEqualTo(Double value) {
            addCriterion("peak =", value, "peak");
            return (Criteria) this;
        }

        public Criteria andPeakNotEqualTo(Double value) {
            addCriterion("peak <>", value, "peak");
            return (Criteria) this;
        }

        public Criteria andPeakGreaterThan(Double value) {
            addCriterion("peak >", value, "peak");
            return (Criteria) this;
        }

        public Criteria andPeakGreaterThanOrEqualTo(Double value) {
            addCriterion("peak >=", value, "peak");
            return (Criteria) this;
        }

        public Criteria andPeakLessThan(Double value) {
            addCriterion("peak <", value, "peak");
            return (Criteria) this;
        }

        public Criteria andPeakLessThanOrEqualTo(Double value) {
            addCriterion("peak <=", value, "peak");
            return (Criteria) this;
        }

        public Criteria andPeakIn(List<Double> values) {
            addCriterion("peak in", values, "peak");
            return (Criteria) this;
        }

        public Criteria andPeakNotIn(List<Double> values) {
            addCriterion("peak not in", values, "peak");
            return (Criteria) this;
        }

        public Criteria andPeakBetween(Double value1, Double value2) {
            addCriterion("peak between", value1, value2, "peak");
            return (Criteria) this;
        }

        public Criteria andPeakNotBetween(Double value1, Double value2) {
            addCriterion("peak not between", value1, value2, "peak");
            return (Criteria) this;
        }

        public Criteria andLraIsNull() {
            addCriterion("lra is null");
            return (Criteria) this;
        }

        public Criteria andLraIsNotNull() {
            addCriterion("lra is not null");
            return (Criteria) this;
        }

        public Criteria andLraEqualTo(Double value) {
            addCriterion("lra =", value, "lra");
            return (Criteria) this;
        }

        public Criteria andLraNotEqualTo(Double value) {
            addCriterion("lra <>", value, "lra");
            return (Criteria) this;
        }

        public Criteria andLraGreaterThan(Double value) {
            addCriterion("lra >", value, "lra");
            return (Criteria) this;
        }

        public Criteria andLraGreaterThanOrEqualTo(Double value) {
            addCriterion("lra >=", value, "lra");
            return (Criteria) this;
        }

        public Criteria andLraLessThan(Double value) {
            addCriterion("lra <", value, "lra");
            return (Criteria) this;
        }

        public Criteria andLraLessThanOrEqualTo(Double value) {
            addCriterion("lra <=", value, "lra");
            return (Criteria) this;
        }

        public Criteria andLraIn(List<Double> values) {
            addCriterion("lra in", values, "lra");
            return (Criteria) this;
        }

        public Criteria andLraNotIn(List<Double> values) {
            addCriterion("lra not in", values, "lra");
            return (Criteria) this;
        }

        public Criteria andLraBetween(Double value1, Double value2) {
            addCriterion("lra between", value1, value2, "lra");
            return (Criteria) this;
        }

        public Criteria andLraNotBetween(Double value1, Double value2) {
            addCriterion("lra not between", value1, value2, "lra");
            return (Criteria) this;
        }

        public Criteria andBpmIsNull() {
            addCriterion("bpm is null");
            return (Criteria) this;
        }

        public Criteria andBpmIsNotNull() {
            addCriterion("bpm is not null");
            return (Criteria) this;
        }

        public Criteria andBpmEqualTo(Double value) {
            addCriterion("bpm =", value, "bpm");
            return (Criteria) this;
        }

        public Criteria andBpmNotEqualTo(Double value) {
            addCriterion("bpm <>", value, "bpm");
            return (Criteria) this;
        }

        public Criteria andBpmGreaterThan(Double value) {
            addCriterion("bpm >", value, "bpm");
            return (Criteria) this;
        }

        public Criteria andBpmGreaterThanOrEqualTo(Double value) {
            addCriterion("bpm >=", value, "bpm");
            return (Criteria) this;
        }

        public Criteria andBpmLessThan(Double value) {
            addCriterion("bpm <", value, "bpm");
            return (Criteria) this;
        }

        public Criteria andBpmLessThanOrEqualTo(Double value) {
            addCriterion("bpm <=", value, "bpm");
            return (Criteria) this;
        }

        public Criteria andBpmIn(List<Double> values) {
            addCriterion("bpm in", values, "bpm");
            return (Criteria) this;
        }

        public Criteria andBpmNotIn(List<Double> values) {
            addCriterion("bpm not in", values, "bpm");
            return (Criteria) this;
        }

        public Criteria andBpmBetween(Double value1, Double value2) {
            addCriterion("bpm between", value1, value2, "bpm");
            return (Criteria) this;
        }

        public Criteria andBpmNotBetween(Double value1, Double value2) {
            addCriterion("bpm not between", value1, value2, "bpm");
            return (Criteria) this;
        }

        public Criteria andIntervalIsNull() {
            addCriterion("`interval` is null");
            return (Criteria) this;
        }

        public Criteria andIntervalIsNotNull() {
            addCriterion("`interval` is not null");
            return (Criteria) this;
        }

        public Criteria andIntervalEqualTo(Double value) {
            addCriterion("`interval` =", value, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalNotEqualTo(Double value) {
            addCriterion("`interval` <>", value, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalGreaterThan(Double value) {
            addCriterion("`interval` >", value, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalGreaterThanOrEqualTo(Double value) {
            addCriterion("`interval` >=", value, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalLessThan(Double value) {
            addCriterion("`interval` <", value, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalLessThanOrEqualTo(Double value) {
            addCriterion("`interval` <=", value, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalIn(List<Double> values) {
            addCriterion("`interval` in", values, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalNotIn(List<Double> values) {
            addCriterion("`interval` not in", values, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalBetween(Double value1, Double value2) {
            addCriterion("`interval` between", value1, value2, "interval");
            return (Criteria) this;
        }

        public Criteria andIntervalNotBetween(Double value1, Double value2) {
            addCriterion("`interval` not between", value1, value2, "interval");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNull() {
            addCriterion("company is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("company is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("company =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("company <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("company >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("company >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("company <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("company <=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLike(String value) {
            addCriterion("company like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion("company not like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyIn(List<String> values) {
            addCriterion("company in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("company not in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("company between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("company not between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andGenreIsNull() {
            addCriterion("genre is null");
            return (Criteria) this;
        }

        public Criteria andGenreIsNotNull() {
            addCriterion("genre is not null");
            return (Criteria) this;
        }

        public Criteria andGenreEqualTo(String value) {
            addCriterion("genre =", value, "genre");
            return (Criteria) this;
        }

        public Criteria andGenreNotEqualTo(String value) {
            addCriterion("genre <>", value, "genre");
            return (Criteria) this;
        }

        public Criteria andGenreGreaterThan(String value) {
            addCriterion("genre >", value, "genre");
            return (Criteria) this;
        }

        public Criteria andGenreGreaterThanOrEqualTo(String value) {
            addCriterion("genre >=", value, "genre");
            return (Criteria) this;
        }

        public Criteria andGenreLessThan(String value) {
            addCriterion("genre <", value, "genre");
            return (Criteria) this;
        }

        public Criteria andGenreLessThanOrEqualTo(String value) {
            addCriterion("genre <=", value, "genre");
            return (Criteria) this;
        }

        public Criteria andGenreLike(String value) {
            addCriterion("genre like", value, "genre");
            return (Criteria) this;
        }

        public Criteria andGenreNotLike(String value) {
            addCriterion("genre not like", value, "genre");
            return (Criteria) this;
        }

        public Criteria andGenreIn(List<String> values) {
            addCriterion("genre in", values, "genre");
            return (Criteria) this;
        }

        public Criteria andGenreNotIn(List<String> values) {
            addCriterion("genre not in", values, "genre");
            return (Criteria) this;
        }

        public Criteria andGenreBetween(String value1, String value2) {
            addCriterion("genre between", value1, value2, "genre");
            return (Criteria) this;
        }

        public Criteria andGenreNotBetween(String value1, String value2) {
            addCriterion("genre not between", value1, value2, "genre");
            return (Criteria) this;
        }

        public Criteria andMidIsNull() {
            addCriterion("mid is null");
            return (Criteria) this;
        }

        public Criteria andMidIsNotNull() {
            addCriterion("mid is not null");
            return (Criteria) this;
        }

        public Criteria andMidEqualTo(String value) {
            addCriterion("mid =", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotEqualTo(String value) {
            addCriterion("mid <>", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThan(String value) {
            addCriterion("mid >", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThanOrEqualTo(String value) {
            addCriterion("mid >=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThan(String value) {
            addCriterion("mid <", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThanOrEqualTo(String value) {
            addCriterion("mid <=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLike(String value) {
            addCriterion("mid like", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotLike(String value) {
            addCriterion("mid not like", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidIn(List<String> values) {
            addCriterion("mid in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotIn(List<String> values) {
            addCriterion("mid not in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidBetween(String value1, String value2) {
            addCriterion("mid between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotBetween(String value1, String value2) {
            addCriterion("mid not between", value1, value2, "mid");
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