package magazine.teste.Backend.service;

import org.springframework.stereotype.Service;

import magazine.teste.Backend.model.Sale;
import magazine.teste.Backend.repository.CustomerRepository;
import magazine.teste.Backend.repository.SaleRepository;

@Service
public class SaleServiceImpl implements SaleService {
    
    private SaleRepository saleRepository;
    private CustomerRepository customerRepository;

    public SaleServiceImpl(SaleRepository saleRepository){
        this.saleRepository = saleRepository;
    }

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
        sale_focus.setSaleDiscount(sale.getSaleDiscount());
        sale_focus.setCustomerId(sale.getCustomerId());
        return saleRepository.save(sale_focus);
    }

    @Override

    public void deleteSale(Long saleId){
        saleRepository.deleteById(saleId);
    }

    
}
