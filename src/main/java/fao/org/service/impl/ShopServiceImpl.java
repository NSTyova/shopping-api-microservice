package fao.org.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fao.org.DTO.ShopDTO;
import fao.org.DTO.ShopReportDTO;
import fao.org.converter.DTOConverter;
import fao.org.model.Shop;
import fao.org.repository.ShopRepository;
import fao.org.service.ShopService;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopRepository shopRepository;
	


	@Override
	public List<ShopDTO> getAll() {
		List<Shop> shops = shopRepository.findAll();
		return shops.stream().map(ShopDTO::convert).collect(Collectors.toList());
	}

	@Override
	public List<ShopDTO> getByUser(String userIdentifier) {
		List<Shop> shops = shopRepository.findAllByUserIdentifier(userIdentifier);
		return shops.stream().map(ShopDTO::convert).collect(Collectors.toList());
	}

	@Override
	public List<ShopDTO> getByDate(ShopDTO shopDTO) {
		List<Shop> shops = shopRepository.findAllByDate(shopDTO.getDate());
		return shops.stream().map(ShopDTO::convert).collect(Collectors.toList());
	}

	@Override
	public ShopDTO findById(long ProductId) {
		Optional<Shop> shop = shopRepository.findById(ProductId);
		if (shop.isPresent()) {
			return ShopDTO.convert(shop.get());
		}
		return null;
	}

	@Override
	public ShopDTO save(ShopDTO shopDTO) {
		shopDTO.setTotal(shopDTO.getItems().stream().map(x -> x.getPrice()).reduce((float) 0, Float::sum));
		Shop shop = Shop.convert(shopDTO);
		shop.setDate(LocalDate.now());
		shop = shopRepository.save(shop);
		return ShopDTO.convert(shop);
	}

	@Override
	public List<ShopDTO> getShopsByFilter(LocalDate dataInicio, LocalDate dataFim, Float valorMinimo) {
		List<Shop> shops =
				shopRepository
				.getShopByFilters(dataInicio, dataFim, valorMinimo);
				return shops
				.stream()
				.map(DTOConverter::convert)
				.collect(Collectors.toList());
	}
	
	public ShopReportDTO getReportByDate(
			LocalDate dataInicio,
			LocalDate dataFim) {
			return shopRepository.getReportByDate(dataInicio, dataFim);
			}

}
