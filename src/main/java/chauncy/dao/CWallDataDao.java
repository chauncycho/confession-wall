package chauncy.dao;

import chauncy.bean.CWallData;
import chauncy.utility.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.List;

public class CWallDataDao {
    private static Logger logger = org.apache.log4j.Logger.getLogger(CWallDataDao.class);

    public static void insert(CWallData cWallData){
        SqlSession session = SqlSessionFactoryUtil.openSession();
        int infectedLine = session.insert("insertCWallData",cWallData);
        if (infectedLine > 0){
            logger.debug("数据插入成功");
            session.commit();
        }else{
            logger.debug("数据插入失败");
        }

        SqlSessionFactoryUtil.closeSession(session);
    }

    public static void insertList(List<CWallData> list){
        for (CWallData data : list){
            insert(data);
        }
    }
}
