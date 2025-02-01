package com.tommy.study.domain.payment.dto;

import com.tommy.study.domain.payment.enums.PGTransactionType;

public interface PGTransactionCreateAble {

  PGTransactionType getTransactionType();
}
