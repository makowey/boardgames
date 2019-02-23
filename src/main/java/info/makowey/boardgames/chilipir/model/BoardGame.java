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
    @EqualsAndHashCode.Exclude
    private long identifier;

    @JsonProperty
    @EqualsAndHashCode.Exclude
    private int bggId;

    @Indexed
    @JsonProperty
    @EqualsAndHashCode.Include
    private String name;

    @JsonProperty
    @EqualsAndHashCode.Exclude
    private String urlImage;

    @JsonProperty
    @EqualsAndHashCode.Exclude
    private double bestPrice;

    @EqualsAndHashCode.Include
    private double currentPrice;

    @JsonProperty
    @EqualsAndHashCode.Exclude
    private double lowestPriceEver;

    @JsonProperty
    @EqualsAndHashCode.Exclude
    private double normalPrice;

    @JsonProperty
    @EqualsAndHashCode.Exclude
    private double percent;

    @JsonProperty
    private Store store;

    @JsonProperty
    @EqualsAndHashCode.Exclude
    private String bggDetails;

    public String getName() {
        return StringEscapeUtils.unescapeHtml4(name);
    }


}
