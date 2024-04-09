package com.dungken.scientificresearch2024backend.service;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.File;
@Service
public class OWLFileReader {
    public OWLOntology readOWLFile(String filePath) {
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        OWLOntology ontology = null;
        try {
            ontology = manager.loadOntologyFromOntologyDocument(new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ontology;
    }
}
