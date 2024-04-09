package com.dungken.scientificresearch2024backend.controller;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ontology")
public class OwlApiController {

    @GetMapping("/data")
    public List<OntologyItem> getOntologyData() {
        List<OntologyItem> ontologyItems = new ArrayList<>();

        try {
            // Load tệp .owl từ resources
            Resource resource = new ClassPathResource("ontologies/discreteMathematics.owl");
            InputStream inputStream = resource.getInputStream();

            // Tạo một OWLOntologyManager
            OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

            // Load ontology từ InputStream
            OWLOntology ontology = manager.loadOntologyFromOntologyDocument(inputStream);

            // Lấy tất cả các lớp trong ontology và thêm vào danh sách ontologyItems
            List<OWLClass> classes = ontology.classesInSignature().collect(Collectors.toList());
            for (OWLClass cls : classes) {
                String title = cls.getIRI().getShortForm(); // Tiêu đề là tên ngắn của lớp

                // Trích xuất nội dung của lớp và gán vào trường content của OntologyItem
                String content = extractContentFromOntology(cls); // Đây là phương thức bạn cần triển khai

                OntologyItem item = new OntologyItem(title, content);
                ontologyItems.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ontologyItems;
    }

    // Phương thức để trích xuất nội dung của mỗi lớp từ ontology
    private String extractContentFromOntology(OWLClass cls) {
        StringBuilder content = new StringBuilder();

        // Lấy tên của lớp
        content.append("Class Name: ").append(cls.getIRI().getShortForm()).append("\n");

        OWLOntology ontology = null;

        try {
            // Tạo một đối tượng ClassLoader để tải tệp từ thư mục resources
            ClassLoader classLoader = getClass().getClassLoader();

            // Sử dụng ClassLoader để lấy InputStream của tệp ontology
            InputStream inputStream = classLoader.getResourceAsStream("ontologies/discreteMathematics.owl");

            // Tạo một OWLOntologyManager và load ontology từ InputStream
            OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
            ontology = manager.loadOntologyFromOntologyDocument(inputStream);
        } catch (OWLOntologyCreationException e) {
            e.printStackTrace();
        }

        ontology.annotationAssertionAxioms(cls.getIRI())
                .forEach(axiom -> {
                    OWLAnnotation annotation = axiom.getAnnotation();
                    OWLAnnotationValue value = annotation.getValue();
                    if (value instanceof OWLLiteral) {
                        content.append("Annotation: ").append(((OWLLiteral) value).getLiteral()).append("\n");
                    }
                });


        // Lấy danh sách các lớp con của lớp
        content.append("Subclasses: ");
        for (OWLClassExpression subClass : cls.getClassesInSignature()) {
            if (!subClass.isAnonymous()) {
                content.append(subClass.asOWLClass().getIRI().getShortForm()).append(", ");
            }
        }

        content.append("\n");

        return content.toString();
    }

    // Định nghĩa lớp OntologyItem để đại diện cho mỗi mục trong ontology
    class OntologyItem {
        private String title;
        private String content;

        public OntologyItem(String title, String content) {
            this.title = title;
            this.content = ""; // Bạn có thể thêm nội dung vào đây nếu cần
        }

        // Getters và setters

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}