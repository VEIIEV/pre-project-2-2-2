package org.example.preproject222.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.incomespringbootstarter.integration.IncomeClient;
import org.example.preproject222.config.LoanProperties;
import org.example.preproject222.dao.UserDao;
import org.example.preproject222.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoanService {

    private final UserDao userDao;
    private final IncomeClient incomeClient;
    private final LoanProperties loanProperties;

    @Autowired
    public LoanService(UserDao userDao, IncomeClient incomeClient, LoanProperties loanProperties) {
        this.userDao = userDao;
        this.incomeClient = incomeClient;
        this.loanProperties = loanProperties;
    }


    public String approveCredit(Long userId) {

        Optional<User> optionalUser = userDao.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new EntityNotFoundException("user not found");
        }

        int carCost = optionalUser.get().getCar().getCost();
        int income = incomeClient.getUserIncome(userId).getIncome();
        int bestOffer = calculateBestOffer(carCost, income);
        if (bestOffer != 0) {
            return "you have been approved for a loan in the amount of { " + bestOffer + " }.";
        }
        return "you were denied a loan";

    }

    private int calculateBestOffer(int carCost, int income) {
        if (income > loanProperties.getMinRevenue() && carCost > loanProperties.getMinCarValue()) {
            int OfferByCarCost = (int) (carCost * 0.3);
            int OfferByIncome = income * 6;
            return Math.max(OfferByCarCost, OfferByIncome);
        }
        return 0;
    }
}
