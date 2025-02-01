package com.tommy.study.domain.payment.service;

import com.tommy.study.domain.payment.dto.PGTransactionCreateAble;
import com.tommy.study.domain.payment.entity.PGTransaction;
import com.tommy.study.domain.payment.service.handler.PGTransactionCreateHandler;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PaymentDispatchImpl implements PaymentDispatch {

  private final List<PGTransactionCreateHandler> handlers;

  @Override
  public Optional<PGTransaction> dispense(PGTransactionCreateAble pgTransactionCreateAble) {
    Optional<PGTransaction> pgTransaction = Optional.empty();
    for (var handler : handlers) {
      try {
        pgTransaction = handler.converter(pgTransactionCreateAble);
      } catch (ClassCastException e) {
        continue;
      }
    }
    return pgTransaction;
  }
}
