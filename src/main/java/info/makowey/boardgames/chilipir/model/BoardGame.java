package info.makowey.boardgames.chilipir.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Document
@Getter
@Setter
public class BoardGame {

	@Id
	@Indexed
	@JsonProperty
	private String id;

	@JsonProperty
	private int bggId;

	@Indexed
	@JsonProperty
	private String name;

	@JsonProperty
	private String urlImage;

	@JsonProperty
	private double bestPrice;

	private double currentPrice;

	@JsonProperty
	private double lowestPriceEver;

	@JsonProperty
	private Store store;

	@JsonProperty
	private String bggDetails;
}
