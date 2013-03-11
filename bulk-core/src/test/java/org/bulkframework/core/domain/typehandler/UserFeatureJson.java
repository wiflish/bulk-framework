package org.bulkframework.core.domain.typehandler;

import java.io.Serializable;
import java.util.Calendar;

/**
 * 用户实体的featureJson扩展字段对象.
 * 
 * @author wiflish
 * @createTime 2012-7-26 下午6:01:11
 */
public class UserFeatureJson implements Serializable {
    private static final long serialVersionUID = 2120675112287254765L;

    private String name;

    private int age;

    private Calendar birthday;

    private boolean success;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
