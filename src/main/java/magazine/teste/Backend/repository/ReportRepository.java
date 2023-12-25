// package magazine.teste.Backend.repository;

// import java.util.List;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.CrudRepository;

// import magazine.teste.Backend.ResponseBody.ReportResponse;



// public interface ReportRepository extends CrudRepository<ReportResponse, Long> {
 
//     // @Query("SELECT sum(si.quantity), p.stock_quantity, p.id, p.name, ((si.product_final_value / si.quantity) - p.cost_value) as profit from sale_item si join product p on p.id = si.product_id GROUP by si.product_id;")
//     // List<ReportResponse> mainReport();

// }

