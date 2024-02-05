package se.lexicon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.lexicon.dao.impl.TransactionDaoImpl;
import se.lexicon.dao.impl.WalletDaoImpl;
import se.lexicon.service.impl.TransactionManagementImpl;
import se.lexicon.service.impl.WalletManagementImpl;

@Configuration
public class AppConfig {

    @Bean
    public WalletDaoImpl walletDao() {
        return new WalletDaoImpl();
    }

    @Bean
    public TransactionDaoImpl transactionDao() {
        return new TransactionDaoImpl();
    }


    @Bean
    public WalletManagementImpl walletManagement() {
        return new WalletManagementImpl(walletDao());
    }

    @Bean
    public TransactionManagementImpl transactionManagement() {
        return new TransactionManagementImpl(walletDao(), transactionDao());
    }
}
