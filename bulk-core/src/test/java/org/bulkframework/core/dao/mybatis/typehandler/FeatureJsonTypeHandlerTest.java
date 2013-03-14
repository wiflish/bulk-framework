package org.bulkframework.core.dao.mybatis.typehandler;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.bulkframework.common.model.FeatureJson;
import org.bulkframework.core.dao.AbstractBulkCoreSpringContextTest;
import org.bulkframework.core.dao.BulkDao;
import org.bulkframework.core.domain.typehandler.User;
import org.bulkframework.core.domain.typehandler.UserFeatureJson;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class FeatureJsonTypeHandlerTest extends AbstractBulkCoreSpringContextTest {
    @Autowired
    private BulkDao<User> userDao;

    @Test
    public void testFeatureJsonTypeHandler() {
        User user = new User();

        user.setUsername("test11");
        user.setPassword("111111");
        user.setCreateTime(Calendar.getInstance());
        user.setUpdateTime(Calendar.getInstance());

        UserFeatureJson json = new UserFeatureJson();
        json.setAge(12);
        json.setName("xiezr");
        json.setBirthday(Calendar.getInstance());

        user.setFeatureJson(new FeatureJson(json));

        user = userDao.insertAndReturnId("typehandler.UserMapper.insertSelective", user);

        Long id = user.getId();
        assertTrue(id != null && id > 0);

        user = userDao.queryOne("typehandler.UserMapper.selectByPrimaryKey", id);
        FeatureJson s = user.getFeatureJson();

        assertTrue(user != null);
        assertTrue(s != null);

        UserFeatureJson dbUserFeature = s.toJavaObject(UserFeatureJson.class);
        assertTrue(dbUserFeature.getAge() == 12);
        assertTrue("xiezr".equals(dbUserFeature.getName()));

        UserInner fieldNotFullMatch = s.toJavaObject(UserInner.class);

        assertTrue(fieldNotFullMatch != null);
        assertTrue("xiezr".equals(fieldNotFullMatch.getName()));
        assertTrue(fieldNotFullMatch.getAddress() == null);
    }

    public class UserInner {
        private String name;
        private String address;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
