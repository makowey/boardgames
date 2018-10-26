package info.makowey.boardgames.chilipir.scraper;

import info.makowey.boardgames.chilipir.scraper.model.BoardGameExtractor;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

import static java.lang.String.format;

@Getter
@AllArgsConstructor
public enum Source {

    ELEFANT("Elefant.ro",
            "?%s=%d&%s=%d",
            "http://www.elefant.ro",
            "/list/jucarii/jocuri/jocuri-de-societate",
            "productsPerPage",
            "page",
            "<div class=\"thumbnail\">",
            100),

    REGAT("RegatulJocurilor.ro",
            "",
            "http://regatuljocurilor.ro",
            "/index.php?main_page=advanced_search_result&search_in_description=0&x=0&y=0&keyword=",
            "perPage...",
            "page...",
            "<div class=\"centerBoxContentsProducts centeredContent\" style=\"width:100%;\">",
            100),

    CARTURESTI("Carturesti.ro",
            "",
            "https://carturesti.ro",
            "/raft/board-games-1445?stock_label=in-stoc,stoc-limitat",
            "perPage...",
            "page...",
            ".product-grid-container a",
            90 ),
    LEXSHOP( "Lexshop.ro",
            "",
            "https://www.lexshop.ro",
            "?page=produse&categorie=8&min=6.5&max=899&nrjucatori_min=1&nrjucatori_max=99&sort=0&nrpg=36",
            "perPage...",
            "page...",
            "<div class=\"prod_nou \">",
            36 );

    private String siteName;
    private String formatter;
    private String baseUrl;
    private String path;
    private String productsPerPageName;
    private String pageName;
    private String productDiv;
    private int numberOfProductsPerPage;

    public String getPath(int counter) {
        return getBaseUrl().concat(path)
                .concat(format(getFormatter(),
                        getProductsPerPageName(),
                        getNumberOfProductsPerPage(),
                        getPageName(),
                        counter));
    }

    public static Source getByName(String name) {
        return Optional.of(valueOf(name.toUpperCase()))
                .orElse(ELEFANT);
    }

    public BoardGameExtractor getBGEInstance() {
        switch (this) {
            case ELEFANT:
                return ElefantScraperGame.INSTANCE;
            case REGAT:
                return RegatScrapperGame.INSTANCE;
            case CARTURESTI:
                return CarturestiScrapperGame.INSTANCE;
            case LEXSHOP:
                return LexshopScrapperGame.INSTANCE;
            default:
                throw new ExceptionInInitializerError("NO INSTANCE FOUND FOR " + name());
        }
    }
}
