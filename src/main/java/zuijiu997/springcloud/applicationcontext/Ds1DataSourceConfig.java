package zuijiu997.template.applicationcontext;

//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef="entityManagerFactoryDs1",
//        transactionManagerRef="transactionManagerDs1",
//        basePackages={"zuijiu997.template.dao.ds1"})
public class Ds1DataSourceConfig {

//    @Autowired
//    @Qualifier("ds1DataSource")
//    private DataSource dataSource;
//
//    @Autowired
//    private JpaProperties jpaProperties;
//
//    @Primary
//    @Bean(name="entityManagerDs1")
//    public EntityManager entityManager(EntityManagerFactoryBuilder builder){
//        return entityManagerFactoryBean(builder).getObject().createEntityManager();
//    }
//
//    @Primary
//    @Bean(name="entityManagerFactoryDs1")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder){
//        return builder
//                .dataSource(dataSource)
//                .properties(getProperties())
//                .packages("zuijiu997.template.entity.ds1")
//                .persistenceUnit("ds1PersistentUnit")
//                .build();
//    }
//
//    public Map<String, String> getProperties(){
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("format_sql", "true");
//        map.put("max_fetch_depth", "1");
//        return map;
//    }
//
//
//    @Primary
//    @Bean(name="transactionManagerDs1")
//    public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder){
//        return new JpaTransactionManager(entityManagerFactoryBean(builder).getObject());
//    }

}
