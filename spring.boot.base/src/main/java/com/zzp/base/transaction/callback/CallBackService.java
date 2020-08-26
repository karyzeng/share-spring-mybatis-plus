package com.zzp.base.transaction.callback;

import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @Description 事务完成后回调service
 * @Author Garyzeng
 * @since 2019.12.24
 **/
@Component
public class CallBackService {

    public void execute(final CallBackAction action) {

        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            // 有开启事务之后的回调
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                @Override
                public void afterCommit() {
                    // 事务提交后执行回调
                    action.callback();
                }
            });
        } else {
            // 未开启事务之后的回调
            action.callback();
        }

    }

}
