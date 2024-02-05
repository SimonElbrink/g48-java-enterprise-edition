package se.lexicon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.dao.TransactionDao;
import se.lexicon.dao.WalletDao;
import se.lexicon.exception.WalletNotFoundException;
import se.lexicon.model.CryptoCurrency;
import se.lexicon.model.Transaction;
import se.lexicon.model.Wallet;
import se.lexicon.service.TransactionManagement;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class TransactionManagementImpl implements TransactionManagement {


    private WalletDao walletDao;

    private TransactionDao transactionDao;

    @Autowired
    public TransactionManagementImpl(WalletDao walletDao, TransactionDao transactionDao) {
        this.walletDao = walletDao;
        this.transactionDao = transactionDao;
    }

    // Check for null
    // CheckWallet id exist or not
    // Validate The amount
    // Call Deposit method from Wallet Class
    // Create Transaction Record
    // Save the Transaction history.
    @Override
    public Transaction createDepositTransaction(String walletId, CryptoCurrency cryptoCurrency, BigDecimal amount, String description) {

        if (walletId == null || cryptoCurrency == null || amount == null) throw new IllegalArgumentException("Transaction params were not valid");

        Optional<Wallet> optionalWallet = walletDao.findWallet(walletId);
        if (optionalWallet.isEmpty()) throw new WalletNotFoundException("Wallet Not Found");

        Wallet wallet = optionalWallet.get();
        wallet.deposit(cryptoCurrency,amount);

        Transaction transaction = new Transaction("DEPOSIT", amount, walletId, cryptoCurrency.getName());
        transaction.setDescription(description);

        Transaction createdTranaction = transactionDao.createTransaction(transaction);

        return createdTranaction;
    }

    @Override
    public Transaction createWithdrawalTransaction(String walletId, CryptoCurrency cryptoCurrency, BigDecimal amount, String description) {
        //TODO - Implement this method

        return null;
    }

    @Override
    public List<Transaction> getTransactionsByWalletId(String WalletId) {
        //TODO - Implement this method
        return null;
    }
}
