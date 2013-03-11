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
package org.bulkframework.core.dao;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * 
 * @author wiflish
 * @since 2012-9-14
 */
@ContextConfiguration("classpath:/bulkCoreConfig/spring-bulkcore.xml")
public abstract class AbstractBulkCoreSpringContextTest extends AbstractJUnit4SpringContextTests {
}
