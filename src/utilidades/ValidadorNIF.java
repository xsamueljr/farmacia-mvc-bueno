package utilidades;

import java.util.Map;
import java.util.regex.Pattern;

public class ValidadorNIF {

    private static final Pattern formatoNif = Pattern.compile(
            "^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$"
    );

    private static final Map<Integer, Character> tabla = Map.ofEntries(
            Map.entry(0, 'T'),
            Map.entry(1, 'R'),
            Map.entry(2, 'W'),
            Map.entry(3, 'A'),
            Map.entry(4, 'G'),
            Map.entry(5, 'M'),
            Map.entry(6, 'Y'),
            Map.entry(7, 'F'),
            Map.entry(8, 'P'),
            Map.entry(9, 'D'),
            Map.entry(10, 'X'),
            Map.entry(11, 'B'),
            Map.entry(12, 'N'),
            Map.entry(13, 'J'),
            Map.entry(14, 'Z'),
            Map.entry(15, 'S'),
            Map.entry(16, 'Q'),
            Map.entry(17, 'V'),
            Map.entry(18, 'H'),
            Map.entry(19, 'L'),
            Map.entry(20, 'C'),
            Map.entry(21, 'K'),
            Map.entry(22, 'E')
    );

    private static final String LETRAS = "TRWAGMYFPDXBNJZSQVHLCKE";

    public static boolean ejecutar(String nif) {
        if (!elFormatoEsValido(nif)) return false;

        long parteNumerica = Long.parseLong(nif.substring(0, 8));
        char letra = nif.charAt(8);

        int resto = (int) parteNumerica % 23;
        Character letraCorrecta = LETRAS.charAt(resto);

        return letraCorrecta != null && letraCorrecta.equals(letra);
    }

    private static boolean elFormatoEsValido(String nif) {
        return formatoNif.matcher(nif).matches();
    }
}
