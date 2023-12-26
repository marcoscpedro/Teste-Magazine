package magazine.teste.Backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import magazine.teste.Backend.model.SaleItem;
import magazine.teste.Backend.repository.SaleItemRepository;



@Service
public class SaleItemServiceImpl implements SaleItemService {
    
    @Autowired
    private SaleItemRepository saleItemRepository;

    @Override
    public Iterable<SaleItem> getAllSaleItems(){
        return saleItemRepository.findAll();
    }

    @Override
    public SaleItem getSaleItemById(Long saleItemId) {
        return saleItemRepository.findById(saleItemId).orElse(null);
    }

    @Override
    public SaleItem createSaleItem(SaleItem saleItem){
        return saleItemRepository.save(saleItem);
    }

    @Override
    public SaleItem updateSaleItem(Long saleItemId, SaleItem saleItem){
        SaleItem saleItemFocus = saleItemRepository.findById(saleItemId).orElse(null);
        saleItemFocus.setProduct(saleItem.getProduct());
        saleItemFocus.setQuantity(saleItem.getQuantity());
        saleItemFocus.setSale(saleItem.getSale());
        saleItemFocus.setProductDiscount(saleItem.getProductDiscount());
        saleItemFocus.setProductFinalValue(saleItemFocus.getProductFinalValue());
        return saleItemRepository.save(saleItemFocus);
    }

    @Override
    public void deleteSaleItem(Long saleItemId){
        saleItemRepository.deleteById(saleItemId);
    }

}
