package se.lexicon.service.impl;

import se.lexicon.dao.WalletDao;
import se.lexicon.exception.WalletNotFoundException;
import se.lexicon.exception.WalletValidationException;
import se.lexicon.model.Wallet;
import se.lexicon.service.WalletManagement;

import java.util.Optional;

// Where business logic happens, Connection to other services, Auth, Validation ....
public class WalletManagementImpl implements WalletManagement {

    //Dependency
    private WalletDao walletDao;

    public WalletManagementImpl(WalletDao walletDao) {
        this.walletDao = walletDao;
    }

    @Override
    public Wallet create(String walletName) {
        // Logics, validation, Connection with other services.
        if(walletName == null) throw new WalletValidationException("Param is not valid", "Wallet Name");
        Wallet wallet = new Wallet(walletName);

        return walletDao.createWallet(wallet);
    }

    @Override
    public Wallet getById(String id) {
        Optional<Wallet> optionalWallet = walletDao.findWallet(id);
        if (optionalWallet.isEmpty()) throw new WalletNotFoundException("Wallet not found.");
        return optionalWallet.get();
    }
}
