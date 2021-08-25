package com.visualnuts;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.ToString;

/**
 * @author carlosrodrigues
 */
@Getter
@ToString
public class OfficialLanguageList {

	private final List<OfficialLanguage> officialLanguages;

	@JsonCreator
	public OfficialLanguageList(final List<OfficialLanguage> officialLanguages) {

		this.officialLanguages = officialLanguages;
	}
}
