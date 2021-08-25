package com.visualnuts;

import java.util.Comparator;
import java.util.Map;

import lombok.AllArgsConstructor;

/**
 * @author carlosrodrigues
 */
@AllArgsConstructor
public class MapValueComparator implements Comparator<String> {

	private final Map<String, Integer> map;

	@Override
	public int compare(final String key1, final String key2) {

		if (map.get(key1) >= map.get(key2)) {

			return -1;
		}

		return 1;

	}
}
