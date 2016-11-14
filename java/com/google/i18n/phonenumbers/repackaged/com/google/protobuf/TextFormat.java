package com.google.i18n.phonenumbers.repackaged.com.google.protobuf;

import java.io.IOException;
import java.util.logging.Logger;

public final class TextFormat {
    private static final Logger a = Logger.getLogger(TextFormat.class.getName());
    private static final a b = new a();
    private static final a c = new a().a(true);
    private static final a d = new a().b(false);
    private static final Parser e = Parser.a().a();

    static class AnonymousClass1 {
    }

    public static class ParseException extends IOException {
    }

    public static class Parser {
        private final boolean a;
        private final SingularOverwritePolicy b;

        public enum SingularOverwritePolicy {
            ALLOW_SINGULAR_OVERWRITES,
            FORBID_SINGULAR_OVERWRITES
        }

        public static class a {
            private boolean a = false;
            private SingularOverwritePolicy b = SingularOverwritePolicy.ALLOW_SINGULAR_OVERWRITES;

            public Parser a() {
                return new Parser(this.a, this.b);
            }
        }

        private Parser(boolean allowUnknownFields, SingularOverwritePolicy singularOverwritePolicy) {
            this.a = allowUnknownFields;
            this.b = singularOverwritePolicy;
        }

        public static a a() {
            return new a();
        }
    }

    static final class a {
        boolean a;
        boolean b;

        private a() {
            this.a = false;
            this.b = true;
        }

        private a a(boolean singleLineMode) {
            this.a = singleLineMode;
            return this;
        }

        private a b(boolean escapeNonAscii) {
            this.b = escapeNonAscii;
            return this;
        }
    }

    private TextFormat() {
    }
}
