package info.makowey.boardgames.chilipir.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Document
public class BoardGame {

	@Indexed
	@Field("gameId")
	@JsonProperty
	private int bggId;

	@JsonProperty
	private String name;

	@JsonProperty
	private String urlImage;

	@JsonProperty
	private double bestPrice;

	@JsonProperty
	private double lowestPriceEver;

	@JsonProperty
	private Store store;
}