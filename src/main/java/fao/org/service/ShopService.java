package fao.org.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import fao.org.DTO.ShopDTO;
import fao.org.DTO.ShopReportDTO;

@Service
public interface ShopService {

	public List<ShopDTO> getAll();
	
	public List<ShopDTO> getByUser(String userIdentifier);
	public List<ShopDTO> getByDate(ShopDTO shopDTO);
	public ShopDTO findById(long ProductId);
	public ShopDTO save(ShopDTO shopDTO);
	
	//pegar as consultas
	public List<ShopDTO> getShopsByFilter(LocalDate dataInicio,LocalDate dataFim,Float valorMinimo);
	public ShopReportDTO getReportByDate(LocalDate dataInicio, LocalDate dataFim);
	
}
