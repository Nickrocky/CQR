package com.nickrocky.cqr.data;

import com.nickrocky.cqr.util.PackageType;
import lombok.Getter;

import static com.nickrocky.cqr.util.PackageType.*;

@Getter
public enum CharacterSet {

    a(0, "a", (byte) 0b00000000, WHITE, WHITE),
    b(1, "b", (byte) 0b00000001, WHITE, GRAY),
    c(2, "c", (byte) 0b00000010, WHITE, YELLOW),
    d(3, "d", (byte) 0b00000011, WHITE, DARK_YELLOW),
    e(4, "e", (byte) 0b00000100, WHITE, MAGENTA),
    f(5, "f", (byte) 0b00000101, WHITE, DARK_MAGENTA),
    g(6, "g", (byte) 0b00000110, WHITE, RED),
    h(7, "h", (byte) 0b00000111, WHITE, DARK_RED),
    i(8, "i", (byte) 0b00001000, WHITE, CYAN),
    j(9, "j", (byte) 0b00001001, WHITE, DARK_CYAN),
    k(10, "k", (byte) 0b00001010, WHITE, GREEN),
    l(11, "l", (byte) 0b00001011, WHITE, DARK_GREEN),
    m(12, "m", (byte) 0b00001100, WHITE, BLUE),
    n(13, "n", (byte) 0b00001101, WHITE, DARK_BLUE),
    o(14, "o", (byte) 0b00001110, WHITE, DARK_GRAY),
    p(15, "p", (byte) 0b00001111, WHITE, BLACK),
    q(16, "q", (byte) 0b00010000, GRAY, WHITE),
    r(17, "r", (byte) 0b00010001, GRAY, GRAY),
    s(18, "s", (byte) 0b00010010, GRAY, YELLOW),
    t(19, "t", (byte) 0b00010011, GRAY, DARK_YELLOW),
    u(20, "u", (byte) 0b00010100, GRAY, MAGENTA),
    v(21, "v", (byte) 0b00010101, GRAY, DARK_MAGENTA),
    w(22, "w", (byte) 0b00010110, GRAY, RED),
    x(23, "x", (byte) 0b00010111, GRAY, DARK_RED),
    y(24, "y", (byte) 0b00011000, GRAY, CYAN),
    z(25, "z", (byte) 0b00011001, GRAY, DARK_CYAN),
    A(26, "A", (byte) 0b00011010, GRAY, GREEN),
    B(27, "B", (byte) 0b00011011, GRAY, DARK_GREEN),
    C(28, "C", (byte) 0b00011100, GRAY, BLUE),
    D(29, "D", (byte) 0b00011101, GRAY, DARK_BLUE),
    E(30, "E", (byte) 0b00011110, GRAY, DARK_GRAY),
    F(31, "F", (byte) 0b00011111, GRAY, BLACK),
    G(32, "G", (byte) 0b00100000, YELLOW, WHITE),
    H(33, "H", (byte) 0b00100001, YELLOW, GRAY),
    I(34, "I", (byte) 0b00100010, YELLOW, YELLOW),
    J(35, "J", (byte) 0b00100011, YELLOW, DARK_YELLOW),
    K(36, "K", (byte) 0b00100100, YELLOW, MAGENTA),
    L(37, "L", (byte) 0b00100101, YELLOW, DARK_MAGENTA),
    M(38, "M", (byte) 0b00100110, YELLOW, RED),
    N(39, "N", (byte) 0b00100111, YELLOW, DARK_RED),
    O(40, "O", (byte) 0b00101000, YELLOW, CYAN),
    P(41, "P", (byte) 0b00101001, YELLOW, DARK_CYAN),
    Q(42, "Q", (byte) 0b00101010, YELLOW, GREEN),
    R(43, "R", (byte) 0b00101011, YELLOW, DARK_GREEN),
    S(44, "S", (byte) 0b00101100, YELLOW, BLUE),
    T(45, "T", (byte) 0b00101101, YELLOW, DARK_BLUE),
    U(46, "U", (byte) 0b00101110, YELLOW, DARK_GRAY),
    V(47, "V", (byte) 0b00101111, YELLOW, BLACK),
    W(48, "W", (byte) 0b00110000, DARK_YELLOW, WHITE),
    X(49, "X", (byte) 0b00110001, DARK_YELLOW, GRAY),
    Y(50, "Y", (byte) 0b00110010, DARK_YELLOW, YELLOW),
    Z(51, "Z", (byte) 0b00110011, DARK_YELLOW, DARK_YELLOW),
    ZERO(52, "0", (byte) 0b00110100, DARK_YELLOW, MAGENTA),
    ONE(53,  "1", (byte) 0b00110101, DARK_YELLOW, DARK_MAGENTA),
    TWO(54, "2", (byte) 0b00110110, DARK_YELLOW, RED),
    THREE(55, "3", (byte) 0b00110111, DARK_YELLOW, DARK_RED),
    FOUR(56, "4", (byte) 0b00111000, DARK_YELLOW, CYAN),
    FIVE(57, "5", (byte) 0b00111001, DARK_YELLOW, DARK_CYAN),
    SIX(58, "6", (byte) 0b00111010, DARK_YELLOW, GREEN),
    SEVEN(59, "7", (byte) 0b00111011, DARK_YELLOW, DARK_GREEN),
    EIGHT(60, "8", (byte) 0b00111100, DARK_YELLOW, BLUE),
    NINE(61, "9", (byte) 0b00111101, DARK_YELLOW, DARK_BLUE),
    FORWARD_SLASH(62, "/", (byte) 0b00111110, DARK_YELLOW, DARK_GRAY),
    COLON(63, ":", (byte) 0b00111111, DARK_YELLOW, BLACK),
    PERIOD(64, ".", (byte) 0b01000000, MAGENTA, WHITE),
    AT(65, "@", (byte) 0b00100001, MAGENTA, GRAY),
    MONEY(66, "$", (byte) 0b00100010, MAGENTA, YELLOW),
    PERCENT(67, "%", (byte) 0b00100011, MAGENTA, DARK_YELLOW),
    POUND(68, "#", (byte) 0b00100100, MAGENTA, MAGENTA),
    QUESTION(69, "?", (byte) 0b00100101, MAGENTA, DARK_MAGENTA),
    EXCLAMATION(70, "!", (byte) 0b00100110, MAGENTA, RED),
    PLUS(71, "+", (byte) 0b00100111, MAGENTA, DARK_RED),
    MINUS(72, "-", (byte) 0b00101000, MAGENTA, CYAN),
    BACKSLASH(73, "\\", (byte) 0b00101001, MAGENTA, DARK_CYAN),
    UNDERSCORE(74, "_", (byte) 0b00101010, MAGENTA, GREEN),
    APOSTROPHE(75, "'", (byte) 0b00101011, MAGENTA, DARK_GREEN),
    QUOTE(76, "\"", (byte) 0b00101100, MAGENTA, BLUE),
    LEFT_PAREN(77,"(", (byte) 0b00101101, MAGENTA, DARK_BLUE),
    RIGHT_PAREN(78,")", (byte) 0b00101110, MAGENTA, DARK_GRAY),
    LESS_THAN(79, "<", (byte) 0b00101111, MAGENTA, BLACK),
    GREATER_THAN(80, ">", (byte) 0b00110000, DARK_MAGENTA, WHITE),
    EQUAL(81, "=", (byte) 0b00110001, DARK_MAGENTA, GRAY),
    CARROT(82, "^", (byte) 0b00110010, DARK_MAGENTA, YELLOW),
    AMP(83, "&", (byte) 0b00110011, DARK_MAGENTA, DARK_YELLOW),
    STAR(84, "*", (byte) 0b00110100, DARK_MAGENTA, MAGENTA),
    COMMA(85, ",", (byte) 0b00110101, DARK_MAGENTA, DARK_MAGENTA),
    HTTPS(86, "https://", (byte) 0b00110110, DARK_MAGENTA, RED),
    HTTP(87,"http://", (byte) 0b00110111, DARK_MAGENTA, DARK_RED),
    WWW(88, "www.", (byte) 0b00111000, DARK_MAGENTA, CYAN),
    COM(89, ".com", (byte) 0b00111001, DARK_MAGENTA, DARK_CYAN),
    NET(90, ".net", (byte) 0b00111010, DARK_MAGENTA, GREEN),
    ORG(91, ".org", (byte) 0b00111011, DARK_MAGENTA, DARK_GREEN),
    EDU(93, ".edu", (byte) 0b00111101, DARK_MAGENTA, BLUE),
    IO(94, ".io", (byte) 0b00111110, DARK_MAGENTA, DARK_BLUE),
    SPACE(95, " ", (byte) 0b00111111, DARK_MAGENTA, DARK_GRAY)
    ;

    private final int number;
    private final byte bVal;
    private final String value;
    private final PackageType primary, secondary;

    CharacterSet(int number, String value, byte bVal, PackageType secondary, PackageType primary){
        this.number = number;
        this.bVal = bVal;
        this.value = value;
        this.primary = primary;
        this.secondary = secondary;
    }

    public static PackageType[] getPackageFromChar(String c){
        for(CharacterSet characterSet : CharacterSet.values()){
            if(c.equalsIgnoreCase(";")) return new PackageType[]{CharacterSet.COMMA.getPrimary(), CharacterSet.COMMA.getSecondary()};
            if(characterSet.getValue().equalsIgnoreCase(c)){
                return new PackageType[]{characterSet.getPrimary(), characterSet.getSecondary()};
            }
        }
        return null;
    }

    public static String getFromPackage(PackageType primary, PackageType secondary){
        for(CharacterSet characterSet : CharacterSet.values()){
            if(primary == characterSet.getPrimary() && secondary == characterSet.getSecondary()){
                return characterSet.getValue();
            }
        }
        return "";
    }

}
