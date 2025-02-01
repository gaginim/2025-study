package com.tommy.study.domain.payment.entity;

import com.tommy.study.domain.payment.enums.PGTransactionType;
import jakarta.validation.constraints.NotNull;

public class PGTransaction {

  @NotNull private PGTransactionType transactionType;
}
