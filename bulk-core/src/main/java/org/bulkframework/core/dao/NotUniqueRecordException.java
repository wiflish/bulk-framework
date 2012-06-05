package org.bulkframework.core.dao;

/**
 * 不唯一记录异常,应该只返回一条记录但实际查询返回多条记录的异常。
 * 
 * @author wiflish
 * @createTime 2012-6-3 下午11:11:30
 */
public class NotUniqueRecordException extends RuntimeException {
    private static final long serialVersionUID = 4584638505572890225L;

    public NotUniqueRecordException(String msg) {
        super(msg);
    }

    public NotUniqueRecordException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
