package goblin.demo.test;

import goblin.demo.entity.TestTable;
import goblin.demo.mapper.TestTableMapper;
import io.github.oitstack.goblin.spring.starter.GoblinTest;
import io.github.oitstack.goblin.unit.db.UsingDataSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


/**
 * Goblin测试用例样例， Goblin配置参考：src/test/resources/goblin.yml
 * @author yangguang
 * @date 2022/5/7
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest //springboot工程
@GoblinTest //该注解用于启动Goblin运行环境
@UsingDataSet //该注解用于给数据库预置数据，在用例执行之前会读取用于定义的对应用例的数据并插入到数据库. 放在类上作用在整个类的测试用例，放在方法上仅作用于当前方法。
public class DemoTest {

    @Autowired
    private TestTableMapper testTableMapper;

    /**
     * 该用例用于测试启动的mysql容器的基本功能。  用例模拟了一个真实的springboot应用，该springboot应用使用mybatis连接mysql,
     * 在用例运行过程中使用占位符 GOBLIN_MYSQL_URL， GOBLIN_MYSQL_USERNAME，GOBLIN_MYSQL_PASSWORD替代了原本项目中的信息，
     * 使本地能连接到用例启动的mysql容器
     */
    @Test
    public void mysqlTest() throws InterruptedException {
        TestTable record = new TestTable();
        record.setBusiness("business");

        //手动数据插入测试
        long count = testTableMapper.save(record);
        Assertions.assertEquals(count, 1);

        //数据初始化测试（UsingDataSet注解注入的数据，数据在goblin/demo/test/DemoTest-mysql.xml文件中配置）
        TestTable findById = testTableMapper.findById("100");
        Assertions.assertNotNull(findById);
        Assertions.assertEquals(findById.getId(), 100L);

//        Thread.sleep(500000);
    }
}
