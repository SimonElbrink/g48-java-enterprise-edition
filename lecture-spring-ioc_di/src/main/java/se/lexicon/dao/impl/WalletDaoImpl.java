package se.lexicon.dao.impl;

import org.springframework.stereotype.Component;
import se.lexicon.dao.WalletDao;
import se.lexicon.model.Wallet;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class WalletDaoImpl implements WalletDao {

    private List<Wallet> storage;

    public WalletDaoImpl() {
        this.storage = new ArrayList<>();
    }

    @Override
    public Wallet createWallet(Wallet wallet) {
        storage.add(wallet);
        return wallet;
    }

    @Override
    public Optional<Wallet> findWallet(String id) {
        return storage.stream()
                .filter((wallet)-> wallet.getId().equals(id))
                .findFirst();

    }
}
