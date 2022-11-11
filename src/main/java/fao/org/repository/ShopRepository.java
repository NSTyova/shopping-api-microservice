package fao.org.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fao.org.model.Shop;
import fao.org.service.interfacesReports.ReportRepository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long>, ReportRepository{

	public List<Shop> findAllByUserIdentifier(String userIdentifier);
	//public List<Shop> findAllByTotalGreaterThan(Float total);
	public List<Shop> findAllByTotal(Float total);
	//List<Shop> findAllByDateGreaterThanEquals(LocalDate date);
	List<Shop> findAllByDate(LocalDate date);
}
