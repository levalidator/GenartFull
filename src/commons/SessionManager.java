package commons;

import javax.servlet.http.HttpSession;

public class SessionManager {

	public static boolean isConnected(HttpSession session)
	{
		boolean connected = false;
		if(null != session.getAttribute("connected"))
		{
			connected = Boolean.parseBoolean(session.getAttribute("connected").toString());
		}
		return connected;
	}
}
