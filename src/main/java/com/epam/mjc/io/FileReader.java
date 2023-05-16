package com.epam.mjc.io;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class FileReader {

	public Profile getDataFromFile(File file) {

		try (InputStream inputStream = new FileInputStream(file)) {

			StringBuilder sb = new StringBuilder();
			int i;
			List<String> ls = new ArrayList<>();


			while ((i = inputStream.read()) != -1) {
				sb.append((char) i);
			}
			String res = sb.toString();
			res = res.trim();
			String[] arr = res.split("\\n");
			for (String str : arr) {
				ls.add(str.substring(str.indexOf(":") + 1).trim());
			}

			return new Profile(ls.get(0), Integer.parseInt(ls.get(1)), ls.get(2), Long.parseLong(ls.get(3)));


		} catch (
				IOException e) {
			System.err.println(e.getMessage());
		}
		return new Profile();

	}
}
