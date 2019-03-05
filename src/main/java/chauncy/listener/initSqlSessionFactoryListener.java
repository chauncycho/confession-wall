package chauncy.listener;

import chauncy.utility.SqlSessionFactoryUtil;
import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class initSqlSessionFactoryListener implements ServletContextListener{
    private Logger logger = Logger.getLogger(initSqlSessionFactoryListener.class);
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.debug("Session Factory Initial");
        SqlSessionFactoryUtil.initSqlSessionFactory();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.debug("Session Factory Destroy");
        SqlSessionFactoryUtil.close();
    }
}
