package io.github.iangerolamo.shoppingapi.repository;

import dto.ShopReportDTO;
import io.github.iangerolamo.shoppingapi.model.Shop;


import java.util.Date;
import java.util.List;

public interface ReportRepository  {

    public List<Shop> getShopByFilters(Date dataInicio, Date dataFim, Float valorMinimo);

    public ShopReportDTO getReportByDate(Date dataInicio, Date dataFim);

}
