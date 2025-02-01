package com.tommy.study.domain.payment.service.handler;

import com.tommy.study.domain.payment.dto.PGTransactionCreateAble;
import com.tommy.study.domain.payment.entity.PGTransaction;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class BillKeyTransactionCreateHandler implements PGTransactionCreateHandler {

  @Override
  public Optional<PGTransaction> converter(PGTransactionCreateAble pgTransactionCreateAble) {
    return Optional.empty();
  }
}
