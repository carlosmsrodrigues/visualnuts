package com.visualnuts;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * @author carlosrodrigues
 */
@Getter
@ToString
public class OfficialLanguage {

	private final String country;
	private final List<String> languages;

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public OfficialLanguage(@JsonProperty("country") final String country, @JsonProperty("languages") final List<String> languages) {

		this.country = country;
		this.languages = languages;
	}
}
