package com.google.i18n.phonenumbers.repackaged.com.google.protobuf.micro;

import java.io.IOException;

public final class CodedOutputStreamMicro {

    public static class OutOfSpaceException extends IOException {
        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }
}
