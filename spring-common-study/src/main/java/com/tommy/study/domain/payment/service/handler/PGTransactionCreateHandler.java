package com.tommy.study.domain.payment.service.handler;

import com.tommy.study.domain.payment.dto.PGTransactionCreateAble;
import com.tommy.study.domain.payment.entity.PGTransaction;
import java.util.Optional;

public interface PGTransactionCreateHandler {

  Optional<PGTransaction> converter(PGTransactionCreateAble pgTransactionCreateAble);
}
