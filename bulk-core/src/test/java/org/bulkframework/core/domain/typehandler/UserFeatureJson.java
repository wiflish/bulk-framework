package org.bulkframework.core.domain.typehandler;

import org.bulkframework.common.model.BaseFeatureJson;

/**
 * 
 * @author wiflish
 * @createTime 2012-7-26 下午6:01:11
 */
public class UserFeatureJson extends BaseFeatureJson {
    private static final long serialVersionUID = 2120675112287254765L;

    private String name;

    private int age;

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
}
