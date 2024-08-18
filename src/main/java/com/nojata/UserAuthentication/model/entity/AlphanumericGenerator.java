package com.nojata.UserAuthentication.model.entity;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Properties;
import org.hibernate.boot.model.relational.Database;
import org.springframework.stereotype.Component;

@Component
public class AlphanumericGenerator implements IdentifierGenerator {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int LENGTH = 10;

    @Override
    public Serializable generate(SharedSessionContractImplementor ssci, Object o) throws HibernateException {
        StringBuilder idBuilder = new StringBuilder();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            idBuilder.append(CHARACTERS.charAt(index));
        }
        return idBuilder.toString();
    }

    @Override
    public void configure(org.hibernate.type.Type type, Properties params, org.hibernate.service.ServiceRegistry serviceRegistry) {
        // No specific configuration needed
    }

    public void registerExportables(Database database) {
        //IdentifierGenerator.super.registerExportables(database); //To change body of generated methods, choose Tools | Templates.
    }
}
