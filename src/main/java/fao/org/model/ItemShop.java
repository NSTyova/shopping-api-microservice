package fao.org.model;

import javax.persistence.Embeddable;

import fao.org.DTO.ItemsDTO;

@Embeddable
public class ItemShop {

	private String productIdentifier;
	private Float price;

	public static ItemShop convert(ItemsDTO itemDTO) {
		ItemShop item = new ItemShop();
		item.setProductIdentifier(
		itemDTO.getProductIdentifier());
		item.setPrice(itemDTO.getPrice());
		return item;
		}
	
	public String getProductIdentifier() {
		return productIdentifier;
	}

	public void setProductIdentifier(String productIdentifier) {
		this.productIdentifier = productIdentifier;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

}
