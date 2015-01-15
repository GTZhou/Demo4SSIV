package cn.com.tarena.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

    public ContextListener() {
    	
    }

    public void contextInitialized(ServletContextEvent event)  { 
    	try {
			Class.forName("cn.com.tarena.util.ServiceFactory");
			
			Class.forName("cn.com.tarena.util.DaoFactory");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
    }

    public void contextDestroyed(ServletContextEvent arg0)  { 

    }
	
}
