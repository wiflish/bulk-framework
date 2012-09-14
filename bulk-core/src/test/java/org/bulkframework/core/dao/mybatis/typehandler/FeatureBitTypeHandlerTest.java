/**
 * Copyright 2011-2012 [wiflish.xie@gmail.com].
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.bulkframework.core.dao.mybatis.typehandler;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.bulkframework.common.model.FeatureBit;
import org.bulkframework.core.dao.AbstractBulkCoreSpringContextTest;
import org.bulkframework.core.dao.BulkDao;
import org.bulkframework.core.domain.typehandler.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * FeatureBitTypeHandler测试类.
 * 
 * @author wiflish
 * @since 2012-9-14
 */
public class FeatureBitTypeHandlerTest extends AbstractBulkCoreSpringContextTest {
    @Autowired
    private BulkDao<User> userDao;

    @Test
    public void test() {
        User user = new User();

        user.setUsername("test11");
        user.setPassword("111111");
        user.setCreateTime(Calendar.getInstance());
        user.setUpdateTime(Calendar.getInstance());

        FeatureBit featureBit = new FeatureBit(123L);

        user.setFeatureBit(featureBit);
        featureBit.setBits(12).setBits(1000);

        user = userDao.insertAndReturnId("typehandler.UserMapper.insertSelective", user);

        Integer id = user.getId();
        assertTrue(id != null && id > 0);

        user = userDao.queryOne("typehandler.UserMapper.selectByPrimaryKey", id);

        assertTrue(1023 == user.getFeatureBit().getValue());
        assertTrue(user.getFeatureBit().getBits(123) == 1);
        assertTrue(user.getFeatureBit().getBits(12) == 1);
        assertTrue(user.getFeatureBit().getBits(1000) == 1);
    }
}
