package coffee.shop.service.table;

import java.util.List;

import coffee.shop.model.CoffeeTable;

public interface ITableService {
    public List<CoffeeTable> getAllCoffeeTables();
    public List<CoffeeTable> getAllBlankTables();
    public List<CoffeeTable> getAllUsedTables();
}
