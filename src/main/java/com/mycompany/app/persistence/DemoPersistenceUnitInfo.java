package com.mycompany.app.persistence;

import java.net.URL;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.SharedCacheMode;
import jakarta.persistence.ValidationMode;
import jakarta.persistence.spi.ClassTransformer;
import jakarta.persistence.spi.PersistenceUnitInfo;
import jakarta.persistence.spi.PersistenceUnitTransactionType;

// Remember to comment this class if you are using the persistence.xml file
public class DemoPersistenceUnitInfo implements PersistenceUnitInfo {

  @Override
  public String getPersistenceUnitName() {
    return "library_persistence_unit";
  }

  @Override
  public String getPersistenceProviderClassName() {
    return "org.hibernate.jpa.HibernatePersistenceProvider";
  }

  @Override
  public PersistenceUnitTransactionType getTransactionType() {
    return PersistenceUnitTransactionType.RESOURCE_LOCAL;
  }

  @Override
  public DataSource getNonJtaDataSource() {
    HikariDataSource dataSource = new HikariDataSource();

    dataSource.setJdbcUrl("jdbc:mariadb://localhost:3306/library");
    dataSource.setUsername("root");
    dataSource.setPassword("test");
    return dataSource;
  }

  @Override
  public void addTransformer(ClassTransformer transformer) {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean excludeUnlistedClasses() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public ClassLoader getClassLoader() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<URL> getJarFileUrls() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public DataSource getJtaDataSource() {
    // TODO Auto-generated method stub
    return null;
  }

  // Remember to implement this method. If not things will not work
  @Override
  public List<String> getManagedClassNames() {
    return null;
  }

  @Override
  public List<String> getMappingFileNames() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ClassLoader getNewTempClassLoader() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public URL getPersistenceUnitRootUrl() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getPersistenceXMLSchemaVersion() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Properties getProperties() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public SharedCacheMode getSharedCacheMode() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ValidationMode getValidationMode() {
    // TODO Auto-generated method stub
    return null;
  }

}