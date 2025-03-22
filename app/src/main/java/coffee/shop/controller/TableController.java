package coffee.shop.controller;

import java.util.List;

import coffee.shop.model.CoffeeTable;
import coffee.shop.service.table.ITableService;

public class TableController {
    private final ITableService tableService;

    public TableController(ITableService tableService) {
        this.tableService = tableService;
    }

    public List<CoffeeTable> getAllCoffeeTables(){
        return tableService.getAllCoffeeTables();
    }

    public List<CoffeeTable> getAllBlankTables(){
        return tableService.getAllBlankTables();
    }

    public List<CoffeeTable> getAllUsedTables(){
        return tableService.getAllUsedTables();
    }
}
