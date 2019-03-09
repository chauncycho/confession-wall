package chauncy.service;

import chauncy.bean.CWallManager;
import chauncy.dao.CWallManagerDao;

public class ManagerLoginService {
    private String account;
    private String password;

    public ManagerLoginService(String account, String password){
        this.account = account;
        this.password = password;
    }

    public boolean loginSuccess(){
        CWallManager manager = CWallManagerDao.findManagerByAccount(account);
        if (manager == null){
            return false;
        }else{
            if (manager.getPassword().equals(password)){
                return true;
            }else{
                return false;
            }
        }
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
