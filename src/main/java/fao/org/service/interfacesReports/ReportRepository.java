package fao.org.service.interfacesReports;

import java.time.LocalDate;
import java.util.List;

import fao.org.DTO.ShopReportDTO;
import fao.org.model.Shop;

public interface ReportRepository {

	public List<Shop> getShopByFilters(LocalDate dataInicio, LocalDate dataFim, Float valorMinimo);

	public ShopReportDTO getReportByDate(LocalDate dataInicio, LocalDate dataFim);
}
