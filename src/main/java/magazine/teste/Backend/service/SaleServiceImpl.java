package magazine.teste.Backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import magazine.teste.Backend.model.Sale;
import magazine.teste.Backend.repository.SaleRepository;

@Service
public class SaleServiceImpl implements SaleService {
    
    @Autowired    
    private SaleRepository saleRepository;

    @Override
    public Iterable<Sale> getAllSales(){
        return saleRepository.findAll();
    }

    @Override
    public Sale getSaleById (Long saleId){
        return saleRepository.findById(saleId).orElse(null);
    }

    @Override
    public Sale createSale (Sale sale){
        return saleRepository.save(sale);
    }

    @Override
    public Sale updateSale(Long saleId, Sale sale){
        Sale sale_focus = saleRepository.findById(saleId).orElse(null);
        sale_focus.setTotalSaleValue(sale.getTotalSaleValue());
        sale_focus.setCustomer(sale.getCustomer());
        return saleRepository.save(sale_focus);
    }

    @Override

    public void deleteSale(Long saleId){
        saleRepository.deleteById(saleId);
    }

    
}
