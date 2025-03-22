package coffee.shop.service.table;

import java.util.Collections;
import java.util.List;

import coffee.shop.dao.TableCoffeeDAO;
import coffee.shop.model.CoffeeTable;

public class TableService implements ITableService{
    private final TableCoffeeDAO tableDAO;

    public TableService(TableCoffeeDAO tableDAO) {
        this.tableDAO = tableDAO;
    }

    @Override
    public List<CoffeeTable> getAllCoffeeTables() {
        return tableDAO.getAllCoffeeTables();
    }

    @Override
    public List<CoffeeTable> getAllBlankTables() {
        return tableDAO.getAllBlankTables();
    }

    @Override
    public List<CoffeeTable> getAllUsedTables() {
        return tableDAO.getAllUsedTables();
    }
}
