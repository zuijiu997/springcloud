package zuijiu997.template.applicationcontext;

//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef="entityManagerFactoryDs2",
//        transactionManagerRef="transactionManagerDs2",
//        basePackages={"zuijiu997.template.dao.ds2"})
public class Ds2DataSourceConfig {

//    @Autowired
//    @Qualifier("ds2DataSource")
//    private DataSource dataSource;
//
//    @Autowired
//    private JpaProperties jpaProperties;
//
//    @Bean(name="entityManagerDs2")
//    public EntityManager entityManager(EntityManagerFactoryBuilder builder){
//        return entityManagerFactoryBean(builder).getObject().createEntityManager();
//    }
//
//    @Bean(name="entityManagerFactoryDs2")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder){
//        return builder
//                .dataSource(dataSource)
//                .properties(getProperties())
//                .packages("zuijiu997.template.entity.ds2")
//                .persistenceUnit("ds2PersistentUnit")
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
//    @Bean(name="transactionManagerDs2")
//    public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder){
//        return new JpaTransactionManager(entityManagerFactoryBean(builder).getObject());
//    }

}
