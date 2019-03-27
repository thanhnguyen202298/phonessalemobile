package com.aln.phonesaleschain.notification;

public interface CallbackSSk<T> {
    void Success(T response, String message);
    void Fail(Throwable throwable);
}
