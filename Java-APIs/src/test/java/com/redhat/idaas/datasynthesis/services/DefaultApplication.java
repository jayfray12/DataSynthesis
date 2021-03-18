package com.redhat.idaas.datasynthesis.services;

import com.redhat.idaas.datasynthesis.models.RefDataApplicationEntity;
import com.redhat.idaas.datasynthesis.models.RefDataStatusEntity;

public class DefaultApplication {
    public static void seed() {
        RefDataApplicationEntity app = new RefDataApplicationEntity();
        app.setAppGuid("common");
        app.setApplicationCustomCode("DSynth");
        app.persist(); 

        RefDataStatusEntity status = new RefDataStatusEntity();
        status.setStatusDescription("Active");
        status.persist();
    }
}
