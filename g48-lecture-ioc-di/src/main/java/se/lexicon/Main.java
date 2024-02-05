package se.lexicon;

import se.lexicon.dao.TransactionDao;
import se.lexicon.dao.WalletDao;
import se.lexicon.dao.impl.TransactionDaoImpl;
import se.lexicon.dao.impl.WalletDaoImpl;
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
        WalletDao walletDao = new WalletDaoImpl();
        TransactionDao transactionDao  = new TransactionDaoImpl();


        WalletManagement walletManagement = new WalletManagementImpl(walletDao);
        TransactionManagement transactionManagement = new TransactionManagementImpl(walletDao, transactionDao);

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


        transactionDao.findTransactionsByWalletId(wallet.getId()).forEach(System.out::println);


    }
}