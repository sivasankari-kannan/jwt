package com.jwt.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import static keyLoader.SimpleKeyLoader.loadPrivateKey;
import static keyLoader.SimpleKeyLoader.loadPublicKey;

@SpringBootApplication
public class JwtApplication {

	public static void main(String[] args) {SpringApplication.run(JwtApplication.class, args);
		try {

			RSAPrivateKey privateKey = loadPrivateKey("private_key.pem");
			RSAPublicKey publicKey = loadPublicKey("public_key.pem");

			System.out.println("Private Key: " + privateKey);
			System.out.println("Public Key: " + publicKey);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
