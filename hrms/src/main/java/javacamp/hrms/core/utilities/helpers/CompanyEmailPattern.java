package javacamp.hrms.core.utilities.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompanyEmailPattern {
	public static boolean isValidPattern(String webSite, String email) {
		final String regex = "^(.+)@"+webSite;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
}
