package info.makowey.boardgames.chilipir.scraper.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class CollectionBggFilter {

    private boolean owned;
    private boolean wishlist;
    private String wishPriority;

    @Setter
    private int priority;
}
