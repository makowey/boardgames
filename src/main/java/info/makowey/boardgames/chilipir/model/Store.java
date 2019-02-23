package info.makowey.boardgames.chilipir.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Document
@Getter
public class Store {

	@JsonProperty
	@EqualsAndHashCode.Include
	private String name;

	@JsonProperty
	@EqualsAndHashCode.Exclude
	private String url;

	@JsonProperty
	@EqualsAndHashCode.Exclude
	private String logo;

	@EqualsAndHashCode.Exclude
	private LocalDate lastVisit;
}
