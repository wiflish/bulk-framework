package org.bulkframework.core.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.bulkframework.common.pagination.Pager;

/**
 * Mybatis Dao
 * 
 * @author wiflish
 * @createTime 2012-6-9 下午9:43:49
 */
public class BulkMybatisDao<T> implements BulkDao<T> {
    private SqlSession sqlSessionTemplate;

    // 分页参数: 开始序号.
    private static final String PAGE_START_INDEX_KEY = "startIndex";

    // 分页参数: 结束序号.
    private static final String PAGE_END_INDEX_KEY = "endIndex";

    // 分页参数：页大小.
    private static final String PAGE_SIZE_KEY = "pageSize";

    public void setSqlSessionTemplate(SqlSession sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public T insertAndReturnId(String sql, T model) {
        sqlSessionTemplate.insert(sql, model);
        return model;
    }

    @Override
    public int insertAndReturnAffectedCount(String sql, T model) {
        return sqlSessionTemplate.insert(sql, model);
    }

    @Override
    public int update(String sql, T model) {
        return sqlSessionTemplate.update(sql, model);
    }

    @Override
    public int updateByMap(String sql, Map<String, Object> paramMap) {
        return sqlSessionTemplate.update(sql, paramMap);
    }

    @Override
    public int remove(String sql, long id) {
        return sqlSessionTemplate.update(sql, id);
    }

    @Override
    public int remove(String sql, String id) {
        return sqlSessionTemplate.update(sql, id);
    }

    @Override
    public int remove(String sql, Map<String, Object> queryMap) {
        return sqlSessionTemplate.update(sql, queryMap);
    }

    @Override
    public int queryCount(String sql, Map<String, Object> queryMap) {
        return sqlSessionTemplate.selectOne(sql, queryMap);
    }

    @Override
    public Pager<T> queryPagedList(String sql, Map<String, Object> queryMap, Pager<T> pager) {
        if (queryMap == null) {
            queryMap = new HashMap<String, Object>();
        }

        // 设置分页参数.
        queryMap.put(PAGE_START_INDEX_KEY, pager.getStartIndex());
        queryMap.put(PAGE_END_INDEX_KEY, pager.getEndIndex());
        queryMap.put(PAGE_SIZE_KEY, pager.getPageSize());

        List<T> pageList = sqlSessionTemplate.selectList(sql, queryMap);

        if (pageList == null) {
            pageList = new ArrayList<T>();
        }

        pager.setPageData(pageList);
        return pager;
    }

    @Override
    public Pager<T> queryPagedList(String countSql, String pageSql, Map<String, Object> queryMap, Pager<T> pager) {
        if (queryMap == null) {
            queryMap = new HashMap<String, Object>();
        }

        // 总记录数.
        int count = sqlSessionTemplate.selectOne(countSql, queryMap);
        pager.setTotalCount(count);

        // 设置分页参数.
        queryMap.put(PAGE_START_INDEX_KEY, pager.getStartIndex());
        queryMap.put(PAGE_END_INDEX_KEY, pager.getEndIndex());
        queryMap.put(PAGE_SIZE_KEY, pager.getPageSize());

        List<T> pageList = sqlSessionTemplate.selectList(pageSql, queryMap);

        if (pageList == null) {
            pageList = new ArrayList<T>();
        }

        pager.setPageData(pageList);
        return pager;
    }

    @Override
    public List<T> queryList(String sql) {
        return sqlSessionTemplate.selectList(sql);
    }

    @Override
    public List<T> queryList(String sql, Map<String, Object> queryMap) {
        return sqlSessionTemplate.selectList(sql, queryMap);
    }

    @Override
    public List<T> queryListByIds(String sql, long[] ids) {
        return sqlSessionTemplate.selectList(sql, ids);
    }

    @Override
    public List<T> queryListByIds(String sql, String[] ids) {
        return sqlSessionTemplate.selectList(sql, ids);
    }

    @Override
    public List<T> queryListByObjects(String sql, Object[] objs) {
        return sqlSessionTemplate.selectList(sql, objs);
    }

    @Override
    public T queryOne(String sql, Map<String, Object> queryMap) {
        return sqlSessionTemplate.selectOne(sql, queryMap);
    }

    @Override
    public T queryOne(String sql, long id) {
        return sqlSessionTemplate.selectOne(sql, id);
    }

    @Override
    public T queryOne(String sql, String id) {
        return sqlSessionTemplate.selectOne(sql, id);
    }

    @Override
    public T queryOne(String sql, T queryObject) {
        return sqlSessionTemplate.selectOne(sql, queryObject);
    }
}
