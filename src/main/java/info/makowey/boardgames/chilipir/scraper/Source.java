package info.makowey.boardgames.chilipir.scraper;

import info.makowey.boardgames.chilipir.scraper.model.BoardGameExtractor;
import info.makowey.boardgames.chilipir.scraper.stores.*;
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
            100,
            "http://static.elefant.ro/fe/bundles/elefantfront/images/elefant_logo.png?v=2"),

    REGAT("RegatulJocurilor.ro",
            "",
            "http://regatuljocurilor.ro",
            "/index.php?main_page=advanced_search_result&search_in_description=0&x=0&y=0&keyword=",
            "perPage...",
            "page...",
            "<div class=\"centerBoxContentsProducts centeredContent\" style=\"width:100%;\">",
            100,
            "http://www.regatuljocurilor.ro/includes/templates/abbington_mega/images/logo.png"),

    CARTURESTI("Carturesti.ro",
            "",
            "https://carturesti.ro",
            "/raft/board-games-1445?stock_label=in-stoc,stoc-limitat",
            "perPage...",
            "page...",
            ".product-grid-container a",
            90,
            "https://www.hueman.ro/wp-content/uploads/carturesti_whitelogo.png"),

    LEXSHOP("Lexshop.ro",
            "",
            "https://www.lexshop.ro",
            "?page=produse&categorie=8&min=6.5&max=899&nrjucatori_min=1&nrjucatori_max=99&sort=0&nrpg=36",
            "perPage...",
            "page...",
            "<div class=\"prod_nou \">",
            36,
            "https://d10w0d1gdgjea2.cloudfront.net/app/images/logo.png"),

    PIONUL("Pionul.ro",
            "",
            "http://pionul.ro",
            "/...",
            "???",
            "???",
            "div",
            100,
            "http://pionul.ro/image/cache/data/Daniel/Pionul%20textura-01-Recovered-600x315.png"),

    LELEGAMES("LeleGames.ro",
            "",
            "http://lelegames.ro",
            "/...",
            "???",
            "???",
            "div",
            100,
            "https://www.lelegames.ro/image/cache/logo/logo-300x369.png"),

    EMAG("Emag.ro",
            "https://www.emag.ro/search/jocuri-societate/%s/c",
            "http://emag.ro",
            "https://www.emag.ro/search/jocuri-societate/azul/c",
            "???",
            "???",
            "<div class='card-item js-product-data'>",
            100,
            "https://s12emagst.akamaized.net/layout/ro/images/logo//38/57629.png"),

    BESTKIDS("BestKids.ro",
            "https://www.bestkids.ro/searchadv.aspx?CategoryID=92&IsSubmit=true&SearchTerm=%s",
            "http://bestkids.ro",
            "https://www.bestkids.ro/searchadv.aspx?CategoryID=92&IsSubmit=true&SearchTerm=catan",
            "???",
            "???",
            "<div class='search_product clearfix'>",
            100,
            "https://www.bestkids.ro/skins/skin_1/images/logo_new.png"),

    GEEKMARKET("GeekMarket",
            "",
            "https://boardgamegeek.com",
            "/geekmarket/browse?objecttype=thing&objectid=230802",
            "perPage...",
            "page...",
            "????",
            100,
            "https://cf.geekdo-static.com/images/geekmarket/geekmarket.png"
    );

    private String siteName;
    private String formatter;
    private String baseUrl;
    private String path;
    private String productsPerPageName;
    private String pageName;
    private String productDiv;
    private int numberOfProductsPerPage;
    private String logo;

    public static Source getByName(String name) {
        return Optional.of(valueOf(name.toUpperCase()))
                .orElse(REGAT);
    }

    public String getPath(int counter) {
        return getBaseUrl().concat(path)
                .concat(format(getFormatter(),
                        getProductsPerPageName(),
                        getNumberOfProductsPerPage(),
                        getPageName(),
                        counter));
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
            case PIONUL:
                return PionulScrapperGame.INSTANCE;
            case LELEGAMES:
                return LeleScrapperGame.INSTANCE;
            case EMAG:
                return EmagScrapperGame.INSTANCE;
            case BESTKIDS:
                return BestKidsScrapperGame.INSTANCE;
            case GEEKMARKET:
                return GeekMarketScrapperGame.INSTANCE;
            default:
                throw new ExceptionInInitializerError("NO INSTANCE FOUND FOR " + name());
        }
    }
}
