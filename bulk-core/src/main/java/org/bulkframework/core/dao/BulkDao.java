package org.bulkframework.core.dao;

import java.util.List;
import java.util.Map;

import org.bulkframework.common.pagination.Pager;

/**
 * dao基本接口,封装基本的dao操作.
 * 
 * @author wiflish
 * @createTime 2012-6-3 下午10:33:43
 */
public interface BulkDao<T> {
    /**
     * 插入记录并返回记录id.
     * 
     * @param sql 实际的sql语句或者能映射到实际的sql语句.
     * @param model 待写入的对象.
     * @return 返回记录id.
     */
    public T insertAndReturnId(String sql, T model);

    /**
     * 插入记录并返回已插入成功的记录条数.
     * 
     * @param sql 实际的sql语句或者能映射到实际的sql语句.
     * @param model 待写入的对象.
     * @return 返回写入成功的记录条数.
     */
    public int insertAndReturnAffectedCount(String sql, T model);

    /**
     * 更新记录.
     * 
     * @param sql 实际的sql语句或者能映射到实际的sql语句.
     * @param model 待更新的对象.
     * @return 返回更新成功的记录条数.
     */
    public int update(String sql, T model);

    /**
     * 根据Map对象更新记录。
     * 
     * @param sql 实际的sql语句或者能映射到实际的sql语句.
     * @param paramMap 待更新的Map对象.
     * @return 返回更新成功的记录条数.
     */
    public int updateByMap(String sql, Map<String, Object> paramMap);

    /**
     * 逻辑删除记录,设置domain对象的status属性为-1.如：
     * <p>
     * update table_a set status = -1,update_time=now() where id=#{id}
     * </p>
     * 
     * @param sql 实际的sql语句或者能映射到实际的sql语句.
     * @param id 主键id.
     * @return 返回更新成功的记录条数.
     */
    public int remove(String sql, long id);

    /**
     * 逻辑删除记录,设置domain对象的status属性为-1.如：
     * <p>
     * update table_a set status = -1,update_time=now() where id=#{id}
     * </p>
     * 
     * @param sql 实际的sql语句或者能映射到实际的sql语句.
     * @param id 主键id.
     * @return 返回更新成功的记录条数.
     */
    public int remove(String sql, String id);

    /**
     * 根据条件逻辑删除记录,设置domain对象的status属性为-1.
     * <p>
     * update table_a set status = -1,update_time=now() where queryMap.key=#{queryMap.value} and ...
     * </p>
     * 
     * @param sql 实际的sql语句或者能映射到实际的sql语句.
     * @param queryMap 查询条件
     * @return 返回更新成功的记录条数.
     */
    public int remove(String sql, Map<String, Object> queryMap);

    /**
     * 查询总记录数.
     * <p>
     * select count(*) from table_a where queryMap.key=#{queryMap.value} and ...
     * </p>
     * 
     * @param sql 实际的sql语句或者能映射到实际的sql语句.
     * @param queryMap 查询参数.
     * @return 返回总记录数
     */
    public int queryCount(String sql, Map<String, Object> queryMap);

    /**
     * 根据条件查询列表（分页），不查询总记录数.
     * 
     * @param sql 实际的sql语句或者能映射到实际的sql语句.
     * @param queryMap
     * @param pager
     * @return
     */
    public Pager<T> queryPagedList(String sql, Map<String, Object> queryMap, Pager<T> pager);

    /**
     * 根据条件查询列表（分页），返回分页列表数据和总记录数.
     * 
     * @param countSql 总记录数查询sql.
     * @param pageSql 分页查询sql.
     * @param queryMap
     * @param pager
     * @return
     */
    public Pager<T> queryPagedList(String countSql, String pageSql, Map<String, Object> queryMap, Pager<T> pager);

    /**
     * 查询所有记录.用于字典类/枚举类数据.
     * 
     * @param sql 实际的sql语句或者能映射到实际的sql语句.
     * @return 返回所有记录.
     */
    public List<T> queryList(String sql);

    /**
     * 根据条件查询所有记录.
     * 
     * @param sql 实际的sql语句或者能映射到实际的sql语句.
     * @param queryMap 查询参数.
     * @return 返回符合条件的所有记录.
     */
    public List<T> queryList(String sql, Map<String, Object> queryMap);

    /**
     * 根据id集合查询记录（使用in语句），id集合不要太大。
     * 
     * @param sql 实际的sql语句或者能映射到实际的sql语句.
     * @param ids ids id集合
     * @return 返回所有记录
     */
    public List<T> queryListByIds(String sql, long[] ids);

    /**
     * 根据id集合查询记录（使用in语句），id集合不要太大。
     * 
     * @param sql 实际的sql语句或者能映射到实际的sql语句.
     * @param ids ids id集合
     * @return 返回所有记录
     */
    public List<T> queryListByIds(String sql, String[] ids);

    /**
     * 根据对象的某一个属性集合查询记录（使用in语句），集合不要太大。
     * 
     * @param sql 实际的sql语句或者能映射到实际的sql语句.
     * @param objs objs 对象的某一个属性集合
     * @return 返回所有记录
     */
    public List<T> queryListByObjects(String sql, Object[] objs);

    /**
     * 根据条件查询一条记录.如果根据条件返回多条记录，默认返回第一条记录,不抛异常。<br>
     * 等同于调用{@link BulkDao#queryOne(String, Map, boolean)},multiException=false.
     * 
     * @param sql 实际的sql语句或者能映射到实际的sql语句.
     * @param queryMap 查询参数.
     * @return 返回符合条件的记录
     */
    public T queryOne(String sql, Map<String, Object> queryMap);

    /**
     * 根据id查询一条记录.
     * 
     * @param sql 实际的sql语句或者能映射到实际的sql语句.
     * @param id 记录主键id.
     * @return 返回符合条件的记录
     */
    public T queryOne(String sql, long id);

    /**
     * 根据id查询一条记录.
     * 
     * @param sql 实际的sql语句或者能映射到实际的sql语句.
     * @param id 记录主键id.
     * @return 返回符合条件的记录
     */
    public T queryOne(String sql, String id);

    /**
     * 根据对象查询一条记录.
     * 
     * @param sql 实际的sql语句或者能映射到实际的sql语句.
     * @param queryObject 查询条件，用于符合主键或者唯一键的查询.
     * @return 返回符合条件的记录
     */
    public T queryOne(String sql, T queryObject);
}
