package magazine.teste.Backend.service;

import org.springframework.stereotype.Service;

import magazine.teste.Backend.model.SaleItem;
import magazine.teste.Backend.repository.SaleItemRepository;



@Service
public class SaleItemServiceImpl implements SaleItemService {
    
    private SaleItemRepository saleItemRepository;

    public SaleItemServiceImpl(SaleItemRepository saleItemRepository){
        this.saleItemRepository = saleItemRepository;
    }

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
        saleItemFocus.setProductId(saleItem.getProductId());
        saleItemFocus.setQuantity(saleItem.getQuantity());
        saleItemFocus.setSaleId(saleItem.getSaleId());
        return saleItemRepository.save(saleItemFocus);
    }

    @Override
    public void deleteSaleItem(Long saleItemId){
        saleItemRepository.deleteById(saleItemId);
    }

}
