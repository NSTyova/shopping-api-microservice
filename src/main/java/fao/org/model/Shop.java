package fao.org.model;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import fao.org.DTO.ShopDTO;
@Entity(name="shop")
public class Shop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String userIdentifier;
	private float total;
	private LocalDate date;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "item_shop", joinColumns = @JoinColumn(name = "shop_id"))
	private List<ItemShop> items;

	public static Shop convert(ShopDTO shopDTO) {
		Shop shop = new Shop();
		shop.setUserIdentifier(shopDTO.getUserIdentifier());
		shop.setTotal(shopDTO.getTotal());
		shop.setDate(shopDTO.getDate());
		shop.setItems(shopDTO.getItems().stream().map(ItemShop::convert).collect(Collectors.toList()));
		return shop;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserIdentifier() {
		return userIdentifier;
	}

	public void setUserIdentifier(String userIdentifier) {
		this.userIdentifier = userIdentifier;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<ItemShop> getItems() {
		return items;
	}

	public void setItems(List<ItemShop> items) {
		this.items = items;
	}

}
