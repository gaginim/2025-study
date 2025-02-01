package com.tommy.study.domain.payment.service;

import com.tommy.study.domain.payment.dto.PGTransactionCreateAble;
import com.tommy.study.domain.payment.entity.PGTransaction;
import java.util.Optional;

public interface PaymentDispatch {

  Optional<PGTransaction> dispense(PGTransactionCreateAble pgTransactionCreateAble);
}
