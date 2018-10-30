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
	private String name;

	@JsonProperty
	private String url;

	@JsonProperty
	private String logo;

	private LocalDate lastVisit;

}
