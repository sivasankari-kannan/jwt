package keyLoader;

import org.bouncycastle.util.io.pem.PemReader;
import java.io.FileReader;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class SimpleKeyLoader {
    public static RSAPrivateKey loadPrivateKey(String path) throws Exception {
        PemReader reader = new PemReader(new FileReader(path));
        byte[] content = reader.readPemObject().getContent();
        reader.close();
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return (RSAPrivateKey) keyFactory.generatePrivate(new java.security.spec.PKCS8EncodedKeySpec(content));
    }

    public static RSAPublicKey loadPublicKey(String path) throws Exception {
        PemReader reader = new PemReader(new FileReader(path));
        byte[] content = reader.readPemObject().getContent();
        reader.close();
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return (RSAPublicKey) keyFactory.generatePublic(new java.security.spec.X509EncodedKeySpec(content));
    }


}
