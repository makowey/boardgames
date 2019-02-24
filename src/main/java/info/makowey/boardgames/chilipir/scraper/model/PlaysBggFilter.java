package info.makowey.boardgames.chilipir.scraper.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class PlaysBggFilter {
    private String minDate;
    private String maxDate;
    private String subtype;
    private int id;
    private int page;
    private String year;
}
