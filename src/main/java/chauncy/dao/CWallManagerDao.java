package chauncy.dao;

import chauncy.bean.CWallManager;
import chauncy.utility.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

public class CWallManagerDao {
    public static CWallManager findManagerByAccount(String account){
        CWallManager tempManager = new CWallManager();
        tempManager.setAccount(account);
        SqlSession session = SqlSessionFactoryUtil.openSession();
        CWallManager manager = session.selectOne("findManagerByAccount",tempManager);

        SqlSessionFactoryUtil.closeSession(session);

        if (manager == null){
            return null;
        }else{
            return manager;
        }
    }
}
