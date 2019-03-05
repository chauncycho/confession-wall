package chauncy.test;

import chauncy.bean.CWallManager;
import chauncy.utility.SqlSessionFactoryUtil;
import com.mysql.cj.xdevapi.SessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Test;


public class CWMTest {
    Logger logger = Logger.getLogger(CWallManager.class);

    @Test
    public void t1(){
        SqlSessionFactoryUtil.initSqlSessionFactory();
        SqlSession session = SqlSessionFactoryUtil.openSession();
        CWallManager temp = new CWallManager();
        temp.setAccount("332501080");
        temp.setPassword("123456");
        CWallManager res = session.selectOne("findCWallM",temp);
        logger.debug(res);
    }
}
