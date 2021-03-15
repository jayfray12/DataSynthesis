package com.redhat.idaas.datasynthesis.services;

import com.redhat.idaas.datasynthesis.models.RefDataApplicationEntity;

public class DefaultApplication {
    public static void seed() {
        RefDataApplicationEntity app = new RefDataApplicationEntity();
        app.setAppGuid("common");
        app.setApplicationCustomCode("DSynth");
        app.persist();       
    }
}
