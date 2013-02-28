package commons;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateExtension
{
	public static Date toDate(String input)
	{
		if(input == null)
			return null;
		
		Locale[] tab = DateFormat.getAvailableLocales();
		int[] DateFormats = new int[] {DateFormat.DEFAULT, DateFormat.LONG, DateFormat.SHORT, DateFormat.FULL};
		Locale l = Locale.getDefault();
		for (int i : DateFormats) {
			try
			{
				return DateFormat.getDateInstance(i, l).parse(input);
			}
			catch (Exception e)
			{

			}
		}
		
		for (Locale locale : tab) {
			for (int i : DateFormats) {
				try
				{
					return DateFormat.getDateInstance(i, locale).parse(input);
				}
				catch (Exception e)
				{

				}
			}
		}
		return null;
	}
}
