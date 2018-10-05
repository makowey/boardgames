package info.makowey.boardgames.chilipir.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.BSON;
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
	private int bggId;

	private String name;
	private BSON image;
	private double bestPrice;
	private double currentPrice;
	private String storeName;
}
