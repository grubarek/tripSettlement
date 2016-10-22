package pl.agh.id.tripsettlement.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * Klasa wspomagająca, zajmuje się czynnościami dotyczącymi szyfrowania
 */
public class CryptoUtil {

    /**
     * Generuje sól hasla
     *
     * @return sól hasla
     */
    public static String generateSalt() {
        return DigestUtils.sha512Hex(new Date().toString() + UUID.randomUUID().toString());
    }

    /**
     * Generuje hash zakodowany sha512 z kombinacji hasla i soli
     *
     * @param password haslo
     * @param salt     sol hasla
     * @return hash hasla
     */
    public static String getPasswordHash(String password, String salt) {
        return DigestUtils.sha512Hex(salt + password);
    }

    /**
     * Zwraca md5 wyliczone z pliku
     *
     * @param file plik z ktorego ma zostac wyliczone md5
     * @return ciag znakow zakodowany w md5
     * @throws IOException jesli wystapi blad podczas realizacji operacji
     */
    public static String getMD5(File file) throws IOException {

        String md5;

        try (FileInputStream fis = new FileInputStream(file)) {
            md5 = DigestUtils.md5Hex(fis);
        }
        return md5;
    }

    /**
     * Dekoduje zakodowany w Base64 ciag znakow, przekazany w parametrze
     *
     * @param data zakodowany ciag znakow przekazany w parametrze
     * @return odkodowany ciag znakow
     */
    public static byte[] decodeBase64(String data) {
        return org.apache.commons.codec.binary.Base64.decodeBase64(data.getBytes());
    }

    /**
     * Zwraca ciag znakow zawierajacy zakodowany w Base64 ciag znakow przekazany jako parametr
     *
     * @param data ciag znakow do zakodowania
     * @return zakodowany ciag znakow
     */
    public static String encodeBase64(String data) {
        byte[] encodedString = org.apache.commons.codec.binary.Base64.encodeBase64(data.getBytes());

        return new String(encodedString);
    }

    /**
     * Zwraca ciag znakow zawierajacy zakodowana w Base64 tablice bajtow przekazana jako parametr
     *
     * @param bytes tablica bajtow do zakodowania
     * @return zakodowany ciag znakow
     */
    public static String encodeBase64(byte[] bytes) {
        byte[] encodedString = org.apache.commons.codec.binary.Base64.encodeBase64(bytes);
        return new String(encodedString);
    }


    public static long getKey(String keyId) {
        long key = 0;
        byte[] receivedKey = CryptoUtil.decodeBase64(keyId);
        for (int i = 0; i < receivedKey.length; i++) {
            key = (key << 8) + (receivedKey[i] & 0xff);
        }
        return key;
    }

}
