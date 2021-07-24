package listeners;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import utils.DBUtils;

/**
 * Application Lifecycle Listener implementation class DBConnectionMgr
 *
 */
@WebListener
public class DBConnectionMgr implements ServletContextListener {

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		try {
			DBUtils.closeConnection();
		} catch (Exception e) {
			System.out.println("err in ctx inited " + e);
		}
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		try {
			DBUtils.getDBConnection();
		} catch (Exception e) {
			System.out.println("err in ctx inited " + e);
		}

	}

}
