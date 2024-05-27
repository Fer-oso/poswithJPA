package controllers.utils;

import java.text.DecimalFormat;

public  class FormatNumber {

    private FormatNumber() {
    }

    public static String formatNumber(double number) {
        // Crear un objeto DecimalFormat para formatear el número con 3 decimales
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.000");
        
        // Formatear el número
        String formattedNumber = decimalFormat.format(number);
        
        return formattedNumber;
    }
    
}