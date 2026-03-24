package tracker.db;

import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EntityScan("tracker.db.entity")
@EnableJpaRepositories("tracker.db.repository")
@EnableTransactionManagement
public class DatasourceConfig { }
