package com.google.i18n.phonenumbers.repackaged.com.google.protobuf;

public final class RpcUtil {

    public static final class AlreadyCalledException extends RuntimeException {
        public AlreadyCalledException() {
            super("This RpcCallback was already called and cannot be called multiple times.");
        }
    }
}
