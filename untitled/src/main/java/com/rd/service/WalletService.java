package com.rd.service;
import com.rd.model.Wallet;
import com.rd.repository.WalletRepository;

import java.util.List;

public class WalletService {
    private final WalletRepository walletRepository = new WalletRepository();

    public boolean createWallet(int userId, String name, double balance) {
        return walletRepository.addWallet(new Wallet(0, userId, name, balance));
    }

    public void viewWallets(int userId) {
        List<Wallet> wallets = walletRepository.getWalletsByUserId(userId);
        if (wallets.isEmpty()) {
            System.out.println("⚠ No wallets found!");
        } else {
            for (Wallet wallet : wallets) {
                System.out.println(" Wallet: " + wallet.getName() + " | Balance: $" + wallet.getBalance());
            }
        }
    }
}

