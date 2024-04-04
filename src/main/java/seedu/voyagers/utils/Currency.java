package seedu.voyagers.utils;

public enum Currency {
    USD("US Dollar", "$"),
    EUR("Euro", "€"),
    GBP("British Pound", "£"),
    JPY("Japanese Yen", "¥"),
    AUD("Australian Dollar", "$"),
    CAD("Canadian Dollar", "$"),
    CHF("Swiss Franc", "CHF"),
    CNY("Chinese Yuan Renminbi", "¥"),
    SEK("Swedish Krona", "kr"),
    NZD("New Zealand Dollar", "$"),
    MXN("Mexican Peso", "$"),
    SGD("Singapore Dollar", "$"),
    HKD("Hong Kong Dollar", "$"),
    NOK("Norwegian Krone", "kr"),
    KRW("South Korean Won", "W"),
    TRY("Turkish Lira", "₺"),
    RUB("Russian Ruble", "₽"),
    INR("Indian Rupee", "₹"),
    BRL("Brazilian Real", "R$"),
    ZAR("South African Rand", "R");

    private final String name;
    private final String symbol;

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

    Currency(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public double CurrencyConversion(double foreignCurrencyAmount, double conversionRate) {
        return foreignCurrencyAmount * conversionRate;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }
}


