package chauncy.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().setAttribute("loginState","0");

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
