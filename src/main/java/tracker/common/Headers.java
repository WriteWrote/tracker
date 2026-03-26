package tracker.common;

import lombok.Getter;

@Getter
public enum Headers {
    SERVER_MESSAGE("Server message.");

    private final String value;
    Headers(String value) {
        this.value = value;
    }
}
