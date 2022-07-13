package com.vnightray.common.enums;

/**
 * 操作状态
 */
public enum OperationStatus {
    /**
     * 成功
     */
    SUCCESS(0),

    /**
     * 失败
     */
    FAIL(1),
    ;

    private int result;

    OperationStatus(int i) {
        result = i;
    }

    public int getResult() {
        return result;
    }
}
