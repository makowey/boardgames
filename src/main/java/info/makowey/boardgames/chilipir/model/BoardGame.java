package info.makowey.boardgames.chilipir.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringEscapeUtils;
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

    @Indexed
    @JsonProperty
    private String id;

    @Id
    @Indexed
    @JsonProperty
    private long identifier;

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
    private double normalPrice;

    @JsonProperty
    private double percent;

    @JsonProperty
    private Store store;

    @JsonProperty
    private String bggDetails;

    public String getName() {
        return StringEscapeUtils.unescapeHtml4(name);
    }
}
