package fao.org.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import fao.org.model.ItemShop;

public class ItemsDTO {

	@NotBlank
	private String productIdentifier;
	@NotNull
	private Float price;

	// get and sets
	public static ItemsDTO convert(ItemShop item) {
		ItemsDTO itemDTO = new ItemsDTO();
		itemDTO.setProductIdentifier(item.getProductIdentifier());
		itemDTO.setPrice(item.getPrice());
		return itemDTO;
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
