package br.com.juliano.javaee.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "converterLocalDate", forClass = LocalDate.class)
public class LocalDateConverter implements Converter<LocalDate> {

    private static final Locale LOCALE = new Locale("pt", "BR");
    private static final DateTimeFormatter FORMATTER_SIMPLE = DateTimeFormatter.ofPattern("dd/MM");
    private static final DateTimeFormatter FORMATTER_FULL = DateTimeFormatter.ofPattern("dd/MM/yyyy", LOCALE);

    @Override
    public LocalDate getAsObject(FacesContext context, UIComponent component, String value) {
        boolean isEmpty = value == null ? true : value.trim().isEmpty();

        FacesMessage msg = new FacesMessage("Data inválida");

        if (isEmpty) {
            throw new ConverterException(msg);
        }

        /*
         * Verifica se a data é dia/mês, se for verdadeiro é convertido para LocalDate. Caso for falso, converte com data
         * completa para LocalDate.
         */
        String pattern = "[0-9]{2}/[0-9]{2}";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(value);

        LocalDate date = null;

        if (m.matches()) {

            String[] token = value.split("/");
            date = LocalDate.of(0, Integer.valueOf(token[1]), Integer.valueOf(token[0]));
            return date;

        } else {
            try {
                date = LocalDate.parse(value, FORMATTER_FULL);
                return date;
            } catch (DateTimeParseException e) {
                throw new ConverterException(e);
            }

        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, LocalDate date) {
        int year = date.getYear();
        if (year == 0) {
            return date.format(FORMATTER_SIMPLE);
        }

        return date.format(FORMATTER_FULL);
    }

}
