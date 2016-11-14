package com.google.i18n.phonenumbers.repackaged.com.google.protobuf.nano;

import java.io.IOException;

public class InvalidProtocolBufferNanoException extends IOException {
    public InvalidProtocolBufferNanoException(String description) {
        super(description);
    }

    public static InvalidProtocolBufferNanoException a() {
        return new InvalidProtocolBufferNanoException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    public static InvalidProtocolBufferNanoException b() {
        return new InvalidProtocolBufferNanoException("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static InvalidProtocolBufferNanoException c() {
        return new InvalidProtocolBufferNanoException("CodedInputStream encountered a malformed varint.");
    }

    public static InvalidProtocolBufferNanoException d() {
        return new InvalidProtocolBufferNanoException("Protocol message contained an invalid tag (zero).");
    }

    public static InvalidProtocolBufferNanoException e() {
        return new InvalidProtocolBufferNanoException("Protocol message end-group tag did not match expected tag.");
    }

    public static InvalidProtocolBufferNanoException f() {
        return new InvalidProtocolBufferNanoException("Protocol message tag had invalid wire type.");
    }

    public static InvalidProtocolBufferNanoException g() {
        return new InvalidProtocolBufferNanoException("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }
}
