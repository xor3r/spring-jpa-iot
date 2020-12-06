package com.pazyniuk.service;

import com.pazyniuk.domain.CreditCard;
import com.pazyniuk.exceptions.NoSuchObjectException;
import com.pazyniuk.exceptions.ReferencesPrensetException;
import com.pazyniuk.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CreditCardService {

    @Autowired
    CreditCardRepository creditCardRepository;

    public CreditCard getCreditCard(long creditCardId) throws NoSuchObjectException {
        if (creditCardRepository.findById(creditCardId).isPresent()) {
            return creditCardRepository.findById(creditCardId).get();
        }
        else {
            throw new NoSuchObjectException();
        }
    }

    public List<CreditCard> getAllCreditCards() {
        return creditCardRepository.findAll();
    }

    @Transactional
    public void createCreditCard(CreditCard creditCard) {
        creditCardRepository.save(creditCard);
    }

    @Transactional
    public void updateCreditCard(CreditCard newCreditCard, long creditCardId) throws NoSuchObjectException {
        if (creditCardRepository.findById(creditCardId).isPresent()) {
            CreditCard creditCard = creditCardRepository.findById(creditCardId).get();
            creditCard.setNumber(newCreditCard.getNumber());
            creditCard.setItunesUser(newCreditCard.getItunesUser());
        }
        else {
            throw new NoSuchObjectException();
        }
    }

    @Transactional
    public void deleteCreditCard(long creditCardId) throws NoSuchObjectException, ReferencesPrensetException {
        if (creditCardRepository.findById(creditCardId).isPresent()) {
            CreditCard creditCard = creditCardRepository.findById(creditCardId).get();
            if (creditCard.getItunesUser() != null) throw new ReferencesPrensetException();
            else creditCardRepository.delete(creditCard);
        }
        else {
            throw new NoSuchObjectException();
        }
    }
}
