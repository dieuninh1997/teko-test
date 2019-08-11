package com.ninhttd.devtest.utils;

public enum  MessageKey {
    SUCCESS("messageSuccess"),
    NO_INTERNET_EXCEPTION("alert_internet_not_available"),
    UNKNOWN_EXCEPTION("alert_unknown_exception"),
    TIME_OUT_EXCEPTION("alert_request_time_out"),
    SERVER_NOT_AVAILABLE("alert_server_not_available");
    private String extension;

    MessageKey(String extension) {
        this.extension = extension;
    }

    public String getValue()
    {
        return extension;
    }
}
