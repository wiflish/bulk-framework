package org.bulkframework.util.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

/**
 * 应用配置路径检查.
 * 
 * @author wiflish
 * @createTime 2012-8-6 下午5:22:37
 */
public class AppConfigPathBean implements InitializingBean {
    private static final Logger logger = LoggerFactory.getLogger(AppConfigPathBean.class);
    private String appConfigPathKey = "appConfigPath";

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        String appConfigPath = System.getProperty(appConfigPathKey);

        if (appConfigPath != null && !"".equals(appConfigPath)) {
            logger.info("已设置[{}]，系统将使用[{}]目录下的配置参数。", appConfigPathKey, appConfigPath);
        } else {
            logger.info("未设置[{}]，系统将使用项目默认配置目录下的配置参数.", appConfigPathKey);
        }
    }

    public String getAppConfigPathKey() {
        return appConfigPathKey;
    }

    public void setAppConfigPathKey(String appConfigPathKey) {
        this.appConfigPathKey = appConfigPathKey;
    }
}
