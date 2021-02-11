package info.makowey.boardgames.chilipir.scraper;

import info.makowey.boardgames.chilipir.scraper.model.BoardGameExtractor;
import info.makowey.boardgames.chilipir.scraper.stores.BarlogGameExtractor;
import info.makowey.boardgames.chilipir.scraper.stores.BestKidsScrapperGame;
import info.makowey.boardgames.chilipir.scraper.stores.CarturestiScrapperGame;
import info.makowey.boardgames.chilipir.scraper.stores.ElefantScraperGame;
import info.makowey.boardgames.chilipir.scraper.stores.EmagScrapperGame;
import info.makowey.boardgames.chilipir.scraper.stores.EmptyBoardGameExtractor;
import info.makowey.boardgames.chilipir.scraper.stores.GeekMarketScrapperGame;
import info.makowey.boardgames.chilipir.scraper.stores.LeleScrapperGame;
import info.makowey.boardgames.chilipir.scraper.stores.LexshopScrapperGame;
import info.makowey.boardgames.chilipir.scraper.stores.PersonalScrapperGame;
import info.makowey.boardgames.chilipir.scraper.stores.PionulScrapperGame;
import info.makowey.boardgames.chilipir.scraper.stores.RedGoblinGameExtractor;
import info.makowey.boardgames.chilipir.scraper.stores.RegatScrapperGame;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

import static java.lang.String.format;

@Getter
@AllArgsConstructor
public enum Source {

	ELEFANT( "Elefant.ro",
			"?%s=%d&%s=%d",
			"http://www.elefant.ro",
			"/list/jucarii/jocuri/jocuri-de-societate",
			"productsPerPage",
			"page",
			"<div class=\"thumbnail\">",
			100,
			"http://static.elefant.ro/fe/bundles/elefantfront/images/elefant_logo.png?v=2" ),

	REGAT( "RegatulJocurilor.ro",
			"",
			"http://regatuljocurilor.ro",
			"/index.php?main_page=advanced_search_result&search_in_description=0&x=0&y=0&keyword=",
			"perPage...",
			"page...",
			"<div class=\"centerBoxContentsProducts centeredContent\" style=\"width:100%;\">",
			100,
			"http://www.regatuljocurilor.ro/includes/templates/abbington_mega/images/logo.png" ),

	CARTURESTI( "Carturesti.ro",
			"",
			"https://carturesti.ro",
			"/raft/board-games-1445?stock_label=in-stoc,stoc-limitat",
			"perPage...",
			"page...",
			".product-grid-container a",
			90,
			"https://citylink.ro/wp-content/uploads/2020/02/carturesti.jpg" ),

	LEXSHOP( "Lexshop.ro",
			"",
			"https://www.lexshop.ro",
			"?page=produse&categorie=8&min=6.5&max=899&nrjucatori_min=1&nrjucatori_max=99&sort=0&nrpg=36",
			"perPage...",
			"page...",
			"<div class=\"prod_nou \">",
			36,
			"https://d10w0d1gdgjea2.cloudfront.net/app/images/logo.png" ),

	PIONUL( "Pionul.ro",
			"",
			"http://pionul.ro",
			"/...",
			"???",
			"???",
			"div",
			100,
			"http://pionul.ro/image/cache/data/Daniel/Pionul%20textura-01-Recovered-600x315.png" ),

	LELEGAMES( "LeleGames.ro",
			"",
			"http://lelegames.ro",
			"/...",
			"???",
			"???",
			"div",
			100,
			"https://www.lelegames.ro/image/cache/logo/logo-300x369.png" ),

	EMAG( "Emag.ro",
			"https://www.emag.ro/search/jocuri-societate/%s/c",
			"https://www.emag.ro",
			"https://www.emag.ro/search/jocuri-societate/azul/c",
			"???",
			"???",
			"<div class='card-item js-product-data'>",
			100,
			"https://s12emagst.akamaized.net/layout/ro/images/logo//38/57629.png" ),

	BESTKIDS( "BestKids.ro",
			"https://www.bestkids.ro/searchadv.aspx?CategoryID=92&IsSubmit=true&SearchTerm=%s",
			"http://bestkids.ro",
			"https://www.bestkids.ro/searchadv.aspx?CategoryID=92&IsSubmit=true&SearchTerm=catan",
			"???",
			"???",
			"<div class='search_product clearfix'>",
			100,
			"https://www.bestkids.ro/skins/skin_1/images/logo_new.png" ),

	GEEKMARKET( "GeekMarket",
			"",
			"https://boardgamegeek.com",
			"/geekmarket/browse?objecttype=thing&objectid=230802",
			"perPage...",
			"page...",
			"????",
			100,
			"https://cf.geekdo-static.com/images/geekmarket/geekmarket.png" ),

	OLX( "OLX",
			"/oferte/q-%s/?view=galleryWide&page=%d",
			"https://www.olx.ro",
			"/oferte/q-boardgame/?view=galleryWide",
			"perPage...",
			"page...",
			"<div class='mheight tcenter'",
			39,
			"http://www.userlogos.org/files/logos/famecky/olxcolorrb.png"
	),

	//https://barlogulcujocuri.ro/wp-admin/admin-ajax.php?action=basel_ajax_search&number=10&post_type=product&query=barlog
	BARLOG( "Barlogul de jocuri",
			"wp-admin/admin-ajax.php?action=basel_ajax_search&number=%d&post_type=product&query=%s",
			"https://barlogulcujocuri.ro",
			"/oferte/q-boardgame/?view=galleryWide",
			"perPage...",
			"page...",
			"<div class='mheight tcenter'",
			10,
			"https://barlogulcujocuri.ro/wp-content/uploads/2018/12/barlog-logo.png"
	),

	//https://www.redgoblin.ro/cauta?s=gaia&ajax=true&id_lang=2&maxRows=10
	RED_GOBLIN( "Red Goblin",
			"/cauta?s=%s&ajax=true&id_lang=2&maxRows=%d",
			"https://www.redgoblin.ro",
			"/oferte/q-boardgame/?view=galleryWide",
			"perPage...",
			"page...",
			"<div class='mheight tcenter'",
			10,
			"https://www.redgoblin.ro//img/logo-a-b.png"
	),

	//https://services.mybcapps.com/bc-sf-filter/search/suggest?q=maracaib&shop=ludicus-ro-magazinul-clipelor-magice.myshopify.com&t=1605195515315&suggestion_limit=3&collection_limit=3&product_limit=3&page_limit=3&dym_limit=2&callback=BCSfSuggestionCallback&event_type=suggest
//	JOCOZAUR( "Jocozaur",
//			"/cauta?s=%s&ajax=true&id_lang=2&maxRows=%d",
//			"https://www.redgoblin.ro",
//			"/oferte/q-boardgame/?view=galleryWide",
//			"perPage...",
//			"page...",
//			"<div class='mheight tcenter'",
//			10,
//			"https://www.redgoblin.ro//img/logo-a-b.png"
//	),

	PERSONAL( "PERSONAL",
			"/mygames.html",
			"https://edituraamec.ro",
			"/mygames.html",
			"perPage...",
			"page...",
			"<tr class=game>",
			100,
			"https://upload.wikimedia.org/wikipedia/en/thumb/3/3d/Po_from_DreamWorks_Animation%27s_Kung_Fu_Panda.png/200px-Po_from_DreamWorks_Animation%27s_Kung_Fu_Panda.png"

			//https://www.redgoblin.ro/cauta?s=blackout&ajax=true&id_lang=2&maxRows=10
			//https://barlogulcujocuri.ro/wp-admin/admin-ajax.php?action=basel_ajax_search&number=10&post_type=product&query=dixit
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

	public static Source getByName( String name ) {
		return Optional.of( valueOf( name.toUpperCase() ) )
				.orElse( REGAT );
	}

	public String getPath( int counter ) {
		return getBaseUrl().concat( path )
				.concat( format( getFormatter(),
						getProductsPerPageName(),
						getNumberOfProductsPerPage(),
						getPageName(),
						counter ) );
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
			case OLX:
				return EmptyBoardGameExtractor.INSTANCE;
			case BARLOG:
				return BarlogGameExtractor.INSTANCE;
			case RED_GOBLIN:
				return RedGoblinGameExtractor.INSTANCE;
			case PERSONAL:
				return PersonalScrapperGame.INSTANCE;
			case GEEKMARKET:
				return GeekMarketScrapperGame.INSTANCE;
			default:
				throw new ExceptionInInitializerError( "NO INSTANCE FOUND FOR " + name() );
		}
	}
}
