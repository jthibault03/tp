package seedu.voyagers.utils;

public enum Currency {
    USD("US Dollar", "$", "USD"),
    EUR("Euro", "€", "EUR"),
    GBP("British Pound", "£", "GPB"),
    JPY("Japanese Yen", "¥", "JPY"),
    AUD("Australian Dollar", "$", "AUD"),
    CAD("Canadian Dollar", "$", "CAD"),
    CHF("Swiss Franc", "CHF", "CHF"),
    CNY("Chinese Yuan Renminbi", "¥", "CNY"),
    SEK("Swedish Krona", "kr", "SEK"),
    NZD("New Zealand Dollar", "$", "NZD"),
    MXN("Mexican Peso", "$", "MXN"),
    SGD("Singapore Dollar", "$", "SGD"),
    HKD("Hong Kong Dollar", "$", "HKD"),
    NOK("Norwegian Krone", "kr", "NOK"),
    KRW("South Korean Won", "W", "KRW"),
    TRY("Turkish Lira", "₺", "TRY"),
    RUB("Russian Ruble", "₽", "RUB"),
    INR("Indian Rupee", "₹", "INR"),
    BRL("Brazilian Real", "R$", "BRL"),
    ZAR("South African Rand", "R", "ZAR");

    //Default conversion rates from SGD to other currencies
    public static final double SGDTOEUR = 0.63;
    public static final double SGDTOUSD = 0.74;
    public static final double SGDTOGBP = 0.54;
    public static final double SGDTOJPY = 80.0;
    public static final double SGDTOAUD = 1.0;
    public static final double SGDTOCAD = 0.94;
    public static final double SGDTOCHF = 0.68;
    public static final double SGDTOCNY = 4.8;
    public static final double SGDTOSEK = 6.5;
    public static final double SGDTONZD = 1.1;
    public static final double SGDTOMXN = 15.0;
    public static final double SGDTOHKD = 5.7;
    public static final double SGDTONOK = 6.5;
    public static final double SGDTOKRW = 850.0;
    public static final double SGDTOTRY = 6.5;
    public static final double SGDTORUB = 55.0;
    public static final double SGDTOINR = 55.0;
    public static final double SGDTOBRL = 4.5;
    public static final double SGDTOZAR = 11.0;

    private final String name;
    private final String symbol;
    private final String code;

    Currency(String name, String symbol, String code) {
        this.name = name;
        this.symbol = symbol;
        this.code = code;
    }

    public double currencyConversion(double foreignCurrencyAmount, double conversionRate) {
        return foreignCurrencyAmount * conversionRate;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public static Currency getCurr(String currString) {
        for (Currency c : Currency.values()) {
            if (c.getCode().equals(currString)) {
                return c;
            }
        }
        throw new IllegalArgumentException("Invalid currency code.");
    }

    public String getSymbol() {
        return symbol;
    }


    /*public Currency getEnum(String name) {

    }*/
}


