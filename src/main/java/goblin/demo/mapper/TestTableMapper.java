package goblin.demo.mapper;


import goblin.demo.entity.TestTable;

import java.util.List;

public interface TestTableMapper {

    TestTable findById(String id);

    long save(TestTable testTable);
}

