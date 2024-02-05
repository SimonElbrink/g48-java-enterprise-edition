package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.AppConfig;
import se.lexicon.model.CryptoCurrency;
import se.lexicon.model.Transaction;
import se.lexicon.model.Wallet;
import se.lexicon.service.TransactionManagement;
import se.lexicon.service.WalletManagement;
import se.lexicon.service.impl.TransactionManagementImpl;
import se.lexicon.service.impl.WalletManagementImpl;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


        WalletManagement walletManagement = context.getBean(WalletManagementImpl.class);
        TransactionManagement transactionManagement = context.getBean(TransactionManagementImpl.class);

        Wallet wallet = walletManagement.create("simons-wallet");

        Transaction transactionBTC = transactionManagement.createDepositTransaction(
                wallet.getId(),
                CryptoCurrency.BTC,
                new BigDecimal(1),
                "test"
        );


        Transaction transactionETH = transactionManagement.createDepositTransaction(
                wallet.getId(),
                CryptoCurrency.ETH,
                new BigDecimal(10),
                "test"
        );

        Transaction transactionBNB = transactionManagement.createDepositTransaction(
                wallet.getId(),
                CryptoCurrency.BNB,
                new BigDecimal(1000),
                "test"
        );

        System.out.println(walletManagement.getById(wallet.getId()));
    }
}