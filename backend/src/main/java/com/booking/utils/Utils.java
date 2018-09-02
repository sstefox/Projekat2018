package com.booking.utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

	public static String generateOneTimePassword(String username) {
	

		    List<Character> list = username.chars().mapToObj(c -> new Character((char) c))
		                                         .collect(Collectors.toList());
		    Collections.shuffle(list);
		    StringBuilder sb = new StringBuilder();
		    list.forEach(c -> sb.append(c));

		    return sb.toString();

	}
}
