package commons;

import javax.servlet.http.HttpSession;

import com.genart.beans.Artist;
import com.genart.beans.Customer;

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
	
	public static Customer getConnectedCustomer(HttpSession session)
	{
		return (Customer)session.getAttribute("customer");
	}
	
	public static Artist getConnectedArtist(HttpSession session)
	{
		return (Artist)session.getAttribute("artist");
	}
}
