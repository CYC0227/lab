package yc.lab.woo;

import java.util.Arrays;

public enum RetryCommand {
    QUIT('Q'), RETRY('R');

    private final char value;

    RetryCommand(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public static RetryCommand of(char c) {
        if (c != 'R' && c != 'Q')
            throw new IllegalArgumentException("잘못된 RetryCommand 입력.");
        if (c == 'Q')
            return QUIT;
        return RETRY;
    }
}
//
//public enum RematchMenu {
//    REMATCH("네"),
//    NO_OP("아니오");
//
//    private final String symbol;
//
//    RematchMenu(String symbol) {
//        this.symbol = symbol;
//    }
//
//    public static RematchMenu of(String symbol) {
//        return Arrays.stream(RematchMenu.values())
//                .filter(menu -> menu.getSymbol().equals(symbol))
//                .findAny()
//                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 올바른 입력이 아닙니다."));
//    }
//
//    public String getSymbol() {
//        return symbol;
//    }
//}
