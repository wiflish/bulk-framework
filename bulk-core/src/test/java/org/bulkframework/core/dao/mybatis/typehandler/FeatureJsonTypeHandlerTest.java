package org.bulkframework.core.dao.mybatis.typehandler;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.bulkframework.core.dao.BulkDao;
import org.bulkframework.core.domain.typehandler.User;
import org.bulkframework.core.domain.typehandler.UserFeatureJson;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration("classpath:/bulkCoreConfig/spring-bulkcore.xml")
public class FeatureJsonTypeHandlerTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    private BulkDao<User> userDao;

    @Test
    public void test() {
        User user = new User();

        user.setUsername("test11");
        user.setPassword("111111");
        user.setCreateTime(Calendar.getInstance());
        user.setUpdateTime(Calendar.getInstance());

        UserFeatureJson json = new UserFeatureJson();
        json.setAge(12);
        json.setName("xiezr");
        json.setBirthday(Calendar.getInstance());

        user.setFeatureJson(json);

        user = userDao.insertAndReturnId("typehandler.UserMapper.insertSelective", user);

        Integer id = user.getId();
        assertTrue(id != null && id > 0);

        user = userDao.queryOne("typehandler.UserMapper.selectByPrimaryKey", id);
        UserFeatureJson s = user.getFeatureJson();

        assertTrue(user != null);
        assertTrue(s != null);

        assertTrue(s.getAge() == 12);
    }
}
