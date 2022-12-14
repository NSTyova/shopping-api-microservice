package fao.org.converter;

import java.util.stream.Collectors;

import fao.org.DTO.ItemsDTO;
import fao.org.DTO.ShopDTO;
import fao.org.model.ItemShop;
import fao.org.model.Shop;

public class DTOConverter {

	public static ItemsDTO convert(ItemShop item) {
		ItemsDTO itemDTO = new ItemsDTO();
		itemDTO.setProductIdentifier(item.getProductIdentifier());
		itemDTO.setPrice(item.getPrice());
		return itemDTO;
	}
	
	public static ShopDTO convert(Shop shop) {
		ShopDTO shopDTO = new ShopDTO();
		shopDTO.setUserIdentifier(shop.getUserIdentifier());
		shopDTO.setTotal(shop.getTotal());
		shopDTO.setDate(shop.getDate());
		shopDTO.setItems(shop.getItems().stream().map(DTOConverter::convert).collect(Collectors.toList()));
		return shopDTO;
	}	
}
