package fao.org.service.interfacesReports;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fao.org.DTO.ShopReportDTO;
import fao.org.model.Shop;

public class ReportRepositoryImpl implements ReportRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Shop> getShopByFilters(LocalDate dataInicio, LocalDate dataFim, Float valorMinimo) {
		StringBuilder sb = new StringBuilder();
		sb.append("select s ");
		sb.append("from Shop s ");
		sb.append("where s.date >= :dataInicio ");
		if (dataFim != null) {
			sb.append("and s.date <= :dataFim ");
		}
		if (valorMinimo != null) {
			sb.append("and s.total <= :valorMinimo ");
		}
		Query query = entityManager.createQuery(sb.toString());
		query.setParameter("dataInicio", dataInicio);
		if (dataFim != null) {
			query.setParameter("dataFim", dataFim);
		}
		if (valorMinimo != null) {
			query.setParameter("valorMinimo", valorMinimo);
		}
		return query.getResultList();
	}

	@Override
	public ShopReportDTO getReportByDate(LocalDate dataInicio, LocalDate dataFim) {
		StringBuilder sb = new StringBuilder();
		sb.append("select count(sp.id), sum(sp.total), avg(sp.total) ");
		sb.append("from shop sp ");
		sb.append("where sp.date >= :dataInicio ");
		sb.append("and sp.date <= :dataFim ");
		Query query = entityManager.createNativeQuery(sb.toString());
		query.setParameter("dataInicio", dataInicio);
		query.setParameter("dataFim", dataFim);
		Object[] result = (Object[]) query.getSingleResult();
		ShopReportDTO shopReportDTO = new ShopReportDTO();
		shopReportDTO.setCount(((BigInteger) result[0]).intValue());
		shopReportDTO.setTotal((Double) result[1]);
		shopReportDTO.setMean((Double) result[2]);
		return shopReportDTO;
	}

}
