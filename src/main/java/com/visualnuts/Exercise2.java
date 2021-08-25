package com.visualnuts;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author carlosrodrigues
 */
public final class Exercise2 {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private static final String GERMANY_LANGUAGE = "de";
	private static final int INCREASE_ONE = 1;

	public void execute() {

		try {

			final OfficialLanguageList officialLanguages = convertJsonStringToObject();

			final List<OfficialLanguage> officialLanguageList = officialLanguages.getOfficialLanguages();

			final Set<String> numberOfAllCountries = new HashSet<>();
			final Map<String, Integer> countryWithMostGermanyAsOfficialLanguage = new HashMap<>();
			final Set<String> countAllOfficialLanguagesSpoken = new HashSet<>();
			final Map<String, Integer> countryWithHighestOfficialLanguages = new HashMap<>();
			final Map<String, Integer> countryWithMostCommonOfficialLanguage = new HashMap<>();

			for (final OfficialLanguage language : officialLanguageList) {

				if (language != null && CollectionUtils.isNotEmpty(language.getLanguages())) {

					addCountryToSet(numberOfAllCountries, language);
					addKeyToMap(countryWithHighestOfficialLanguages, language);
					addAllLanguagesToSet(countAllOfficialLanguagesSpoken, language);

					loopCountryLanguages(countryWithMostCommonOfficialLanguage, countryWithMostGermanyAsOfficialLanguage, language);
				}
			}

			final TreeMap<String, Integer> countryWithHighestOfficialLanguagesSorted = sortHashMap(countryWithHighestOfficialLanguages);
			final TreeMap<String, Integer> countryWithMostCommonOfficialLanguageSorted = sortHashMap(countryWithMostCommonOfficialLanguage);
			final TreeMap<String, Integer> countryWithMostGermanyAsOfficialLanguageSorted = sortHashMap(countryWithMostGermanyAsOfficialLanguage);

			System.out.println("returns the number of countries in the world: " + numberOfAllCountries.size());

			if (MapUtils.isNotEmpty(countryWithMostGermanyAsOfficialLanguageSorted)) {

				System.out.println("finds the country with the most official languages, where they officially speak German (de): " +
						countryWithMostGermanyAsOfficialLanguageSorted.firstEntry().getKey());
			}

			System.out.println("that counts all the official languages spoken in the listed countries: " + countAllOfficialLanguagesSpoken.size());

			if (MapUtils.isNotEmpty(countryWithHighestOfficialLanguagesSorted)) {

				System.out.println("to find the country with the highest number of official languages: " +
						countryWithHighestOfficialLanguagesSorted.firstEntry().getKey());
			}

			if (MapUtils.isNotEmpty(countryWithMostCommonOfficialLanguageSorted)) {

				System.out.println("to find the most common official language(s), of all countries: " +
						countryWithMostCommonOfficialLanguageSorted.firstEntry().getKey());
			}

		} catch (final JsonProcessingException e) {

			System.out.printf("An error was occurred while processing the JSON %s due to %s%n", Constants.JSON_COUNTRIES, e);
		}
	}

	private void addKeyToMap(final Map<String, Integer> map, final OfficialLanguage language) {

		map.put(language.getCountry(), language.getLanguages().size());
	}

	private void addCountryToSet(final Set<String> countrySet, final OfficialLanguage language) {

		countrySet.add(language.getCountry());
	}

	private void addAllLanguagesToSet(final Set<String> languagesSet, final OfficialLanguage language) {

		languagesSet.addAll(language.getLanguages());
	}

	private void putAll(final Map<String, Integer> countryWithHighestOfficialLanguages, final TreeMap<String, Integer> countryWithHighestOfficialLanguagesSorted) {

		countryWithHighestOfficialLanguagesSorted.putAll(countryWithHighestOfficialLanguages);
	}

	private TreeMap<String, Integer> sortHashMap(final Map<String, Integer> map) {

		final MapValueComparator mapValueComparator = new MapValueComparator(map);

		final TreeMap<String, Integer> treeMap = new TreeMap<>(mapValueComparator);

		putAll(map, treeMap);

		return treeMap;
	}

	private void loopCountryLanguages(
			final Map<String, Integer> countMostCommonOfficialLanguage,
			final Map<String, Integer> germanyLanguageMostCountry,
			final OfficialLanguage language
	) {

		for (final String lang : language.getLanguages()) {

			populateHashMapWithKeyValues(countMostCommonOfficialLanguage, lang);

			if (GERMANY_LANGUAGE.equals(lang)) {

				populateHashMapWithKeyValues(germanyLanguageMostCountry, lang);
			}
		}
	}

	private void populateHashMapWithKeyValues(final Map<String, Integer> map, final String key) {

		if (map.containsKey(key)) {

			int currentCount = map.get(key);

			map.put(key, currentCount + INCREASE_ONE);

		} else {

			map.put(key, INCREASE_ONE);
		}
	}

	private OfficialLanguageList convertJsonStringToObject() throws JsonProcessingException {

		return OBJECT_MAPPER.readValue(Constants.JSON_COUNTRIES, OfficialLanguageList.class);
	}
}
