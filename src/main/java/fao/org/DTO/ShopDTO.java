package fao.org.DTO;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import fao.org.model.Shop;

public class ShopDTO {

	@NotBlank
	private String userIdentifier;
	@NotNull
	private Float total;
	//@NotNull
	private LocalDate date;
	@NotNull
	private List<ItemsDTO> items;

	public static ShopDTO convert(Shop shop) {
		ShopDTO shopDTO = new ShopDTO();
		shopDTO.setUserIdentifier(shop.getUserIdentifier());
		shopDTO.setTotal(shop.getTotal());
		return shopDTO;
	}

	public String getUserIdentifier() {
		return userIdentifier;
	}

	public void setUserIdentifier(String userIdentifier) {
		this.userIdentifier = userIdentifier;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<ItemsDTO> getItems() {
		return items;
	}

	public void setItems(List<ItemsDTO> items) {
		this.items = items;
	}

}
