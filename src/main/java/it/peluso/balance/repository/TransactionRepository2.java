package it.peluso.balance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.peluso.balance.entity.Transaction;
import it.peluso.balance.model.TransactionModel;
import it.peluso.balance.util.TransactionUtil;

public interface TransactionRepository2 {

    void save(TransactionModel model);

    class Iml implements TransactionRepository2{

        private final JpaRepository<Transaction, Long> springRepo;

        public Iml(JpaRepository<Transaction, Long> springRepo) {
            this.springRepo = springRepo;
        }

        @Override
        public void save(TransactionModel model) {
            Transaction transaction = TransactionUtil.transactionRequestToEntity(model);
            springRepo.save(transaction);
        }
    }

}
