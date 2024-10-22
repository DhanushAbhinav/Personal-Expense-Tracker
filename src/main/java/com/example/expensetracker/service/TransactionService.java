package com.example.expensetracker.service;

import com.example.expensetracker.model.Transaction;
import com.example.expensetracker.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    public Transaction updateTransaction(Long id, Transaction updatedTransaction) {
        return transactionRepository.findById(id)
            .map(transaction -> {
                transaction.setType(updatedTransaction.getType());
                transaction.setCategory(updatedTransaction.getCategory());
                transaction.setAmount(updatedTransaction.getAmount());
                transaction.setDate(updatedTransaction.getDate());
                transaction.setDescription(updatedTransaction.getDescription());
                return transactionRepository.save(transaction);
            }).orElseThrow(() -> new RuntimeException("Transaction not found with id " + id));
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    public double getTotalIncome() {
        return transactionRepository.findAll().stream()
            .filter(transaction -> transaction.getType().equals("income"))
            .mapToDouble(Transaction::getAmount).sum();
    }

    public double getTotalExpenses() {
        return transactionRepository.findAll().stream()
            .filter(transaction -> transaction.getType().equals("expense"))
            .mapToDouble(Transaction::getAmount).sum();
    }

    public double getBalance() {
        return getTotalIncome() - getTotalExpenses();
    }
}