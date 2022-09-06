package com.mydemo.Util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamApp {

	public static String[] dados = { "caju", "Manga", "Abacate", "Laranja", "Pera" };

	public static List<String> lista = Arrays.asList("caju", "Manga", "Abacate", "Laranja", "Pera");

	public static void main(String[] args) {

		Map<String, String> selected = new HashMap<>();

		for (int i = 0; i < dados.length; i++) {
			// int position = dados(i).
			lista.stream().filter(x -> "Laranja".equals(x) == false || "Pera".equals("x")).forEach(System.out::println);
		}

		List<String> collect = lista.stream().filter(x -> "Laranja".equals(x) == false || "Pera".equals("x"))
				.collect(Collectors.toList());
	}

}
